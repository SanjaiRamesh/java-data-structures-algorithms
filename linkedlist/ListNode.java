package linkedlist;

public class ListNode {

    int val;
    ListNode next;
    ListNode (int val) {
        this.val = val;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
