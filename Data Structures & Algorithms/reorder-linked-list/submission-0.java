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
        List<ListNode> arrl = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            arrl.add(temp);
            temp = temp.next;
        }
        int i=0,j=arrl.size()-1;
        while(i<j){
            arrl.get(i).next = arrl.get(j);
            i++;
            if(i==j)break;
            arrl.get(j).next = arrl.get(i);
            j--;
        }
        arrl.get(i).next = null;
    }
}
