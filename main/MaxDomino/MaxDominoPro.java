package AlgorithmPackge;

import java.util.function.BiConsumer;

/**
 * @ClassName MaxDominoPro
 * @Description: TODO 多米诺骨牌-Pro
 * @Author  passerr   (这个是大佬的LeetCodeid)
 * @Date 2019/9/27 19:21
 * @Version V2.0
 **/

public class MaxDominoPro {
    public int domino(int n, int m, int[][] broken) {

        // 初始化多米诺牌
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

        // 格子数量
        int maxSteps = m * n;

        // 结果，这里写int会报错,原因嘛,我觉得和c++里的参数传递差不多,这里要传进去一个地址
        int[] result  = new int[1];

        // 考虑使用回溯
        // 这个相当于一个内部类，
        BiConsumer<Integer, Integer> backtrack = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer step, Integer blocks) {
                result [0] = Math.max(result [0], blocks);
                if (step == maxSteps) {
                    return;
                }

                //row :当前行  column :当前列
                int row = step / m, column = step % m;
                if (!dominoes[row][column]) {
                    this.accept(step + 1, blocks);
                } else {
                    // 横放或竖放两种放牌方式
                    boolean flag = false;

                    // 横放
                    // 因为是横放，所以判断当前的下一个位置是否越界，在判断下一个位置是不是false(有没有障碍物)
                    if ((step + 1) % m > column && dominoes[row][column + 1]) {
                        flag = true;
                        dominoes[row][column] = dominoes[row][column + 1] = false;
                        this.accept(step + 2, blocks + 1);
                        dominoes[row][column] = dominoes[row][column + 1] = true;
                    }

                    // 竖放
                    if ((row + 1) < n && dominoes[row + 1][column]) {
                        flag = true;
                        dominoes[row][column] = dominoes[row + 1][column] = false;
                        this.accept(step + 1, blocks + 1);
                        dominoes[row][column] = dominoes[row + 1][column] = true;
                    }

                    // 不放
                    if (!flag) {
                        this.accept(step + 1, blocks);
                    }
                }
            }
        };
        backtrack.accept(0, 0);
        return result [0];
    }
}
