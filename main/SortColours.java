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
        int[] colours = {1,2,1,1,0,0,1,2,0,1,2,0,1};
        System.out.println(Arrays.toString(colours));
        SortColours ys = new SortColours();
        ys.sortColours(colours);

        System.out.println(Arrays.toString(colours));

    }

}
