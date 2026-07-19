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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer>arr = new ArrayList<>();
       ListNode temp1 = list1;
       ListNode temp2 = list2;
       while(temp1!=null){
        arr.add(temp1.val);
        temp1 = temp1.next;
       }
        while(temp2!=null){
        arr.add(temp2.val);
        temp2 = temp2.next;
       }
        Collections.sort(arr);
        ListNode head = convertToLL(arr);
        return head;
    }
    public ListNode convertToLL(ArrayList<Integer>arr){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int i=0;i<arr.size();i++){
            temp.next = new ListNode(arr.get(i));
            temp=temp.next;
        }
        return dummy.next;
    }
}