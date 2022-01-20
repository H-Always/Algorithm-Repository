import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName : RomanToInt
 * @ Description :罗马数字转整数
 * @ Author : 余霜
 * @ Date : 2022/1/20 14:40
 * @ Version : 1.0
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "III"
 * 输出: 3
 *
 * 提示：
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 **/

//刚拿到题，在纸上写了一下，”MCMXCIV“ 为 ”100 100 1000 10 100 1 5“，这个罗马文表示1994
//可以发现所有的有效位都是升序的，所以现在只需要转换成数字，一个个判断单调就好了
//但是这题好像可以投机取巧，因为数字是固定的，比如4是IV 900是DM 既然固定了，那就把所有的组合替换一下就行了
//写完后记，这题一遍过，但是好像写的有点点复杂了，很多不必要的判断，就这样吧，也写了一个简单的
public class RomanToInt {
    public int romanToInt(String s) {

        //先把字符串转换成字符数组，
        char[] cutS = s.toCharArray();
        System.out.println(Arrays.toString(s.toCharArray()));

        //判断的数字字符串，注意，这里是length+1，这个+1很重要，相当于判别位，默认给的0
        int[] num = new int[s.length()+1];

        //数字和字母一一对应
        Map<Character, Integer> mapRoman = new HashMap<>();
        mapRoman.put('I', 1);
        mapRoman.put('V', 5);
        mapRoman.put('X', 10);
        mapRoman.put('L', 50);
        mapRoman.put('C', 100);
        mapRoman.put('D', 500);
        mapRoman.put('M', 1000);


        for (int i = 0; i < s.length(); i++) {
            if (mapRoman.containsKey(cutS[i])) {
                num[i] = mapRoman.get(cutS[i]);
            }
        }
        System.out.println(Arrays.toString(num));

        return judgeOrder(num);
    }

    //从左到右，判断是否是降序，出现了降序(前面的数字大于后面的数字)代表有组合数字出现，加在一起就好了
    //这个组合数字，说白了就是最左边的减去最右边的，比如IVC 就是100-5-1，但是这样不好算，可以写成100-(5+1)
    public int judgeOrder(int[] num){
        if (num.length == 1)
            return num[0];

        int con = 0;    //当前结果
        int partNum; //部分和
        int curPartNum = 0; //部分和的前面相加，就是那个(5-1)

        //部分和从哪到哪，然后累加
        int front = 0;
        int rear;

        for (int i = 0; i < num.length-1; i++) {
            rear = i+1;

            //出现前面比后面大，就代表出现了组合数字
            if (num[rear-1]>=num[rear]) {
                if (rear-front == 1)
                    partNum = num[rear-1];
                else {
                    //计算(5+1)
                    for (int j = front; j <= rear - 2; j++) {
                        curPartNum += num[j];
                    }
                    //再减去这个数字
                    partNum = num[rear-1] - curPartNum;
                }
                con +=partNum;
                curPartNum = 0;
                front = rear;
            }
        }


        return con;
    }

    //这题拿到手就觉得可以偷天换日，
    public int simpleRomanToInt(String s) {
        //按照规则切割字符串，一共就这么几种..
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getValue(s.charAt(i));
        }
        return res;
    }

    public int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            case 'a' -> 4;
            case 'b' -> 9;
            case 'c' -> 40;
            case 'd' -> 90;
            case 'e' -> 400;
            case 'f' -> 900;
            default -> 0;
        };

    }
}
