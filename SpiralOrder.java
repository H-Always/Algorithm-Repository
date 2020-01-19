import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PrintArraylist
 * @Description: TODO 螺旋打印数组
 * @Author: 余霜
 * @date: 2020/1/19/18:24
 * @Version: 1.0
 */
public class PrintArrays {
    public List printArrays(int[][] matrix) {
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
