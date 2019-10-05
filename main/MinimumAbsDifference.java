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

        int[] arr = {3,8,-10,23,19,-4,-14,27};
        MinimumAbsDifference ys = new MinimumAbsDifference();

        List<List<Integer>> res = ys.minimumAbsDifference(arr);

        System.out.println(res);

    }
}
