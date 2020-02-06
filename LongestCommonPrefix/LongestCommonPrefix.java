/**
 * @ClassName LongestCommonPrefix
 * @Description: 最长公共前缀 编写一个函数来查找字符串数组中的最长公共前缀。
 * @Author 余霜
 * @Date 2019/12/6 22:12
 * @Version V1.0
 **/

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //把第一个字符串作为标准进行判断
        String s = strs[0];

        //循环整个数组
        for (int i = 1; i < strs.length; i++) {
            //判断当前字符是否存在标准前缀，如果不存在，就去除一位在判断，直到成功为止
            while (strs[i].indexOf(s) != 0) {
                s = s.substring(0, s.length() - 1);
                //在执行删除长度的时候也会出现直接剔除为0的情况，那么直接返回这个空串就好了
                if (s.length() == 0)
                    return s;
            }
        }
        return s;
    }
}
