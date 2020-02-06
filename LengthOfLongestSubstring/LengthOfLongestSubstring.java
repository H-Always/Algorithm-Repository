import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description: 无重复字符的最长子串
 * @Author 余霜
 * @Date 2019/12/4 22:41
 * @Version V1.0
 **/

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring_BF(String s) {
        if (s.length() == 0)
            return 0;
        StringBuilder max = new StringBuilder(String.valueOf(s.charAt(0)));
        StringBuilder temp = new StringBuilder(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (temp.indexOf(String.valueOf(s.charAt(j))) != -1)
                    break;
                temp.append(s.charAt(j));
                if (temp.length() > max.length()) {
                    max = temp;
                }
                if (j >= s.length() - 1)
                    return max.length();
            }
            temp = new StringBuilder(String.valueOf(s.charAt(i)));
        }

        return max.length();
    }


    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), max = 0;
        //建立一个map函数，用O(1)的时间复杂度来判断重复
        Map<Character, Integer> map = new HashMap<>();

        for (int begin = 0, end = 0; end < n; end++) {
            char temp = s.charAt(end);
            //判断是否重复，如果不重复就添加
            if (map.containsKey(temp)) {
                begin = Math.max(map.get(temp), begin);
            }
            //max = Math.max(max, end - begin + 1);
            max = (end - begin + 1)>max?end - begin + 1:max;
            //key:字母   value:不重复的下标，这里不重复是为了寻找begin的位置
            map.put(s.charAt(end), end + 1);
        }
        return max;
    }
}
