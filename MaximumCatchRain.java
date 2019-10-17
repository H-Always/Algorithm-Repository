package AlgorithmPackge;

/**
 * @ClassName MaximumRain
 * @Description: TODO 接雨水
 * @Author 余霜
 * @Date 2019/10/6 22:15
 * @Version V1.0
 **/

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
