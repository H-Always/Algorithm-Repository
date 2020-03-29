/**
 * @ClassName: MaxDistanceTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/03/29 21:06
 * @Version: V1.0
 **/
public class MaxDistanceTest {
    public static void main(String[] args) {
        int[][] arr ={{0,0,1,0,0},{0,0,1,0,0},{0,1,0,0,0},{1,0,0,1,0},{1,0,0,0,0}};

        MaxDistance ys = new MaxDistance();

        System.out.println(ys.maxDistance(arr));
    }

}
