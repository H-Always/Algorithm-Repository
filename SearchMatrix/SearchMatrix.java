/**
 * @ClassName SearcMatrix
 * @Description: TODO 搜索矩阵
 * @Author 余霜
 * @Date 2019/9/15
 * @Version V1.0
 **/

/**
 * 给出一个矩阵，这个矩阵每一行升序排列，从第二行开始，每一行的第一个值大于上一行的最后一个值
 * 给出一个target，判断是否存在于这个矩阵
 */

public class SearchMatrix {

    public boolean searchMaatrix(int[][] matrix, int target) {
        int head = 0;
        int temp;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int row = 0;

        //找到target所在的行
        while (matrix[row][n] < target) {
            row++;
            if (row > m)
                return false;
        }

        //二分查找来搜索target,也可以使用更好的查找算法
        while (head <= n) {
            temp = (head + n) / 2;
            if (matrix[row][temp] == target)
                return true;
            else if (matrix[row][temp] > target)
                n = temp - 1;
            else
                head = temp + 1;
        }

        //跳出了while，证明没有找到，返回false
        return false;

    }


}
