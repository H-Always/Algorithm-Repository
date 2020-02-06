/**
 * @ClassName canPlaceFlowers
 * @Description: 种花问题
 * @Author 余霜
 * @Date 2019/12/28 15:27
 * @Version V1.0
 **/


/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //假设在数组左边添加0，以解决边界问题，令count初始为1
        int num = 0, count = 1;
        for (int value : flowerbed) {
            if (value == 0) {
                count++;
            } else {
                count = 0;
            }
            //每连续三个0种一次花
            if (count == 3) {
                num++;
                count = 1;
            }
        }
        //如果最后count为2而不是1，表示最后一个位置可以种花
        if (count == 2) {
            num++;
        }
        return n <= num;
    }

    }
