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
    public ListNode insertionSortList(ListNode head) {
        int MIN = -5000, MAX = 5000;
        int OFFSET = 5000;
        int RANGE = MAX - MIN +1;

        int[] freq = new int[RANGE];
        ListNode curr = head;
        while(curr != null){
            freq[curr.val + OFFSET]++;
            curr = curr.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(int i =1; i < RANGE; i++){
            int count = freq[i];
            int value = i - OFFSET;

            for(int j = 0; j < count; j++){
                tail.next = new ListNode(value);
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}