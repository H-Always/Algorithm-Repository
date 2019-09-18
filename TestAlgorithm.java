package AlgorithmPackge;

/**
 * @ClassName TestAlgorithm
 * @Description: TODO 这是所有方法的入口
 * @Author 余霜
 * @Version V1.0
 **/

public class TestAlgorithm {

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
