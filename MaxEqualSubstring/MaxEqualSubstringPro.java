/**
 * @ClassName MaxEqualSubstringPro
 * @Description: 尽可能使字符串相等
 * @Author 余霜
 * @Date 2019/10/2 16:19
 * @Version V1.0
 **/

public class MaxEqualSubstringPro {
    public int maxEqualSubstringPro(String s, String t, int maxCost) {
        int max = 0;
        //建立第一个数组，这个数组用来存放两个字符串的ASCII绝对值
        int[] temp = new int[Math.min(s.length(), t.length())];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        //建立第二个数组，用来存放每个位置与之前所有位置的插值
        int[] dp = new int[temp.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + temp[i - 1];
        }

        //算法核心，从后往前遍历，判断是否二分查找(注意，dp是一个非递减数组)
        //如果a的值比maxCost大的话，说明这个值一定超了，也就没有社必要去查找了
        //如果没有比maxCost大的话，也就是前面至少有一个有符合条件的值，就需要查找
        for (int i = dp.length - 1; i >= 1; i--) {
            int a = dp[i] - dp[i - 1];
            if (a <= maxCost) {
                int count = tempMax(dp, i, 0, i - 1, maxCost);
                max = Math.max(count, max);
            }
        }
        return max;
    }

    //能偶调用说明前面存在合理的值，可以进行二分查找，
    // 找出的dp[k]-dp[?]不超过maxCost的最大项差值，也就是最大临时数
    public int tempMax(int[] dp, int k, int front, int rear, int maxCost) {
        int mid = (front + rear) / 2;
        while (front < rear) {
            if (dp[k] - dp[mid] <= maxCost)
                rear = mid;
            else
                front = mid + 1;
            mid = (front + rear) / 2;
        }
        return k - front;
    }
}