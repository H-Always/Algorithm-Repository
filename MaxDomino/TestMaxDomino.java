/**
 * @ClassName: Test
 * @Description: 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestMaxDomino {
    public static void main(String[] args) {
        MaxDomino ys = new MaxDomino();
        int[][] broken = {{0,0},{1,0}};
        int res = ys.domino(2, 3, broken);
        System.out.println(res);
    }
}
