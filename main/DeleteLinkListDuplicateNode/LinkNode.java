package AlgorithmPackge;

/**
 * @ClassName LinkNode
 * @Description: TODO 构建链表结构，简陋版本
 * @Author 余霜
 * @Date 2019/9/20
 * @Version V1.0
 **/

public class LinkNode {

    //数据域，就是链表存放数据的位置
    public int value;
    //指针域，存放下一个链表节点的位置信息
    public LinkNode next = null;

    //补一个构造方法
    public LinkNode(int value) {
        this.value = value;
    }

    //另一个构造方法，方便传值
    public LinkNode(int value, LinkNode next) {
        this.value = value;
        this.next = next;
    }

    //这个方法用来连接节点，使得分散的节点成为一个链表
    public LinkNode addToNode(LinkNode nextNode) {
        this.next = nextNode;
        return nextNode;
    }

    //写一个toString，方便打印
    public void toString(LinkNode node) {
        node = node.next;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
