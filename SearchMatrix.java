package AlgorithmPackge;
/**
 * @ClassName SearcMatrix
 * @Description: TODO 判断一个m*n的矩阵中是否存在目标值
 * @Author 余霜
 * @Date 2019/9/15
 * @Version V1.0
 **/

public class SearchMatrix {

    public boolean searchMaatrix(int[][] matrix, int target) {
        int head = 0;
        int temp = 0;
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
