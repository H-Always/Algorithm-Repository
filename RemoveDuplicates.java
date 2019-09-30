package AlgorithmPackge;
/**
 * @ClassName RemoveDuplicates
 * @Description: TODO 删除字符串中的所有相邻重复项 II
 * @Author 余霜
 * @Date 2019/9/29 21:14
 * @Version V1.0
 **/

public class RemoveDuplicates {
    public String removeDuplicates(String s, int k) {
        //把给出的字符串转换成为数组，这里长度多了一个才会不越界(比较笨的一种方法)
        char[] ch = new char[s.length() +1];
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        int length = ch.length;
        int count = 0;
        int j;
        //判断是否有连续k个字符相等
        for (int i = 0; i < ch.length/k; i++) {
            for (j = 1; j < length; j++) {
                if (count == k - 1) {
                    delete(ch, k, j - k);
                    count = 0;
                    length -= k;
                    break;
                } else {
                    if (ch[j] == ch[j - 1]) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
            }
        }

        //因为要返回的是字符串，把数组转换成为字符串
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < length - 1; i++) {
            res.append(ch[i]);
        }

        return res.toString();
    }

    //这个方法是覆盖式的删除，把后面一个元素赋值给前面的元素，数组短点还能凑合用
    public void delete(char[] ch, int k, int i) {
        for (int q = 0; q < k; q++) {
            for (int j = i; j < ch.length - 1; j++) {
                ch[j] = ch[j + 1];
            }
        }
    }
}
