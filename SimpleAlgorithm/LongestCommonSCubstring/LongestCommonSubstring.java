import java.util.Arrays;

/**
 * @ClassName: LongestCommonSubstring
 * @Description: 最长公共子串
 * @Author: 余霜
 * @Date: 2020/05/22 10:35
 * @Version: V1.0
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/

// 这个题和代码不匹配，但是本质是一样的，这个代码是我在做最长回文子串的题，顺便看到了一个这个，就写了一下
// 下面的代码是给出一个字符串，判断他的反转字符串和本身的最长公共子串是什么
// 动态规划，先开辟一个二维数组dp，然后两个for遍历，如果arr1[i] == arr2[j] 那么对应的dp[i][j] == dp[i-1][j-1]+1
// 如果这两个子串的字符相等，则这存在公共子串，要判断前一个字符是不是也相等(dp[i-1][j-1]!=0)，相等的话就在原来的基础上+1,不相等就置为1
// 边界条件考虑一下就好了，
public class LongestCommonSubstring {
    public String longestCommonSubstring(String s) {
        //如果字符串为空，则返回空
        if (s.equals(""))
            return "";
        
        //反转字符串
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();

        //开辟一个二维数组
        int[][] dp = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;

        //算法核心，动态规划，转移方程为 dp[i][j] = dp[i - 1][j - 1] + 1，本质上还是一个一个比...省时间浪费空间
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }

                //如果比已有的最长子串长，则更新位置，
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    maxEnd = i;
                }

            }

        // 方便理解还可以把dp打印出来
        // for (int[] ints : dp)
        //    System.out.println(Arrays.toString(ints));

        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }



    //又补了一个最长公共子序,不过好像写的有点点复杂，好像dp再加一层用来初始化比较好
    public int longestCommonSubsequence(String text1, String text2) {
        //如果字符串为空，则返回空
        if (text1.equals("")||text2.equals(""))
            return 0;
        //开辟一个二维数组
        int[][] dp = new int[text1.length()][text2.length()];
        int maxLen = 0;
        int maxEnd = 0;

        //算法核心，动态规划
        for (int i = 0; i < text1.length(); i++)
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }else{
                    if (i==0&&j==0) {
                        dp[i][j] = 0;
                    } else if (i>0&&j>0){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }else{
                        if (i>0)
                            dp[i][j] = Math.max(dp[i-1][j],0);
                        else
                            dp[i][j] = Math.max(dp[i][j-1],0);
                    }
                }

                //如果比已有的最长子串长，则更新位置，
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                }

            }
         //方便理解还可以把dp打印出来
         for (int[] ints : dp)
            System.out.println(Arrays.toString(ints));

        return maxLen;
    }

}
