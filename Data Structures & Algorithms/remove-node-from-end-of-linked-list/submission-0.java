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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode temp = head;
      int cnt = 0;
      while(temp!=null){
       
        temp=temp.next;
         cnt++;
      }
      if(cnt==n)return head.next;
      int res = cnt-n;
      temp=head;
      while(res>1){
        res--;
        temp=temp.next;
        if(res==0)break;
      }
      temp.next = temp.next.next;
      return head;
    }
}
