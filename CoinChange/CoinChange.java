import java.util.Arrays;

/**
 * @ClassName: CoinChange
 * @Description: 零钱兑换
 * @Author: 余霜
 * @Date: 2020/03/21 10:19
 * @Version: V1.0
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 **/

//动态规划...这题动态规划并不是什么好的办法，但是本菜目前只会这个....
// 等本菜学会了贪心算法的时候来填坑
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        dp[0] = 0;
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i>=coins[j] && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
