/**
 * @ClassName: MaxAreaOfIslandTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/15 21:15
 * @Version: V1.0
 **/
public class MaxAreaOfIslandTest {
    public static void main(String[] args) {
        int[][] island = {
                {0,0,0,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,1}
        };

        MaxAreaOfIsland ys = new MaxAreaOfIsland();

        System.out.println(ys.maxAreaOfIsland(island));

    }
}
