/**
 * @ClassName: MiddleNode
 * @Description: 链表的中间结点
 * @Author: 余霜
 * @Date: 2020/03/23 08:57
 * @Version: V1.0
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/


/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//这题没啥想写的，思路无非就是一个指针走两步，另一个指针走一步..
//如果想写的复杂一点设置一个标志判断也可以
//链表的一些题都可以转化为数组题，比如这个就可以变成未知长度找到数组中间下标
//必须吐槽一下这测试用例！！，说好的带头节点呢！
// 1->2->3->4->5->6,实际上是0->1->2->3->4->5->6结果返回的是3才算对！
// 好坑...
public class MiddleNode {


    public ListNode middleNode(ListNode head) {

        //两个指针，以快一慢
        ListNode p = head, q = head;
        //一个走两步，一个走一步
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        return p;
    }

    //设置标志判断
    public ListNode middleNode_A(ListNode head) {

        //初始标志为1
        int mark = 1;
        ListNode cur = head;
        ListNode mid = head;

        while (cur.next!=null){
            cur = cur.next;
            mark++;
            if (mark%2==0)
                mid = mid.next;
        }

        return mid;
    }

}
