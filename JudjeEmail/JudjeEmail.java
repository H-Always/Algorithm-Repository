/**
 * @ClassName JudgeEmail
 * @Description: TODO 判断邮箱格式是否正确
 * @Author 余霜
 * @Date 2019/12/1 22:24
 * @Version V1.0
 **/

/**
 * 判断给出邮箱是否满足xxxxxx@xx.xxx格式
 */

public class JudjeEmail {

    public boolean judjeEmail(String email){
        //准备工作
        int len = email.length();

        //正则匹配，按你的意思来
        String match = "^[a-z0-9A-Z]+$";

        //判断有没有‘@’和‘.’  长度是否正确
        if ((len>16||len<7)|| !email.contains("@") || !email.contains("."))
            return false;

        //判断最后是否是 xxxxxx@xx.xxx 格式
        if ( email.indexOf("@")<6||email.indexOf(".")-email.indexOf("@")!=3||len-email.indexOf(".")!=4)
            return false;

        //判断 ‘@’ 和 ‘.’ 是否重复
        if (email.indexOf("@")!=email.lastIndexOf("@")||email.indexOf(".")!=email.lastIndexOf("."))
            return false;

        //判断 @xx.xxx 格式之前是否符合给定格式
        return email.substring(0, email.indexOf("@")).matches(match);
    }

    //精简算法
    public boolean regex(String email){

        //正则匹配
        String regex = "[a-zA-Z0-9]{6,}@[a-zA-Z0-9]{2,4}[\\.a-zA-Z0-9]{2,4}";

        return email.matches(regex);
    }
}
