import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FindMode
 * @Description: 多数元素
 * @Author 余霜
 * @Date 2020/03/13 07:53
 * @Version V1.0
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/



//看到这题就想到了哈希函数，遍历数组，每次记录一下当前数字出现的次数，不存在就添加，当次数超过length/2就可以返回了
public class MajorityElement {
    public int majorityElement(int[] nums) {

        if (nums.length<=1)
            return nums[0];

        //创建一个Map函数， 利用hashMap的特点来找
        Map<Integer, Integer> map = new HashMap<>();

        //map.containsKey()-判断有没有键值
        //map.put()-添加键值对
        //map.get()-获取当前值
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                //判断这个数字是否是众数，只要value值大于一半就好了
                map.put(num, map.get(num) + 1);
                if (map.get(num) > nums.length / 2)
                    return num;
            }
        }

        return -1;
    }


    // 下面这个算法被称为摩尔投票法，今天新学的，感觉很好，速度出奇的块，1ms
    // 最基本的摩尔投票问题，找出一组数字序列中出现次数大于总数1/2的数字(并且假设这个数字一定存在)
    // 显然这个数字只可能有一个。摩尔投票算法是基于这个事实:每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
    // 最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个。

    //创建一个count计数器，每次遇到相同的数字就+1，否则就-1，最后一定能找到那个出现次数大于1/2的数字
    public int majorityElement_2(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]){
                count++;
            } else{
                count--;
                if (count==0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }

        return res;
    }



    //既然是写算法，本质就不应该用当前已经有的api....但是测试跑一跑也没什么
    //不过，这个确实快...哈希函数22ms，排序才2ms...
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
