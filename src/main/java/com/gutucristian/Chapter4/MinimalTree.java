package com.gutucristian.Chapter4;/*
  Problem: chapter 4 problem 2
*/

import java.util.Queue;
import java.util.LinkedList;

class MinimalTree {
  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  public static TreeNode createMinimalBST(int[] array, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(array[mid]);
    node.left = createMinimalBST(array, start, mid - 1);
    node.right = createMinimalBST(array, mid + 1, end);
    return node;
  }

  public static void printTreeLevelByLevel(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while (q.peek() != null) {
      TreeNode cur = null;
      int count = q.size();
      for (int i = 0; i < count; i++) {
        cur = q.poll();
        if (cur.left != null) q.add(cur.left);
        if (cur.right != null) q.add(cur.right);
        System.out.print(cur.val + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 3, 5, 7, 8, 9};
    TreeNode root = createMinimalBST(array, 0, array.length - 1);
    printTreeLevelByLevel(root);
  }
}