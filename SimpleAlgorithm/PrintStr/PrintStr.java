import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: PrintStr
 * @Description: 倒序输出字符串
 * @Author: 余霜
 * @Date: 2021/03/04 20:42
 * @Version: V1.0
 **/

// 这是我一个同学问我的题，他今天面试，面试官说的这个题，问他能想出来几种方法...
// 我没太想，暂时就这五种，别的高级方法不一定想得出来，这五个不是有手就行...
// 我把它喷了一顿给他说了一遍

public class PrintStr {
    // 递归
    public void printStr(String str){
        print(str,0,str.length()-1);
    }

    public void print(String str,int i,int len){
        if (i>len)
            return;
        else
            print(str,i+1,len);

        System.out.print(str.charAt(i));
    }


    // 迭代转字符串打印
    public void printStr1(String str){
        int i = str.length();
        char[] ch = new char[str.length()];

        for (char o : str.toCharArray()) {
            ch[i-1] = o;
            i--;
        }
        System.out.println(Arrays.toString(ch));
    }

    // 数组打印
    public void printStr2(String str){
        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }

    // 直接反转
    public String printStr3(String str){
        return new StringBuilder(str).reverse().toString();
    }

    // 栈
    public String printStr4(String str){
        Stack<Character> stack = new Stack<>();
        for (Character o : str.toCharArray()) {
            stack.push(o);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
