public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;  // 暂存当前节点的下一个节点
            current.next = prev;  // 将当前节点的 next 指向前一个节点
            prev = current;       // 将前一个节点指针向前移动
            current = next;       // 将当前节点指针向前移动
        }

        return prev;  // 返回新的头节点
    }

    public static void main(String[] args) {
        // 创建一个示例链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 打印反转之前的链表 反转前： 1 2 3 4 5
//        System.out.print("反转前： ");
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//        System.out.print("\n");

        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);

        // 打印反转后的链表
        System.out.print("反转后： ");
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
        System.out.print("\n");
    }
}