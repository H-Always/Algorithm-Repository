/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestMinimumAbsDifference {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};

        MinimumAbsDifference ys = new MinimumAbsDifference();

        System.out.println(ys.minimumAbsDifference(arr));
    }
}
