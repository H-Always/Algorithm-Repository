import java.util.Random;

/**
 * @ClassName: getLeastNumbers
 * @Description: 最小的k个数
 * @Author: 余霜
 * @Date: 2020/03/20 07:43
 * @Version: V1.0
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 **/

//我曾经给班级同学出过一道题，不能使用数组排序等存储方式输出一个数组的最大和次大两个数，
//这题可以排序，写一个排序就好，快速排序啥的比较好的，
//既然提到了，那这里我就写一个详细的快速排序，以后有机会会整理一个经典算法的一个库，排序搜索啊，普利姆算法啊，KMP算法啊之类的
//快速排序，这是排序里面最快的一种了吧，简单易懂，写起来也不难，时间复杂度也很好
//真心想省事的话，直接Arrays.sort完事...
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {


        quickSort(arr, 0, arr.length - 1);

        int[] res = new int[k];

        System.arraycopy(arr, 0, res, 0, k);

        return res;
    }


    //快速排序，快速排序的本质就是分区，随机确定一个值，以这个数值为中心，排序，左边的比他小，右边的比他大，
    //这样就达到了宏观排序，那么在对两边分别进行上述分区操作，直到不可分
    public static void quickSort(int[] arr, int L, int R) {
        if(L < R) {
            // 把数组中随机的一个元素与最后一个元素交换，这样以最后一个元素作为基准值实际上就是以数组中随机的一个元素作为基准值
            // Random().nextInt()这函数是去一个随机，比如Random().nextInt(10），就是取一个0-9的随机数
            swap(arr, new Random().nextInt(R - L + 1) + L, R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     * 分区的过程，整数数组 arr 的[L, R]部分上，使得：
     *  大于 arr[R] 的元素位于[L, R]部分的右边，但这部分数据不一定有序
     *  小于 arr[R] 的元素位于[L, R]部分的左边，但这部分数据不一定有序
     *  等于 arr[R] 的元素位于[L, R]部分的中间
     * 返回等于部分的第一个元素的下标和最后一个下标组成的整数数组
     */
    public static int[] partition(int[] arr, int L, int R) {

        int basic = arr[R]; //整个遍历过程实际上只有L作为指针遍历，其他成分都是辅助交换
        int less = L - 1;   //这个下标指向的元素一定比基准值小，
        int more = R + 1;   //这个下标指向的元素一定比基准值大
        while(L < more) {
            if(arr[L] < basic) {
                swap(arr, ++less, L++);
            } else if (arr[L] > basic) {
                swap(arr, --more, L);
            } else {
                //此时目标值和标准值一样，往下走
                L++;
            }
        }

        //返回的是中线位置，这中间的数字一定相等
        return new int[] { less + 1, more - 1 };

    }

    /*
     * 交换数组 arr 中下标为 i 和下标为 j 位置的元素
     * 这里不能使用其他交换！
     * arr[i] ^= arr[j];
     * arr[j] ^= arr[i];
     * arr[i] ^= arr[j];
     * 使用运算符完成数据交换时，对于同一个地址的数据交换会将该地直的值，变为0的。
     * arr[i] = arr[i]+arr[j];
     * arr[j] = arr[i]-arr[j];
     * arr[i] = arr[i]-arr[j];
     * 这个同理，比如交换i，j都为3，那么第一次arr[3]就会为6，然后自己减自己，这个位置就会变成0
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
