/**
 * @ClassName MaxDomino
 * @Description: 多米诺骨牌
 * @Author 余霜
 * @Date 2019/9/27 11:51
 * @Version V1.0
 **/

/**
 * 这也是LeetCode秋季竞赛的题目，这个题我没做出来，参考了一个大佬的解答(他力扣id:passerr)
 *
 * 你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，你想把这些骨牌不重叠地覆盖在完好的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
 *
 *
 * 输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
 *
 * 输出：一个整数，代表最多能在棋盘上放的骨牌数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, m = 3, broken = [[1, 0], [1, 1]]
 * 输出：2
 * 解释：我们最多可以放两块骨牌：[[0, 0], [0, 1]]以及[[0, 2], [1, 2]]。（见下图）
 */
public class MaxDomino {

    int max = 0;
    int n = 0;
    int m = 0;
    int maxSteps = 0;

    public int domino(int n, int m, int[][] broken) {

        // 初始化多米诺骨牌
        boolean[][] dominoes = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dominoes[i][j] = true;
            }
        }

        //初始化故障
        for (int[] b : broken) {
            dominoes[b[0]][b[1]] = false;
        }

        // 初始化全局变量格子数量，行列
        this.maxSteps = m * n;
        this.m = m;
        this.n = n;

        accept(0, 0, dominoes);

        return max;
    }

    //这个递归，或者准确说回溯，就是穷举....把整个棋盘横竖走一遍，看看最大的block是多少
    //对新手可能不太友好，不太好懂，在纸上多画一画，或者跳过这个题
    public void accept(int step, int blocks, boolean[][] dominoes) {
        max = Math.max(max, blocks);
        if (step == maxSteps) {
            return;
        }
        //row :当前行  column :当前列
        int row = step / m, column = step % m;
        if (!dominoes[row][column]) {
            this.accept(step + 1, blocks, dominoes);
        } else {
            // 横放或竖放两种放牌方式
            boolean flag = false;

            // 横放
            // 因为是横放，所以判断当前的下一个位置是否越界，在判断下一个位置是不是false(有没有障碍物)
            if ((step + 1) % m > column && dominoes[row][column + 1]) {
                flag = true;
                dominoes[row][column] = dominoes[row][column + 1] = false;
                this.accept(step + 2, blocks + 1, dominoes);
                dominoes[row][column] = dominoes[row][column + 1] = true;
            }

            // 竖放,判断同理，只是如果竖着放成功的话步数值加一
            if ((row + 1) < n && dominoes[row + 1][column]) {
                flag = true;
                dominoes[row][column] = dominoes[row + 1][column] = false;
                this.accept(step + 1, blocks + 1, dominoes);
                dominoes[row][column] = dominoes[row + 1][column] = true;
            }

            // 不放
            if (!flag) {
                accept(step + 1, blocks, dominoes);
            }
        }
    }
}
