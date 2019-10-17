package AlgorithmPackge;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {

        int[] wall = {0,1,0,2,1,0,1,3,2,1,2,1};

        MaximumCatchRain ys = new MaximumCatchRain();

        int res =  ys.maximumCatchRain(wall);

        System.out.println(res);


    }
}
