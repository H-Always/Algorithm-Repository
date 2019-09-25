package AlgorithmPackge;
/**
 * @ClassName Robot
 * @Description: TODO 机器人寻路
 * @Author 余霜
 * @Date 2019/9/25 15:30
 * @Version V1.0
 **/

public class Robot {
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        //把所给的路径字符串转换成数组，下一步好遍历
        String[] url = new String[command.length()];
        for (int i = 0; i < command.length(); i++) {
            url[i] = command.substring(i, i + 1);
        }

        //初始坐标
        int row = 0;
        int col = 0;

        //U就往下走，走完判断一下到没到终点，有没有障碍，R同理
        for (int i = 0; i < x + y; i++) {
            if (url[i % command.length()].equals("U")) {
                col++;
            }
            if (row == x && col == y) {
                return true;
            }
            if (obstacles.length != 0)
                if (judge(obstacles, row, col))
                    return false;
            if (url[i % command.length()].equals("R")) {
                row++;
            }
            if (row == x && col == y) {
                return true;
            }
            if (obstacles.length != 0)
                if (judge(obstacles, row, col))
                    return false;
        }

        return false;
    }

    //判断是否有障碍的方法
    public static boolean judge(int[][] obstacles, int row, int col) {
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] == row && obstacles[i][1] == col)
                return true;
        }
        return false;
    }
}
