import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LetterCombinations
 * @Description: 电话号码的字母组合
 * @Author: 余霜
 * @date: 2020/3/7/11:26
 * @Version: 1.0
 *
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

//这题看到就想到了回溯，但是暴力解比较好写，有空我补上
public class LetterCombinations {

    //这题没什么思路，就是暴力解出来的，也不难....
    //其实就是排列组合，然后一循环就可以了
    public List<String> letterCombinations(String digits) {

        //如果小于1的话，证明传入进来的是一个空串，直接返回就好
        if (digits.length() == 0)
            return new ArrayList<>();

        //手机对应键盘，可以看看自己手机的九键输入法
        ArrayList<ArrayList<String>> list = new ArrayList<>() {
            {
                add(new ArrayList<String>(){{add("");}});
                add(new ArrayList<String>(){{add("a");add("b");add("c");}});
                add(new ArrayList<String>(){{add("d");add("e");add("f");}});
                add(new ArrayList<String>(){{add("g");add("h");add("i");}});
                add(new ArrayList<String>(){{add("j");add("k");add("l");}});
                add(new ArrayList<String>(){{add("m");add("n");add("o");}});
                add(new ArrayList<String>(){{add("p");add("q");add("r");add("s");}});
                add(new ArrayList<String>(){{add("t");add("u");add("v");}});
                add(new ArrayList<String>(){{add("w");add("x");add("y");add("z");}});
                }
        };

        //取一下数字，这个方法是字符串转换数字，如果字符串不规范的话可以用正则表达式
        int num = Integer.parseInt(digits);

        //创建结果集
        ArrayList<String> result = new ArrayList<>(){{add("");}};

        //这里的第二层循环可以写成for (String re : res) ，这么写虽然清楚一点，但是会浪费一点时间，测试大概2毫秒，
        // 2毫秒差的就算不少了，算法执行一共才三毫秒
        //按位取数字，每次取最后一位，然后开始排列存到临时结果集，再把临时结果集放到最终结果集里就行了
        while(num>1) {
            int bytes = num % 10;
            num /= 10;
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < result.size() ; i++) {
                for (int j = 0; j < list.get(bytes-1).size(); j++) {
                    res.add(list.get(bytes-1).get(j)+result.get(i));
                }
            }
            result = res;
        }


        return result;
    }

}
