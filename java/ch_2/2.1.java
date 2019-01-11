import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

class Solution {
	// O(n) time, O(n) space
	public static ListNode removeDups(ListNode head) {
		HashSet<Integer> hs = new HashSet<Integer>();
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			// System.out.println("visit " + cur.val);
			next = cur.next;
			if (hs.contains(cur.val)) {
				// System.out.println(cur.val + " is in hs!");
				// delete cur
				prev.next = next;
				cur = next;
			} else {
				// System.out.println("add " + cur.val + " to hs");
				hs.add(cur.val);
				prev = cur;
				cur = next;
			}
		}
		return head;
	}

	// O(n) time, O(1) space
	public static ListNode removeDupsNoBuffer(ListNode head) {
		ListNode runner = null;
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			runner = cur;
			prev = cur;
			while (runner.next != null) {
				runner = runner.next;
				if (runner.val == cur.val) {
					// delete current runner node
					prev.next = runner.next;
					runner = prev;
				} else {
					prev = runner;
				}
			}
			cur = cur.next;
		}
		return head;
	}

	public static void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			if (cur.next == null) {
				System.out.print(cur.val + "\n");
			} else {
				System.out.print(cur.val + " -> ");
			}
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(16);
		ListNode n1 = new ListNode(16);
		ListNode n2 = new ListNode(16);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(8);
		ListNode n5 = new ListNode(16);

		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		print(head);
		removeDupsNoBuffer(head);
		print(head);
	}
}	
