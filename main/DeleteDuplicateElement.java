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

        int[] element = {5,6,1,1,1,2,2,2,2,2,3,3,3,3,4};

        System.out.println(Arrays.toString(element));


        DeleteDuplicateElement ys = new DeleteDuplicateElement();
        int len = ys.deleteDuplicateElement(element);

        for (int i = 0; i < len; i++) {
            System.out.print(element[i]+" ");
        }

    }

}
