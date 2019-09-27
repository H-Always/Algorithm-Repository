package AlgorithmPackge;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {

        MaxDomino ys = new MaxDomino();
        int[][] broken = {{0,0},{1,0}};
        int res = ys.domino(2, 3, broken);
        System.out.println(res);

    }
}
