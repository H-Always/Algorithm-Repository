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

        //这里的金钱数+1，比如5块钱，要最大可以遍历到[5]，那么理所当然要写成new int[6]
        int[] dp = new int[amount+1];

        //初始化，0元只能由0个硬币拼成，剩下的都默认拼不成
        dp[0] = 0;
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);

        //循环，
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                // 这里的判断条件，第一个是当前的钱一定要小于等于硬币的面额。三块钱只能由小于等于三块钱的硬币拼出来
                // 第二个是如果前一个位置的硬币数是不能默认值(也就是拼不成)，如果前面一个金额拼不成，那么后面也没法拼成,
                //          就是硬币面额为5，要拼出6块钱，没办法从1块钱的基础上拼出来
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    System.out.println(Arrays.toString(dp));
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
