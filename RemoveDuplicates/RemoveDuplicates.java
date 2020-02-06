/**
 * @ClassName RemoveDuplicates
     * @Description: 删除字符串中的所有相邻重复项 II
 * @Author 余霜
 * @Date 2019/9/29 21:14
 * @Version V1.0
 **/

/**
 * 删除字符串中的所有相邻重复项 II
 *
 * LeetCode周赛题
 *
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 *
 * 在执行完所有删除操作后，返回最终得到的字符串。
 *
 * 本题答案保证唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 *
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 */

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
        StringBuilder res = new StringBuilder();
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
