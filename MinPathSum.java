package AlgorithmPackge;
/**
 * @ClassName SearcMatrix
 * @Description: TODO m*n的二维数组从左上角到右下角的最短路径是多少
 * @Author 余霜
 * @Date 2019/9/13
 * @Version V1.0
 **/

public class MinPathSum {

    public int minPathSum(int[][] matrix) {
        return minPathSum(matrix, 0, 0);
    }

    public int minPathSum(int[][] matrix, int i, int j) {

        //这个判断说明遇到了拐角，走到了最后一行，那就只能搜索前面的格子
        if (i != matrix.length - 1 && j == matrix[0].length - 1) {
            System.out.println(i+ " " +j);
            return matrix[i][j] + minPathSum(matrix, i + 1, j);
        }

        //这个判断说明遇到了拐角，走到了最后一列，那就只能搜索下面的格子
        if (i == matrix.length - 1 && j != matrix[0].length - 1) {
            System.out.println(i+ " " +j);
            return matrix[i][j] + minPathSum(matrix, i, j + 1);
        }

        //这个判断说明走到了目的地，行列都是最后一个，开始返回递归
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }

        //这个说明当前既可以向前走，也可以向下走，所以要选择一个较短的路线
        return matrix[i][j] + Math.min(minPathSum(matrix, i + 1, j), minPathSum(matrix, i, j + 1));
    }


}
