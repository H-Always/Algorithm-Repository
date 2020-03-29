import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @ClassName: MaxDistance
 * @Description: 地图分析
 * @Author: 余霜
 * @Date: 2020/03/29 21:05
 * @Version: V1.0
 **/

// 这个题也很好，BFS，说真，BFS我还没怎么做过
// BFS和DFS的区别就是DFS是一条道跑到黑，而DFS会分身同时跑多个路
// 这个题属于图的BFS，有多个root，每一个陆地都是root
// 这题的思路:先把陆地入队，然后遍历周围四个地方，如果是海洋的话，这四个地方和陆地的距离必然为1
// 遍历完这四个海洋，就把海洋变为一个带参数的陆地，就是数组的值，把0换成对应的距离
// 这样遍历到最后的海洋就是最遥远的海洋

// 这题真的不错，对于我这样的新手来说很适用
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        // 定义上下左右四个方向,这四个是成对出现的，
        // 比如dx[0],dy[0],就是{i-1,j},代表向左移动
        // BFS一般都这么设置
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        //创建一个队列，搜索每一个陆地，然后入队
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        // 这里不能直接把陆地赋值成0,会出错
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //grid[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                //判断一下边界条件和该陆地是否被探索过
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                hasOcean = true;
                queue.offer(new int[] {newX, newY});

                //看一下BFS过程
                for (int[] ints : grid) {
                    System.out.println(Arrays.toString(ints));
                }
                System.out.println();
            }
        }

        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }

        // 最后队列一定为空，全部弹出，所以point保存的就是最后遍历到的海洋
        // 返回最后一次遍历到的海洋的距离，因为初始陆地为1，所以要减1
        return grid[point[0]][point[1]] - 1;

    }
}

