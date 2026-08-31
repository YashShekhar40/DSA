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
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int[] ret = new int[2];
        ret[0] = Integer.MAX_VALUE;
        ret[1] = Integer.MIN_VALUE;

        while (next != null)
        {
            if (prev != null)
            {
                if ((prev.val < curr.val && curr.val > next.val) || (prev.val > curr.val && curr.val < next.val))
                {
                    list.add(count);
                }
            }

            prev = curr;
            curr = curr.next;
            next = curr.next;
            ++count;
        }

        if (list.isEmpty())
            return new int[]{-1, -1};

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 1; i < arr.length; ++i)
        {
            if (arr[i] - arr[i - 1] < ret[0])
            {
                ret[0] = arr[i] - arr[i - 1];
            }
        }

        if (arr.length > 1)
        ret[1] = arr[arr.length - 1] - arr[0];

        if (ret[0] == Integer.MAX_VALUE)
            ret[0] = -1;

        if (ret[1] == Integer.MIN_VALUE)
            ret[1] = -1;

        return ret;

        
    }
}