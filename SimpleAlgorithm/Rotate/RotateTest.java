/**
 * @ClassName: RotateTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/04/07 12:24
 * @Version: V1.0
 **/
public class RotateTest {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        Rotate ys = new Rotate();
        ys.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
