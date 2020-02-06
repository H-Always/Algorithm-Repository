/**
 * @ClassName RemoveDuplicatesPro
 * @Description: 删除字符串中的所有相邻重复项 II
 * @Author 余霜
 * @Date 2019/9/30 22:23
 * @Version V1.0
 **/

public class RemoveDuplicatesPro {
    public String removeDuplicatesPro(String s, int k) {
        int len = s.length();
        int count = 0;
        //这里有花了一下，让判断条件变成len/k，这是最多执行次数(还可以在优化的)
        for (int i = 0; i < len / k; i++) {
            //每完成一次就重新从头判断字符串，因为删除掉中间的可能会让前面出现新的重复字符
            for (int j = 1; j < s.length(); j++) {
                if (count == k - 1) {
                    s = deleteDuplicates(s, k, j);
                    count = 0;
                    break;
                } else {
                    if (s.charAt(j) == s.charAt(j - 1))
                        count++;
                    else
                        count = 0;
                }
            }
            //这里要加一个判断，因为可能重复出现在最后面
            if (count == k - 1) {
                s = deleteDuplicates(s, k, s.length());
                break;
            }
        }
        return s;
    }

    //返回一个新的字串，就是把中间的删除掉，只要两边的
    private String deleteDuplicates(String s, int k, int i) {
        return s.substring(0, i - k) + s.substring(i);
    }
}



