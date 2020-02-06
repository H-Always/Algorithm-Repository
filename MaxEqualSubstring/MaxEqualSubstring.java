/**
 * @ClassName MaxEqualSubstring
 * @Description: 尽可能使字符串相等(暴力求解)
 * @Author 余霜
 * @Date 2019/10/2 10:33
 * @Version V1.0
 **/

/**
 * LeetCode周塞题
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 */

public class MaxEqualSubstring {
    public int maxEqualSubstring(String s, String t, int maxCost) {
        int count = 0;
        int value = 0;
        int max = 0;

        //建立第一个数组，这个数组用来存放两个字符串的ASCII绝对值
        int[] temp = new int[Math.min(s.length(), t.length())];

        for (int i = 0; i < temp.length; i++)
            temp[i] = Math.abs(s.charAt(i) - t.charAt(i));

        //暴力搜索，如果当前跳出了if，就回溯，把i置为初始的下一个位置，继续搜索
        // (复杂度极差...)
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            value += temp[i];
            if (value <= maxCost) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
                value = 0;
                i = j++;
            }
        }

        return max;
    }
}






