package AlgorithmPackge;

/**
 * @ClassName MaxDomino
 * @Description: TODO 多米诺骨牌
 * @Author 余霜
 * @Date 2019/9/27 11:51
 * @Version V1.0
 **/

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
