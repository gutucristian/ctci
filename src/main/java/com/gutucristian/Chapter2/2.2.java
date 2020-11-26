package com.gutucristian.Chapter2;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Index {
  public int value = 0;
}

class Solution {
	public static ListNode kthToLast(int k , ListNode head) {
		ListNode cur = head;
		ListNode runner = cur;
		while (cur != null) {
      // System.out.println("cur = " + cur.val);
			int count = 0;
      runner = cur;
		  while (runner != null) {
        // System.out.println("runner = " + runner.val + ", count = " + count);
		  	runner = runner.next;
				count++;
		  }
      // System.out.println("for cur = " + cur.val + " final count = " + count);
			if (count == k) return cur;
			cur = cur.next;
		}
		return head;
	}

  // Only returns value of kth node. DOES NOT return the actual node
  // because we can only return one thing from a method. To maintain the index
  // and the node though the call stack we can
  public static ListNode kthToLastRecur(int k, ListNode head, Index idx) {
    // int total = 0;
    if (head == null) {
      return head;
    }
    ListNode node = kthToLastRecur(k, head.next, idx);
    idx.value += 1;
    System.out.println("node: " + (node==null) + " head: " + (head==null) + " head val = " + head.val + ", idx = " + idx.value);
    // total += 1;
    if (idx.value == k) {
      System.out.println("idx.val = " + idx.value + ", k = " + k);
      return head;
    }
    return node; // when head is null we return head. thus node in line 43 gets null and we keep returning this null
    // for each stack frame until we reach idx.value == k, in that case we return head (the actual node for this call)
    // the next stack frame gets node equal to this head and hence the head keeps getting returned until the last stack frame
  }

  public static ListNode kthToLastI(int k, ListNode head) {
    ListNode runner = head;
    while (k != 0 && runner != null) {
      k--;
      runner = runner.next;
    }
    if (k == 0 && runner != null) {
      ListNode cur = head;
      while (runner != null) {
        runner = runner.next;
        cur = cur.next;
      }
      return cur;
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
    ListNode head = new ListNode(3);
    ListNode n1 = new ListNode(13);
    ListNode n2 = new ListNode(17);
    ListNode n3 = new ListNode(5);
    ListNode n4 = new ListNode(8);
    ListNode n5 = new ListNode(187);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    print(head);
    System.out.println("2nd = " + kthToLastI(2, head).val);
    // kthToLastRecur(2, head);
  }
}
