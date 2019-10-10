package AlgorithmPackge;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {

        ArraysIntersection ys = new ArraysIntersection();

        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {1,2,4,6,7,10};
        int[] arr3 = {1,3,5,7};

        List<Integer> list = ys.arraysIntersection(arr1,arr2,arr3);

        System.out.println(list);
    }
}
