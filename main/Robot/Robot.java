package AlgorithmPackge;
/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

    public static void main(String[] args) {
        String command = "UUURU";
        int[][] obstacles = {{2, 2}};
        int x = 3;
        int y = 2;

        Robot ys = new Robot();

        boolean res = ys.robot(command,obstacles,x,y);

        System.out.println(res);
    }
}
