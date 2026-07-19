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
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode temp=head;
        Map<ListNode,Integer>hm = new HashMap<>();
        while(temp!=null){
            if(hm.containsKey(temp)){
                return true;
            }
            hm.put(temp,1);
            temp = temp.next;
        }
        return false;
    }
}
