/**
 * @ClassName: CoinChangeTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/21 10:19
 * @Version: V1.0
 **/
public class CoinChangeTest {
    public static void main(String[] args) {
        CoinChange ys = new CoinChange();

        int[] coins = {5,3,7};


        System.out.println(ys.coinChange(coins,6442));
    }
}
