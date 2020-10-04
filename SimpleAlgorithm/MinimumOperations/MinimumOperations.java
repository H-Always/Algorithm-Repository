import java.util.Arrays;

/**
 * @ ClassName : MinimumOperations
 * @ Description : 秋叶收藏集
 * @ Author : 余霜
 * @ Date : 2020/09/14 14:39
 * @ Version : 1.0
 *
 * 小口出去秋游，体重收集了一些红叶和黄叶，他利用这些叶子初步整理了一分秋叶收藏集"leaves",字符串"leaves"仅包含小写字母"r","y",
 * 其中字符"r"代表了红叶，字符"y"代表一片黄叶，处于美观整的考虑，小口想要收藏夹中树叶的排列调整成[红，黄，红]三部分，每部分树叶的数量可以
 * 不相等，但均需大于等于1，每次调整操作，小扣可以将一片红叶替换成黄叶，或者将一片黄叶替换成红叶，请问小口最少需要多少次调整操作才可以
 * 将秋叶收藏集调整完毕
 *
 * 例如:输入"rrryyyrryyyrr"
 * 输出"2"
 *
 * 提示:
 * leaves.length<=10^5
 * leaves中只包含字符'r','y'
 *
 */

// 这个动态规划还是挺好的，用到了两次转移，一般的动态规划也就用到了一次转移，
// 首先判断左边最少变成r要多次，在此最优基础上判断中间是y的最小次数，在在此基础上判断最右边是r的最小次数

public class MinimumOperations {
    public int minimumOperations(String leaves){
        //开一个dp，n行3列
        //dp[i][0] 代表变成左边红色所需要的最小操作步骤，
        //dp[i][1] 代表变成中间黄色所需要的最小操作步骤，
        //dp[i][2] 代表变成右边红色所需要的最小操作步骤，
        int[][] dp = new int[leaves.length()][3];

        //初始化第一个位置，第一个位置如果为r的话，则为0，如果为y的话，则初始化为1
        dp[0][0] = leaves.charAt(0) == 'r'?0:1;


        //遍历字符串，动态规划，不太懂中间过程的小伙伴可以把这个数组输出一下来理解
        for (int i = 1; i < leaves.length(); i++) {

            dp[i][0] = dp[i-1][0]+(leaves.charAt(i) == 'r' ? 0 : 1);
            dp[i][1] = dp[i-1][0]+(leaves.charAt(i) == 'y' ? 0 : 1);

            //只有当前>1位置时，黄叶才会出现两种选择，在在之前的变成红叶基础上变还是在之前变成黄叶的基础上变
            //能进去这个条件说明至少有三片叶子了，所以当前临时第三片叶子为在变黄叶的最优解基础上变
            if (i>1){
                dp[i][1] = Math.min(dp[i][1],dp[i-1][1]+(leaves.charAt(i) == 'y' ? 0 : 1));
                dp[i][2] = dp[i-1][1]+(leaves.charAt(i) == 'r' ? 0 : 1);
            }

            //只有当前>2位置时，黄叶才会出现两种选择，在在之前的黄叶基础上变还是在上一次变成红叶的基础上变
            if (i>2){
                dp[i][2] = Math.min(dp[i][2],dp[i-1][2]+(leaves.charAt(i) == 'r' ? 0 : 1));
            }

        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[leaves.length()-1][2];

    }

}
