import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PrintArraylist
 * @Description: 螺旋数组
 * @Author: 余霜
 * @date: 2020/1/19/18:24
 * @Version: 1.0
 */

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PrintArrays {
    public List<Integer> printArrays(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //如果数组为空就返回
        if (matrix.length == 0)
            return null;

        //设置边界，上下左右
        int up = 0;
        int lift = 0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;

        //执行完了一遍代表遍历了一圈，没有遍历完就继续循环
        while (true) {
            //遍历up一行，从最左边开始遍历，所以lift递增，判断条件是小于右边。
            for (int i = lift; i <= right; i++) list.add(matrix[up][i]);
            //遍历完了up一行，就递增到下一行，如果下一行越界了，就代表遍历完了，跳出循环
            if (++up > down) break;

            //同上...
            for (int i = up; i <= down; i++) list.add(matrix[i][right]);

            if (--right <lift) break;


            for (int i = right; i >= lift; i--) list.add(matrix[down][i]);

            if (--down < up) break;


            for (int i = down; i >= up; i--) list.add(matrix[i][lift]);

            if (++lift > right) break;

        }

        return list;
    }

}
