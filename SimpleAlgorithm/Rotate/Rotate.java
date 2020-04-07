/**
 * @ClassName: Rotate
 * @Description: 旋转矩阵
 * @Author: 余霜
 * @Date: 2020/04/07 12:38
 * @Version: V1.1
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
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
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
// 1  2  3  4       简单来说就是一圈一圈的换，先换最外圈，把4先保存，然后把1换到4，然后把16保存，把刚才保存的4赋值给16，然后保存13，把16赋值给13
// 5  6  7  8       第一次循环就算完事，然后行列+1，把2先保存，然后把2换到8，然后把15保存...
// 9  10 11 12      第一圈完成之后，换第二圈6  7  和刚才一样，把7先保存，然后把6换到7，然后把11保存...
// 13 14 15 16                           10 11
public class Rotate {

    public void rotate_BF(int[][] matrix) {

        //原地改变，简单来说就是一圈一圈换
        //两层循环，外层循环控制圈数，内层循环控制这一圈要换几次
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix[0].length - 1 - i; j++) {//这层循环每循环一次就会换掉对应的四个值
                //每次换四个数字，使用两个临时变量来记录临时值
                //这个变量保存的是当前层的最右边的从上到下元素，比如4，8，12
                int temp1 = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = matrix[i][j];

                //这个临时变量保存这一层的最下面行元素，比如16，15，14
                int temp2 = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[matrix.length - i - 1][matrix.length - j - 1] = temp1;

                temp1 = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = temp2;

                matrix[i][j] = temp1;

            }

        }

    }


    //leetcode大佬的方法，先对角线进行对称反转，然后每每一行中心交换，
    // 1  2  3  4     对角线是1 6 11 16     1   5   9   13  然后中心反转  13  9   5   1
    // 5  6  7  8                          2   6   10  14               14  10  6   2
    // 9  10 11 12                         3   7   11  15               15  11  7   3
    // 13 14 15 16                         4   8   12  16               16  12  8   4
    // 数学方法就是快啊
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }


}

