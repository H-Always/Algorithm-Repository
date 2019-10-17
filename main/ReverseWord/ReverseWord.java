package AlgorithmPackge;

/**
 * @ClassName ReverseStringWord
 * @Description: TODO 反转字符串单词
 * @Author 余霜
 * @Date 2019/10/17 22:39
 * @Version V1.0
 **/

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
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < reverse.length; j++) {

                sb.append(reverse[j]);
            }
            part[i] = sb.toString();
        }

        //新建一个变量，把转换的字符串数组再转回去
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < part.length; i++) {
            sb.append(part[i]);
            if (i < part.length - 1)
                sb.append(",");
        }

        String res = sb.toString();

        return res;
    }
}


