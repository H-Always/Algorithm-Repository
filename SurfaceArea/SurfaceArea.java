/**
 * @ClassName: SurfaceArea
 * @Description: 三维形体的表面积
 * @Author: 余霜
 * @Date: 2020/03/25 15:17
 * @Version: V1.0
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 *
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

// 这题的例子看了挺长时间，有点难懂啊...还是我太笨了
// 思路，先把每个单独的长方体表面积算出来，再算一下贴合的表面积，做一个差就好了
// 单独矩形的表面积比如[[3,5],[1,2]]，看成三个单独的，第一个由一个正方体构成，后两个由两个正方体构成
// 先不考虑贴合问题，单算这三个表面积14+22+6+10=52
// 然后算贴合的面积，两个长方体贴合部分面积为较小的那一个*2，比如[[3,0],[5,0]]贴合在一起，贴合的面积为min(3,5)*2=6
// 算出来之后减去就是答案，至于怎么遍历减掉，很简单，每一个元素只遍历right方向和down方向就可以遍历完
// [[3 -> 5]     先算3的right，为min(3,5)*2=6，再算down，为min(3,1)*2=2，这样3这个元素就遍历完了
//   |    |      然后算5的right，5没有右边，再算down，为min(5,2)*2=4
//   v    v      第一行就遍历完了，然后遍历第二行，1的right，为min(1,2)*2=2，没有down
//  [1 -> 2]     再算2，2既没有right，也没有down，就遍历完了
public class SurfaceArea {
    public int surfaceArea(int[][] grid) {

        int allArea = 0;//所有长方体的表面积
        int hide = 0;//贴合隐藏部分的面积

        //遍历一遍，把所有长方体看成单独个体算一下面积
        for (int[] values : grid) {
            for (int val : values) {
                if (val != 0)
                    allArea += val * 4 + 2;
            }
        }

        System.out.println(allArea);

        //算一下贴合部分的表面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i+1<grid.length)
                    hide+=Math.min(grid[i+1][j],grid[i][j])*2;
                if (j+1<grid[0].length)
                    hide+=Math.min(grid[i][j+1],grid[i][j])*2;
            }
        }


        return allArea-hide;
    }
}
