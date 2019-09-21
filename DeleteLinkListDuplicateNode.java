package AlgorithmPackge;

/**
 * @ClassName DeleteLinkListDuplicateNode
 * @Description: TODO 删除排序链表的重复节点
 * @Author 余霜
 * @Date 2019/9/20
 * @Version V1.0
 **/

public class DeleteLinkListDuplicateNode {
    public LinkNode deleteLinkListDuplicateNode(LinkNode head) {
        //把头节点信息做一个副本，方便使用
        LinkNode node = head;
        //因为头节点不保存信息，所以从第二个节点开始
        node = node.next;
        //如果当前节点有后继节点，则正常遍历
        while (node.next != null) {
            //如果当前节点元素和下一个节点元素想等，就把下一个节点删除
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else {//否则继续遍历
                node = node.next;
            }
        }
        return head;
    }
}
