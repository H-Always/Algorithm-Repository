package AlgorithmPackge;

/**
 * @ClassName DeleteDuplicateElement
 * @Description: TODO 删除重复的元素
 * @Author 余霜
 * @Date 2019/9/19
 * @Version V1.0
 **/

public class DeleteDuplicateElement {
    public int deleteDuplicateElement(int[] element){
        int count = 1;//计数器初始为1，因为我们从下标1开始判断
        int length = element.length;

        for (int i = 1; i < length; i++) {
            //i从1开始遍历，和他的前一个元素比较
            int temp = element[i-1];

            //如果当前元素和上一个元素一样，那么计数器就+1
            //当计数器大于2的时候，就代表了有超过两个重复元素，就要进行删除操作
            if (element[i]==temp){
                count++;

                if (count>2){
                    //调用删除函数，注意这里的length要-1，否数组越界
                    move(element,i,length-1);
                    //每次覆盖一个，那最后的元素是多出来的，也就不需要判断了
                    length--;
                    //因为是覆盖，你不知道当前的值被什么元素覆盖了，重新判断当前的元素
                    i--;

                }
            }
            else{//如果不等于，就说明当前元素和上一个元素不一样，计数器重置
                count = 1;
            }

        }
        return length;
    }

    //覆盖删除函数，把下一个元素覆盖到当前重复元素
    public void move(int[] element,int i,int length){
        for (int j = i; j < length; j++) {
            element[j] = element[j+1];
        }
    }

}
