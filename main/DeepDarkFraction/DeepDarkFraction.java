package AlgorithmPackge;

import java.util.Arrays;
/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {
        DeepDarkFraction ys = new DeepDarkFraction();
        int[] cont = {3, 2, 0, 2};
        int[] res = ys.deepDarkFraction(cont);

        System.out.println(Arrays.toString(res));
    }
}
