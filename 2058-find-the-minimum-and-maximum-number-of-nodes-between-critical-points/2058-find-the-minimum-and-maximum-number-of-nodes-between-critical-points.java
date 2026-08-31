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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        ArrayList<Integer> index = new ArrayList<>();

        for(int i=1; i<list.size()-1; i++){

            if((list.get(i-1) < list.get(i)) && (list.get(i) > list.get(i+1))){
                index.add(i);
            }else if((list.get(i-1) > list.get(i)) && (list.get(i) < list.get(i+1))){
                index.add(i);
            }
        }

    if(index.size() <= 1){
        return new int[]{-1,-1};
    }

    int[] res = new int[2];
    Arrays.fill(res, Integer.MAX_VALUE);
    for(int i=0; i<index.size()-1; i++){
        res[0]= Math.min(res[0],(index.get(i+1)-index.get(i)));
    }

    res[1] = index.get(index.size()-1)-index.get(0);

    return res;
}
}