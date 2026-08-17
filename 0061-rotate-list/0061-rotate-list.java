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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null){
            return null;
        }
        ListNode temp = head;
        int len = 1;

        while(temp != null && temp.next != null){
            temp = temp.next;
            len++;
        }

        temp.next = head;
        temp = head;
        k = k%len;
        int d= len -k-1;

        while(d-- > 0){
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;


        return head;


    }
}