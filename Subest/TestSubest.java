import java.util.List;

/**
 * @ClassName: Test
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestSubest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subest ys = new Subest();

        List<List<Integer>> subest = ys.subest(nums);

        System.out.println(subest);
    }
}
