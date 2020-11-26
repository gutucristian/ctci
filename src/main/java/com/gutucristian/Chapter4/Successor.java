package com.gutucristian.Chapter4;

import java.util.Queue;
import java.util.LinkedList;

class Successor {
  private static class Node {
    Node left;
    Node right;
    Node parent;
    final int val;

    Node(Node parent, int val) {
      this.val = val;
      this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
      // self check
      if (this == o)
      return true;
      // null check
      if (o == null)
      return false;
      // type check
      if (getClass() != o.getClass())
      return false;
      // cast
      Node node = (Node) o;
      // field comparison
      return val == node.val;
    }

    /*
      NOTE: whenever you provide a custom implementation for equals
      hashCode must also be overrided to return same hash code for
      equal objects (objects with same hash code may not be equal, but
      objects that are equal have same hash code).
    */

    @Override
    public int hashCode() {
      int prime = 31;
      int result = 1;
      result = prime * result + ((Integer) val).hashCode();
      return result;
    }
  }

	public static void main(String[] args) {
		int[] tree = {12, 9, 15, 4, 11, 13, 22};
		Node root = buildTree(null, tree, 0);
		printLevels(root);
		Node node = findNode(root, 11);
		System.out.println(node.val);
		System.out.println("inorder successor: " + inorderSuccessor(node).val);
	}

	public static Node inorderSuccessor(Node node) {
		System.out.println("[inorderSuccessor] return inorder successor for node: " + node.val);

		if (node.right != null) {
			System.out.println("[inorderSuccessor] node has right child");
			System.out.println("[inorderSuccessor] return inorder successor: " + node.right.val);
			return node.right;
		}

		System.out.println("[inorderSuccessor] node does not have right child.. navigate up tree to find inorder successor");

		Node parent = node.parent;
		Node current = node;

		while (parent != null && !parent.left.equals(current)) {
			System.out.println("[inorderSuccessor] node parent: " + parent.val);
			System.out.println("[inorderSuccessor] node: " + current.val);

			current = parent;
			parent = parent.parent;
		}

		return parent;
	}

	/**
	* Find Node in BST with given value.
	*
	* @param		val		the value of the Node to find
	* @return					the associated Node
	*/
	public static Node findNode(Node root, int val) {
		if (root == null) {
			return null;
		}	else if (root.val == val) {
			return root;
		} else if (val > root.val) {
			return findNode(root.right, val);
		} else {
			return findNode(root.left, val);
		}
	}

	public static Node buildTree(Node parent, int[] tree, int i) {
		if (tree.length == 0 || i >= tree.length)
			return null;
		Node root = new Node(parent, tree[i]);
		root.left = buildTree(root, tree, 2*i + 1);
		root.right = buildTree(root, tree, 2*i + 2);
		return root;
	}

	public static void printLevels(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (q.size() != 0) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				Node cur = q.remove();
				System.out.print(cur.val + " ");
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
			System.out.println();
		}
	}
}