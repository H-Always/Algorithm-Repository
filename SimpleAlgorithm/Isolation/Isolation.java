import java.util.*;

/**
 * @ClassName: Isolation
 * @Description: 隔离14天
 * @Author: 余霜
 * @Date: 2020/05/08 12:37
 * @Version: V1.0
 *
 * 问题F:隔离14天
 * 时间限制:1 Sec内存限制: 128 MB
 * 提交:636 解决: 105
 * 提交状态 讨论版
 * 题目描述
 * 新冠肺炎疫情是新中国成立以来，在我国发生的传播速度最快.感染范围最广、防控难度最大的一 -次重 大突发公共卫生事件。伟大的中国人民在以习近平总书记为核心的党中央坚强领导下，采取最全面、最严格、最彻底的防控举措，以巨大勇气和强大力量，坚决阻断全国本土疫情传播，取得了疫情防控阶段性重要成效。英雄的湖北人民武汉人民
 * 做出了巨大的牺牲。数以万计的逆行者，以血肉之躯和钢铁意志，组成了疫情防控坚不可摧的长城。“哪有什么岁月静好，不过是有人替你负重前行”，向所有的抗疫英雄们致敬，感谢您们! ! !
 * 为了能够有效切斯新冠病毒的传播途径，基于对新冠病毒肺炎的流行病学调查。要求所有与确诊 患者有过密切接触者、有疑以症状者。 疫情期间去过疫区者或者其他当地卫生部门认为需要隔高者需要居家隔离或者集中隔高14天。其密切接触者包括与确诊患者乘坐同-交通工具，比如高铁公交、 汽车等并有近距离接触的人。
 * 现在假定编寻力的柔套冠状病南核展经金呈阳性， 请编号一个程序统十需高高的总人数(包括最今力的乘有0387金部5安台万富家刘青康中陶1，
 * 输入
 * 第1行的第1个数字n表示总人数，第2个数字m表示汽车数量;从第2行开始，接下来的m行表示每辆汽车的司乘人员总人数和人员编号(人员编号是一个固定值， 可以对应于我们的身份证号码)，每 -行的第1个数字k表示该汽车的司乘人员总数，接下来的k个数字表示每个人的编号。
 * 需要被隔离的总人数。
 * 样例输入
 * 100 4
 * 2 1 2
 * 5 10 13 11 12 14
 * 2 0 1
 * 2 99 2
 * 样例输出Copy
 * 4
 **/
//这题是我在淘宝接的单，写完他跑路了
public class Isolation {

    public int isolation(List<List<Integer>> peop){

        if(peop.get(0).get(0)==0||peop.get(0).get(1)==0)
            return 0;

        //这个集合用来存储所有需要隔离的名单
        Set<Integer> set = new HashSet<>();

        //找出所有编号为0的人员名单，存到map集合里
        for (int i = 1; i < peop.size(); i++) {
            for (int j = 1; j < peop.get(i).size(); j++) {
                //如果该车辆里面有人员编号为0，证明全部要隔离
                if (peop.get(i).get(j)==0){
                    //遍历这辆车，把隔离人编号存到set集合里
                    for (int k = 1; k < peop.get(i).size(); k++) {
                        set.add(peop.get(i).get(k));
                    }
                    break;
                }
            }
        }

        //遍历所有车子，找出存在与密切接触者接触的所有人员，加入到map集合
        for (int i = 1; i < peop.size(); i++) {
            for (int j = 1; j < peop.get(i).size(); j++) {

                //如果某一辆车上出现了密切接触患者，则全部加进去
                if (set.contains(peop.get(i).get(j))){
                    for (int k = 1; k < peop.get(i).size(); k++) {
                        set.add(peop.get(i).get(k));
                    }

                    break;
                }

            }
        }


        System.out.println(set);

        return set.size();
    }
}
