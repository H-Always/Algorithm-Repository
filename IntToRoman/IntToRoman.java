/**
 * @ClassName: IntToRoman
 * @Description: 整数转罗马数字
 * @Author: 余霜
 * @date: 2020/3/6/18:56
 * @Version: 1.0
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntToRoman {

    //贪心算法，主流思想
    public String intToRoman_Greedy(int num) {

        //构建一个哈希表，这里用HashMap有点不太好用，
        // 想知道在这个题中为什么不太好用可以详细了解一下hash的底层和实现
        //这两个数组也可以写成一个二维数组，效果一样，可能还好看点
        int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        StringBuilder sb = new StringBuilder();

        //这里的13是因为数组的长度最大13，也就说，只有十三种情况，无论如何13次遍历都会出结果
        //这个算法时间复杂度为O(1)，别看两个循环只执行常数次
        for (int i = 0; i < 13; i ++ )
            //从最大开始减小数字，添加到结果字符串中
            while(num >=keys[i] )
            {
                num -= keys[i];
                sb.append(values[i]);
            }

        return sb.toString();
    }


    //这个也可以算作时最快的方法了，但是牺牲了一丢丢空间，拿时间换空间没毛病
    //这个应该也算是一种贪心算法把
    public String intToRoman_SimpleBF(int num) {

        // 把所有可能出现的可能都规划到一张表中
        // 因为题目最大给出只有四位数，所以数组最大深度为4
        String[][] c = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };

        //返回的结果直接就是每一位对应的罗马数字，千位多少，百位多少以此类推
        return c[3][num / 1000] +
                c[2][num / 100 % 10] +
                c[1][num / 10 % 10] +
                c[0][num % 10];

    }

    //暴力解,这个没什么好说的，按照题目定义循环就完事了
    public String intToRoman_BF(int num) {

        if (num == 1){
            return "I";
        }

        StringBuilder sb = new StringBuilder();

        while(num>=1){
            if (num/1000!=0) {
                sb.append("M".repeat(num/1000));
                num = num%1000;
                continue;
            }

            if (num/900!=0) {
                sb.append("CM");
                num = num%900;
                continue;
            }

            if (num/500!=0) {
                sb.append("D");
                num = num%500;
                continue;
            }
            if (num/400!=0) {
                sb.append("CD");
                num = num%400;
                continue;
            }

            if (num/100!=0) {
                sb.append("C".repeat(num/100));
                num = num%100;
                continue;
            }

            if (num/90!=0) {
                sb.append("XC");
                num = num%90;
                continue;
            }

            if (num/50!=0) {
                sb.append("L");
                num = num%50;
                continue;
            }

            if (num/40!=0) {
                sb.append("XL");
                num = num%40;
                continue;
            }

            if (num/10!=0) {
                sb.append("X".repeat(num/10));
                num = num%10;
                continue;
            }

            if (num/9!=0){
                sb.append("IX");
                num = num%9;
                continue;
            }
            if (num/5!=0) {
                sb.append("V");
                num = num%5;
                continue;
            }

            if (num/4!=0) {
                sb.append("IV");
                break;
            }

            sb.append("I".repeat(num));
            break;

        }

        return sb.toString();
    }
}
