import java.util.List;

/**
 * @ClassName: TestAlgorithm
 * @Description: TODO
 * @Author: 余霜
 * @date: 2020/1/19/20:50
 * @Version: 1.0
 */
public class TestAlgorithm {


    public static void main(String[] args) {

        int[][] arr = {{1},
                       {4},
                       {7}};

       /* int k = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = k++;
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }*/

        PrintArrays ys = new PrintArrays();
        List<Integer> list = ys.printArrays(arr);


        System.out.println(list);


    }

}
