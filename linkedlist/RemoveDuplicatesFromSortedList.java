package linkedlist;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev =  head;
        ListNode cur =  head.next;


        while(cur != null) {
            if(prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur =  cur.next;
        }
        return head;
    }

    public void print(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList sol = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(8);
        sol.print(head);
        ListNode node = sol.deleteDuplicates(head);
        System.out.println("***********removed dup**********");
        sol.print(node);

    }
}
