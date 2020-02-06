/**
 * @ClassName: Test
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestSearchMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        SearchMatrix ys = new SearchMatrix();
        boolean res = ys.searchMaatrix(matrix, 50);
        System.out.println(res);
    }
}
