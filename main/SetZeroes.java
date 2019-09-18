package AlgorithmPackge;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3, 5, 2, 2},
                {2, 3, 6, 5, 4, 2},
                {8, 5, 0, 8, 3, 7},
                {5, 7, 7, 7, 7, 2},
                {4, 3, 2, 1, 3, 4}
        };


        SetZeroes se = new SetZeroes();
        se.setZeroe(arr);


        for (int a[] :
                arr) {
            for (int num :
                    a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

}
