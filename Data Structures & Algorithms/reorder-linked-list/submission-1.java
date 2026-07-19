/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        Stack<ListNode>s = new Stack<>();
        while(curr!=null){
            s.push(curr);
            curr = curr.next;
        }
        curr = head;
        while(!s.isEmpty()){
            ListNode temp = curr.next;
            curr.next = s.pop();
            curr.next.next = temp;
            curr = temp;
        }
    }
}
