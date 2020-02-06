/**
 * @ClassName DeleteLinkListDuplicateNode
 * @Description: TODO 删除排序链表的重复节点
 * @Author 余霜
 * @Date 2019/9/20
 * @Version V1.0
 **/

/**
给定一个排序链表，删除所有元素值重复的节点
        例如：
        输入1->2->2->3->3->3->4
        输出1->2->3->4
        链表是一种数据结构，不太熟练的同学推荐自己构建一个完整的链表，写一下里面的方法
        不会数据结构的同学也强烈推荐看一看这门课
*/

/*
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
*/

public class DeleteLinkListDuplicateNode {
    public ListNode deleteLinkListDuplicateNode(ListNode head) {
        //把头节点信息做一个副本，方便使用
        ListNode node = head;
        //如果当前节点有后继节点，则正常遍历
        while (node.next != null) {
            //如果当前节点元素和下一个节点元素想等，就把下一个节点删除
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {//否则继续遍历
                node = node.next;
            }
        }
        return head;
    }
}
