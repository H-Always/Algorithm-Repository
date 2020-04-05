import java.util.Stack;

/**
 * @ClassName: Trip
 * @Description: 接雨水
 * @Author: 余霜
 * @Date: 2020/04/05 11:01
 * @Version: V1.0
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 **/
//这个题很早之前就写过，在我上数据结构课的时候，那个时候还很菜，用的笨法子一点一点遍历，时间复杂度也很差
// 用单调栈！就是一个普通的栈，但是栈里面的元素单调，
// 其实就是从最下面一层开始，一层一层的收集雨水。
// 这题还可以用双指针，有机会写一下
public class Trip {
    public int trip(int[] height){

        if (height == null)
            return 0;

        //创建一个栈，注意，栈的里面收集的是数组元素对应下标
        Stack<Integer> stack = new Stack<>();
        int maxRain = 0;
        //遍历数组
        for (int i = 0; i < height.length; i++) {
            //如果栈不为空的话，证明里面可能可以收集雨水，进入while的条件是判断的元素不在单调
            // 就像5421，如果现在判断4，那就不在单调了，就要进行收集雨水的操作
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 获取一下当前的栈头，也就是最下面一层的雨水要减去的高度差，比如5422判断6，那么6和4围城的面积中要减去22的高度
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。
                    maxRain += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return maxRain;

    }


    //如果判断数组元素的话，前面元素的下标位置将会很难处理，也可能是我太菜了
    //反正我是没写出来...留一个坑，有机会好好想一下
    public int trip_QAQ(int[] height){
        if (height.length <= 2)
            return 0;

        int maxRain = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(height[0]);

        int top;

        for (int i = 1; i < height.length; i++) {

            while (stack.size() > 0 && stack.peek() < height[i]) {

                System.out.print(stack);

                top = stack.pop();


                while (!stack.empty() && stack.peek() == top)
                    stack.pop();

                if (!stack.empty()) {
                    int index = 0;


                    maxRain += (i - (index+1)) * (Math.min(height[i], stack.peek()) - top);
                }
            }

            stack.push(height[i]);
        }


        return maxRain;
    }

}
