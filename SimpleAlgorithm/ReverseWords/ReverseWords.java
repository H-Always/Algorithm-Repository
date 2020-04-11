/**
 * @ClassName: ReverseWords
 * @Description: 翻转字符串里的单词
 * @Author: 余霜
 * @Date: 2020/04/10 17:03
 * @Version: V1.0
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

// 在我很菜的时候写过一个十分复杂的版本，是以"，"作为分隔，但是不同的是，即使两个分割符之间即使没有也要返回一个空位置，并且每一个单词也要翻转
// 现在看来写的是有点复杂了..
// 这个题思路灰常简单！首先去掉前后空格，不想用方法的同学也可以自己手写用while也很简单！
// 去掉空格之后用数组把每一个单词分开，然后从后往前遍历加到字符串里就好了...
// 这题我写了有七分多钟？
public class ReverseWords {

    public String reverseWords(String s) {
        //先去除前后空格
        s = s.trim();

        //如果去除之后长度为0，那么就返回
        if (s.length() == 0)
            return "";

        //用空格作为分界划分数组
        String[] part = s.split(" ");

        //创建一个字符串
        StringBuilder sb = new StringBuilder();

        //从后往前遍历，空不用添加
        for (int j = part.length - 1; j >= 0; j--) {
            if (part[j].equals(""))
                continue;
            sb.append(part[j]);
            sb.append(" ");
        }

        //返回的值要去掉最后一个空格
        return sb.deleteCharAt(sb.length() - 1).toString();

    }

}
