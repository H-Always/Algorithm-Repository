import java.util.Arrays;

/**
 * @ClassName: TestAddTwoNumbers
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:17
 * @Version: 1.0
 */
public class TestDeepDarkFraction {
    public static void main(String[] args) {
        DeepDarkFraction ys = new DeepDarkFraction();
        int[] cont = {3, 2, 0, 2};
        int[] res = ys.deepDarkFraction(cont);

        System.out.println(Arrays.toString(res));
    }
}
