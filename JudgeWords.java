package AlgorithmPackge;

import java.util.Arrays;

/**
 * @ClassName JudgeWords
 * @Description: TODO 判断目标单词是否出现在已给字典中
 * @Author 余霜
 * @Date 2019/9/18
 * @Version V1.0
 **/

public class JudgeWords {
    public boolean judgeWords(char[][] dictionary, String words) {

        //先把目标单词转换成数组，方便判断
        char[] wordArr = words.toCharArray();

        System.out.println(Arrays.toString(wordArr));
        //如果当前目标字母存在的话一定位于前后左右四个方向，所以建立一个方向数组
        //注意，虽然有四个方向，但只有三个方向可以走，因为第四个方向是来的方向
        int[][] direction = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        //遍历dictionary判断
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary[0].length; j++) {
                //调用回溯方法，如果返回的是false说明不存在或者当前顺序不对
                if (backtracking(dictionary, direction, wordArr, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;

    }


    //回溯方法，把当前的位置用save记录，然后开始往下判断字母
    //如果不对的话就往回回溯，save在赋值回去
    public boolean backtracking(char[][] dictionary, int[][] direction, char[] wordArr, int i, int j, int target) {

        if (target == wordArr.length)
            return true;

        //如果dictionary的下标小于零或者越界，自然是不合法的，返回false
        if (i < 0 || j < 0 || i == dictionary.length || j == dictionary[0].length)
            return false;

        //我们用#来表示之前已经走过的路线，当所走位置重复或者下一步的字母和目标不符的话，返回false
        if (dictionary[i][j] == '#' || dictionary[i][j] != wordArr[target])
            return false;

        //保存当前步
        char save = dictionary[i][j];

        boolean result = false;

        //把当前的步标记为已走
        dictionary[i][j] = '#';

        for (int[] dir :
                direction) {
            //往下走的新的坐标值
            int row = i + dir[0];
            int col = j + dir[1];

            //'|'为或运算，false|false = false ,true|false = true ,true|true = true
            //注意，这里不要写成++target,这个语句直接改变了target的值
            result |= backtracking(dictionary, direction, wordArr, row, col, target+1);

            if (result)
                return true;
        }

        //如果当前路走不通，就回溯
        dictionary[i][j] = save;

        return false;
    }
}
