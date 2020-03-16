/**
 * @ClassName: MaxAreaOfIsland
 * @Description: 岛屿的最大面积
 * @Author: 余霜
 * @Date: 2020/03/15 21:15
 * @Version: V1.0
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//这题目有点不太好懂，其实就是上下左右连成片的1的最大数量，想到了深度优先搜索
// 典型的深度优先搜索，学过数据结构这题应该不难
// 思路: 两层循环遍历整个数组，当遇到土地的时候，也就是1的时候就跳转到dfs中，
// dfs主要做两件事，第一个是判断边界，也就是递归出口，第二个是向下递归，搜索上下左右四个方向
// 当遇到0或者边界就返回0，否则就加1继续递归
public class MaxAreaOfIsland {

    //全局变量，递归里面要用
    int area = 1;

    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;

        //遍历整个数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //当遇到1，就说明可能存在最大面积，进入dfs
                if (grid[i][j] == 1){
                    area = dfs(grid,i,j);
                    max_area = Math.max(max_area,this.area);
                }
            }
        }
        return max_area;
    }

    //算法核心，深度优先搜索
    public int dfs(int[][] grid, int i, int j){
        //边界条件
        if (i<0||i == grid.length)
            return 0;
        if (j<0||j == grid[0].length)
            return 0;

        //如果遍历目标为土地，就把该土地置为0，面积+1，继续寻找下一层
        if (grid[i][j] == 1){
            grid[i][j] =0;
            return 1 +dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
        }

        //走到这里说明遇到了0，返回
        return 0;
    }
}