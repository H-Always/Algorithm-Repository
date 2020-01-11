package AlgorithmPackge;

import java.util.*;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {
        SetMatrixOfZero ys = new SetMatrixOfZero();

        int[][] matrix = {
                {0, 2, 3, 4, 5},
                {1, 0, 3, 4, 5},
                {4, 2, 0, 6, 5},
                {6, 5, 4, 8, 7},
                {8, 5, 3, 1, 0}
        };

        ys.setMatrixOfZero(matrix);

    }
}
