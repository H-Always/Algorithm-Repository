/**
 * @ClassName: GameOfLife
 * @Description: 生命游戏
 * @Author: 余霜
 * @Date: 2020/04/02 23:29
 * @Version: V1.0
 *
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//注释粘贴一下大佬的
//今天这道题是大学cs课程里大概率会说到的，实现起来也很简单。
// 由于每个位置的细胞的状态是取决于当前四周其他状态的，而且每个细胞的状态是同时变化的，所以不能一个一个地更新，
// 只能在一个新的数组里创建新的状态。当然上面所说的也不是绝对的，因为这道题目的输入是int[][]，而int是可以存储更多的比特位的。
// 原有的最低位存储的是当前状态，那倒数第二低位存储下一个状态就行了。
//话说如果是额外开辟数组，有点像C++里的双缓冲技术。。

//用原地更改的话，INTEGER可以存很多位的，分开来存就好了比如 10代表下一次更新是1，但是当前为0或者16进制

public class GameOfLife {
    private static final int[] DX = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] DY = {1, -1, 0, 0, 1, -1, 1, -1};

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + DX[k];
                    int y = j + DY[k];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }
                    // 这里不能直接加board[x][y]，因为 board[x][y] 的倒数第二位是可能有值的。
                    cnt += board[x][y] & 1;
                }
                if ((board[i][j] & 1) > 0) {
                    // 这个是活细胞
                    if (cnt >= 2 && cnt <= 3) {
                        // 周围有2/3个活细胞，下一个状态还是活细胞。
                        board[i][j] = 0b11;
                    }
                    // 周围活细胞过多或过少都会死，因为原数据是0b01，所以这里不用额外赋值。
                } else if (cnt == 3) {
                    // 这个是死细胞，周围有3个活细胞，下一个状态变为活细胞。
                    board[i][j] = 0b10;
                }
            }
        }
        // 最后一位去掉，倒数第二位变为更新后的状态。
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] >>= 1;
            }
        }
    }






    //额外空间，创建一个数组，然后更新就好了
    //照着题目抄条件...
    public void gameOfLife_BF(int[][] board) {
        int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

        int[][] temp = new int[board.length][board[0].length];

        int life = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                for (int k = 0; k < 8; k++) {
                    if (i+dx[k]<0||i+dx[k]>=board.length||j+dy[k]<0||j+dy[k]>=board[0].length)
                        continue;
                    //判断周围有几个活细胞
                    life = board[i+dx[k]][j+dy[k]] == 1?life+1:life;
                }
                //如果该细胞是活细胞，
                if (board[i][j] ==1){
                    if (life==2||life==3)
                        temp[i][j] = 1;
                    else
                        temp[i][j] = 0;
                } else
                    {
                  if (life==3)
                      temp[i][j] = 1;
                }
                life = 0;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.arraycopy(temp[i], 0, board[i], 0, temp[0].length);
        }



    }
}
