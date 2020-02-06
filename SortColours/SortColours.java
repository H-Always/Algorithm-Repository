/**
 * @ClassName SortColours
 * @Description: TODO 给定三种颜色，把他们按照正确的方式排列
 * @Author 余霜
 * @Date 2019/9/17
 * @Version V1.0
 **/

/**
 * 给出一个颜色数组，现有红黄蓝三种颜色，红色用0表示，黄色用1表示，蓝色用2表示，把他们按照红蓝黄(0,2,1)的方式排列
 */

public class SortColours {

    public int[] sortColours(int[] colours) {
        //声明头和尾，用来交换颜色
        int front = 0;
        int rear = colours.length - 1;
        int i = 0;

        //交换条件，遇到1则往前走一个，遇到0就和前面的2交换，遇到1就和最后面的一个元素交换
        //注意下标i的移动条件，保证交换的时候i指向的是1，和后面交换则随意，因为交换完也要重新判断front
        while (front <= rear)
            if (colours[front] == 0) {
                swap(colours, i, front);
                i++;
                front++;
            } else if (colours[front] == 1) {
                swap(colours, front, rear);
                rear--;
            } else
                front++;

        return colours;
    }

    //交换函数
    public void swap(int[] arr, int i, int j) {
//        //不了解位运算的同学也可以使用下面的交换函数,效果一样
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        if(i==j)
            return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
