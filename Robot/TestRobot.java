/**
 * @ClassName: Test
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestRobot {
    public static void main(String[] args) {
        String command = "UUURU";
        int[][] obstacles = {{2, 2}};
        int x = 3;
        int y = 2;


        boolean res = Robot.robot(command,obstacles,x,y);

        System.out.println(res);
    }
}
