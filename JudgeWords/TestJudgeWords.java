/**
 * @ClassName: Test
 * @Description: TODO 算法测试
 * @Author: 余霜
 * @date: 2020/2/6/17:18
 * @Version: 1.0
 */
public class TestJudgeWords {
    public static void main(String[] args) {
        char[][] dictionary = {
                {'A','E','E','U','I'},
                {'D','F','T','R','O'},
                {'D','S','T','M','P'},
                {'Q','A','F','N','K'},
                {'E','B','H','V','L'},
        };

        String word = "QAFHVNMRO";
        JudgeWords ys = new JudgeWords();
        boolean res = ys.judgeWords(dictionary,word);

        System.out.println(res);
    }
}
