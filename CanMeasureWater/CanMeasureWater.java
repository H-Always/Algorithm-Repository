import java.util.Arrays;

/**
 * @ClassName: CanMeasureWater
 * @Description: 水壶问题
 * @Author: 余霜
 * @Date: 2020/03/21 08:10
 * @Version: V1.0
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 **/

//第一眼看到这题，可能就是算一个数字能不能被其他三个数字整好凑出来吧，
// 好像和以前看过一个动态规划一毛一样，分硬币的那个
// 测试都没通过！！！，心态爆炸..我理解错了，这题的意思不是给出z升水，看能不能通拼出来
// 这题目是看这俩容器怎么互相倒水能凑出来z升水，z<=x+y
// 思路，找这俩水壶的最大公约数，这个数就是这俩杯子能鼓捣出来的最小份数的水
// 然后看这个z能不能被最小份数整除，整除就代表可以换出来
// 这题其实挺坑的...题目表述不明确，起码给一个解释呀 3,7,45 因为最大才十升水所以拼不出

    /*
    放两个leetcode讨论区的例子
    x = 3, y = 5, z = 4
    装满y ---- y还有5
    y向x装3-----y还有2，x有3
    倒掉x，把y里面的2装到x-------y还有0，x有2
    装满y ----- y有5，x有2
    y向x装1(用y装满x) ----- y有4，x有3
    倒掉x ------ y有4，x有 0

    7，9装出1：0 9|7 2|2 9|7 4|4 9|7 6|6 9|7 8|7 1

    这里注意下极端案例，0，0，0  0，0，1啥的
     */
public class CanMeasureWater {

    public boolean canMeasureWater(int x, int y, int z) {

        //0升数就不用装了
        if (z == 0) return true;

        //超过了最大也装不出来
        if (x + y < z) return false;

        //其中有一个为0判断一下就好
        if (x == 0) return y == z;
        if (y == 0) return x == z;

        //算一下最大公约数，判断是否整除
        int gcd = gcd(x,y);

        return z % gcd == 0;
    }

    public static int gcd(int a ,int b) { return b==0?a:gcd(b,a%b); }






    //写都写出来了，放着吧...
    public boolean canMeasureWater_maxCount(int x, int y, int z) {
        int abs = Math.abs(x-y);
        if (z%x==0||z%y==0||z%abs==0)
            return true;

        int[] waters = {x,y,abs};

        int[] dp = new int[z+1];

        dp[0] = 0;
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < waters.length; j++) {
                if (i>=waters[j] && dp[i-waters[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-waters[j]]+1,dp[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        System.out.println(Arrays.toString(dp));
        return dp[z] != Integer.MAX_VALUE;
    }

}
