/**
 * @ClassName MinDistance
 * @Description: 编辑距离，返回两个单词最短转换次数
 * @Author 余霜
 * @Date 2019/12/4 15:01
 * @Version V1.0
 **/

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinDistance {
    public int minDistance(String s1, String s2) {
        //准备工作
        int m = s1.length(), n = s2.length();
        //因为是动态规划，所以建立一个备忘录，注意这里是+1
        //不太明白的可以去main里看看我放的其他博主的视频文章
        int[][] dp = new int[m + 1][n + 1];
        // 初始化数字，每个对应的最小距离，也方便了左上角置零
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // 动态规划求解
        //如果判断相同就不用动，
        //如果不同的话就把插入删除替换全试一遍，然后去一个最小值
        //最后返回的dp[m][n]就一定会是最小值
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int insert = dp[i - 1][j] + 1;
                    int delete = dp[i][j - 1] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = min(insert, delete, replace);
                }
            }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
