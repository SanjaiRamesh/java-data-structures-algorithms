package linkedlist;

public class ReverseList {

    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next; // first, make sure we don't lose the next node
            curr.next = prev;              // reverse the direction of the pointer
            prev = curr;                   // set the current node to prev for the next node
            curr = nextNode;               // move on
        }

        return prev;
    }
}
