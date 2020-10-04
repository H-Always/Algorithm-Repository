import java.util.List;

/**
 * @ ClassName : CombinationSumTest
 * @ Description :算法测试
 * @ Author : 余霜
 * @ Date : 2020/09/09 17:25
 * @ Version : 1.0
 */


public class CombinationSumTest {
    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();

        int[] candidates = {4,2,5,1,6,3,7,8};

        List<List<Integer>> list = combinationSum.CombationSum(candidates,6);

        for (List<Integer> integers : list) {
            System.out.println(integers);
        }

    }
}
