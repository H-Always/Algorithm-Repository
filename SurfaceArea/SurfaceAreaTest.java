/**
 * @ClassName: SurfaceAreaTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/25 15:17
 * @Version: V1.0
 **/
public class SurfaceAreaTest {
    public static void main(String[] args) {
        SurfaceArea ys = new SurfaceArea();
        
        int[][] grid = {{2,2,2,10,5},{11,2,9,1,2},{0,2,2,2,4},{3,4,1,12,5},{3,6,21,4,6}};

        System.out.println(ys.surfaceArea(grid));
    }
}
