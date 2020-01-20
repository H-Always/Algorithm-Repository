/**
 * @ClassName: Rotate
 * @Description: TODO 旋转图像
 * @Author: 余霜
 * @date: 2020/1/20/21:45
 * @Version: 1.0
 */
public class Rotate {
    public void rotate(int[][] matrix) {

        //原地改变，简单来说就是一圈一圈换
        //两层循环，外层循环控制圈数，内层循环控制这一圈要换几次
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                //每次换四个数字，使用两个临时变量来记录临时值
                int temp1 = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = matrix[i][j];

                int temp2 = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[matrix.length - i - 1][matrix.length - j - 1] = temp1;

                temp1 = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = temp2;

                matrix[i][j] = temp1;

            }

        }

        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

}

