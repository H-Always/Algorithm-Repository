import java.math.BigDecimal;
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

        //true代表全部，false代表找一个就行
        boolean flag = false;

        double[] data = new double[]{10234.58,10001.36,9658.09};
        double[] buiness = new double[]{20235.94,19659.45,29894.03};
        double target = 8;

        for (double v : buiness) {
            CombinationSum2 solution = new CombinationSum2();
            List<List<Double>> res = solution.combinationSum2(data, v, flag );
            System.out.println(v+"当前存在匹配数据: " + res);
        }


    }
}
