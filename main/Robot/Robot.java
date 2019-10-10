package AlgorithmPackge;
/**
 * @ClassName Robot
 * @Description: TODO 机器人寻路
 * @Author 余霜
 * @Date 2019/9/25 15:30
 * @Version V1.1
 **/

public class Robot {
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        //把所给的路径字符串转换成数组，下一步好遍历
        String[] url = new String[command.length()];
        for (int i = 0; i < command.length(); i++) {
            url[i] = command.substring(i, i + 1);
        }

        //判断一下障碍最小的是多少，把这个最小值传进判断条件里面去
        int min = 100000000;
        for (int[] temp :
                obstacles) {
            for (int a :
                    temp) {
                if (a < min)
                    min = a;
            }
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
                if (judge(obstacles, row, col, min))
                    return false;
            if (url[i % command.length()].equals("R")) {
                row++;
            }
            if (row == x && col == y) {
                return true;
            }
            if (obstacles.length != 0)
                if (judge(obstacles, row, col, min))
                    return false;
        }

        return false;
    }

    //判断是否有障碍的方法
    public static boolean judge(int[][] obstacles, int row, int col, int min) {
        if (row < min || col < min)
            return false;

        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] == row && obstacles[i][1] == col)
                return true;
        }
        return false;
    }
}
