/**
 * @ClassName MaximumRain
 * @Description: TODO 接雨水
 * @Author 余霜
 * @Date 2019/10/16 22:15
 * @Version V1.0
 **/

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaximumCatchRain {
    public int maximumCatchRain(int[] wall){

        if (wall.length == 1 || wall.length == 0){
            return 0;
        }

        int rainWater = 0;
        int temp = 0;
        int i = 0;
        int j = 1;

        while (j < wall.length)
        {
            if (wall[j] >= wall[i])
            {
                temp = j - i;
                if (temp == 1)
                {
                    i++;
                    j++;
                }
                else
                {
                    for (int k = 1; k < temp; k++)
                    {
                        rainWater += wall[i] - wall[i + k];
                    }
                    i = j;
                    j = j + 1;
                }
            }
            else
            {
                j++;
            }
        }

        i = wall.length - 1;
        j = i - 1;
        while (j >= 0)
        {
            if (wall[j] >= wall[i])
            {
                temp = i - j;
                if (temp == 1)
                {
                    i--;
                    j--;
                }
                else
                {
                    for (int k = 1; k < temp; k++)
                    {
                        rainWater += wall[i] - wall[i - k];
                    }
                    i = j;
                    j = j - 1;
                }
            }
            else
            {
                j--;
            }
        }

        return rainWater;
    }
}
