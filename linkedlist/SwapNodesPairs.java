package linkedlist;

public class SwapNodesPairs {

    public ListNode swapPairs(ListNode head) {


        if( head == null || head.next == null ) {
            return head;
        }

        ListNode dummy = head.next;
        ListNode prev = null;


        while (head != null ) {

            if( prev != null ) {
                prev.next = head.next;
            }
            prev = head;
            ListNode next = head.next.next;
            head.next.next = head;

            head.next = next;
            head = next;

        }
        return dummy;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        SwapNodesPairs obj = new SwapNodesPairs();
        ListNode.print(head);
        ListNode.print(obj.swapPairs(head));
    }
}
