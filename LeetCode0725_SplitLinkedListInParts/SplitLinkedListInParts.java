package LeetCode0725_SplitLinkedListInParts;

public class SplitLinkedListInParts {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode cur = root;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        ListNode[] res = new ListNode[k];
        int avg = count / k, reminder = count % k;
        cur = root;
        for(int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            for(int j = 1; j < avg + ((i < reminder)? 1 : 0); j++) {
                cur = cur.next;
            }
            ListNode t = cur.next;
            cur.next = null;
            cur = t;
        }
        return res;
    }
}
