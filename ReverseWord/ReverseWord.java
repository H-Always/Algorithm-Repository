/**
 * @ClassName ReverseStringWord
 * @Description: 反转字符串单词
 * @Author 余霜
 * @Date 2019/10/17 22:39
 * @Version V1.0
 **/

/**
 * 给定一个以“,”分隔开的单词字符串，你需要把这个字符串中的每一个单词都反转过来，并且返回一个数组
 *
 * 例如：
 * 给定 String s = "hello,world,,mirror,,apple,incisive,include,contain";
 * 输入[olleh, dlrow, , rorrim, , elppa, evisicni, edulcni, niatnoc]
 *
 * 注意，即使是相邻分隔符中没有单词也不能将其删除，要返回一个空位置
 *
 */

public class ReverseWord {
    public String reverseWord(String str) {
        //如果为空，直接返回
        if (str.length() == 1||str.length() == 0){
            return str;
        }

        //按照给定的分隔符号分隔所给字符串，生成字串
        String[] part = str.split(",");

        //对每一个字串进行反转
        for (int i = 0; i < part.length; i++) {
            //把字串转换成为数组，然后简单的对数组里每个字符都反转
            char[] reverse = part[i].toCharArray();

            int front = 0, rear = reverse.length - 1;
            while (front <= rear) {
                char temp = reverse[front];
                reverse[front] = reverse[rear];
                reverse[rear] = temp;
                front++;
                rear--;
            }

            //注意这里的字符串变量，是变量
            StringBuilder sb = new StringBuilder();
            for (char c : reverse) {
                sb.append(c);
            }
            part[i] = sb.toString();
        }

        //新建一个变量，把转换的字符串数组再转回去
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < part.length; i++) {
            sb.append(part[i]);
            if (i < part.length - 1)
                sb.append(",");
        }

        return sb.toString();
    }
}


