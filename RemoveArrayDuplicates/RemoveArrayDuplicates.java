/**
 * @ClassName: RemoveArrayDuplicates
 * @Description: 删除排序数组中的重复项
 * @Author: 余霜
 * @date: 2020/3/8/16:58
 * @Version: 1.0
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class RemoveArrayDuplicates {
    public int removeArrayDuplicates(int[] nums) {

        // 如果为空或者长度为1，就返回
        if(nums==null || nums.length == 1){
            return nums.length;
        }

        //双指针，i在前，j在后，前提是排序数组
        //i永远指向当前不重复的最后一个元素，初始为0，
        //当与遇到重复的元素的时候，i不动，j往后走
        //一直走到判断不重复的元素i先往下走，因为下一个元素必定重复，和当前j的不重复元素换一下，直到最后
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }
}