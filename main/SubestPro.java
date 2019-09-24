package AlgorithmPackge;

import java.util.List;
/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 4};
        SubestPro ys = new SubestPro();

        List<List<Integer>> subest = ys.subestPro(nums);

        System.out.println(subest);
    }
}
