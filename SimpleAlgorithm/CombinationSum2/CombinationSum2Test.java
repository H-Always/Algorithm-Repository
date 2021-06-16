import java.util.List;
/**
 * @ ClassName : combinationSum2
 * @ Description :组合综合II算法测试
 * @ Author : 余霜
 * @ Date : 2021/6/16 17:38
 * @ Version : 1.0
 **/

public class CombinationSum2Test {
    public static void main(String[] args) {

        //false代表全部，false代表找一个就行
        boolean flag = true;

        int[] data = new int[]{2,3,3,3,4,5,1,2,3};
        int target = 8;

        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> res = solution.combinationSum2(data, target,flag);
        System.out.println("当前存在匹配数据: " + res);

    }
}
