import java.util.ArrayList;

/**
 * @ClassName SetMatrixOfZero
 * @Description: TODO 矩阵置零，把数组中元素为零的行和列都置为0
 * @Author 余霜
 * @Date 2019/12/28 15:27
 * @Version V1.0
 **/

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 */

public class SetMatrixOfZero {
    public void setMatrixOfZero(int[][] matrix) {
        //创建一个新的二维集合，用来存放为0的元素位置
        ArrayList<ArrayList<Integer>> zeroIndex = new ArrayList<>();

        //设置标志，用来记录数组下标
        int flag = 0;

        //判断元素是否为零，如果是零，则存放在数组里
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    //把为零的点放进新集合，然后把这个集合放到结果集
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    zeroIndex.add(temp);
                }
            }
        }

        //循环下zroIndex用来把改行和该列元素置为零
        for (ArrayList<Integer> index : zeroIndex) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[index.get(0)][j] = 0;
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][index.get(1)] = 0;
            }
        }


    }
}
