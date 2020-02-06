/**
 * @ClassName: Rotate
 * @Description: 旋转图像
 * @Author: 余霜
 * @date: 2020/1/20/21:45
 * @Version: 1.0
 */

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
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

    }

}

