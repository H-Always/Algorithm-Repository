/**
 * @ClassName Robot
 * @Description: TODO 机器人大冒险
 * @Author 余霜
 * @Date 2019/9/25 15:30
 * @Version V1.1
 **/

/**
 * 这个也是昨天leetcode比赛的题目，有一项测试没通过，今天去看了看，这个题的最后一个测试两万字，我附上了文件，可以测试一下
 * 我的算法时间复杂度太高了，属于暴力求解，超时所以没通过，等我有时间看看大佬的答案分析一下写个pro版本
 * 题目：
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 * 示例 2：
 *
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 * 示例 3：
 *
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 */

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
