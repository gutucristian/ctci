package com.gutucristian.Chapter4;

import java.util.LinkedList;
import java.util.Queue;

/*
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary
 * search tree.
 *
 * Tree:
 *             20
 *            /  \
 *           10   30
 *          /  \
 *         5    15
 *        / \     \
 *       3   7     17
 */

class FirstCommonAncestor {
  static int count = 0;

  public static void main(String[] args) {
    Node a = new Node(20);
    Node b = (new Node(10)).setParent(a);
    Node c = (new Node(30)).setParent(a);
    Node d = (new Node(5)).setParent(b);
    Node e = (new Node(15)).setParent(b);
    Node f = (new Node(17)).setParent(e);
    Node g = (new Node(3)).setParent(d);
    Node h = (new Node(7)).setParent(d);

    a.left = b;
    a.right = c;

    b.left = d;
    b.right = e;

    e.right = f;

    d.left = g;
    d.right = h;

    printTree(a);
    System.out.println(getFirstCommonAncestor(f, d).value);
  }

  // Approach 1 (with links to parent):
  //  - Get depth of p and q
  //  - Adjust so both nodes are at same level in tree
  //  - Move up until both reach the first common ancestor
  // Approach 2 (with links to parents):
  //  - For p and q, check if the left or right subtree covers the other node, if so return the covering node
  //    (this would be the first common ancestor)
  //  - Pick a node (p or q) and begin to "explore" tree
  //  - Assume we pick p
  //  - Given p, we want to move up one level (to p's parent node)
  //  - Let's say p was the left child of it's parent node, in this case the right child of p's parent is p's "sibling"
  //  - Explore the subtree of p's sibling to find q. If we find q, then return the parent as the first common ancestor
  //    else we repeat by setting parent to the next node up and getting the next sibling to explore

  public static Node getFirstCommonAncestor(Node p, Node q) {
    if (p == null || q == null) return null;

    if (covers(p, q)) {
      // to show that worst case scenario searches entire tree if p = 20 and q = 30
      System.out.println("count = " + count);
      return p;
    } else if (covers(q, p)){
      return q;
    }

    Node sibling = getSibling(p);
    Node parent = p.parent;

    while(!covers(sibling, q)) {
      sibling = getSibling(parent);
      parent = parent.parent;
    }

    return parent;
  }

  public static boolean covers(Node p, Node q) {
    count++;
    if (p == null || q == null) return false;
    if (p == q) return true;
    return covers(p.left, q) || covers(p.right, q);
  }

  public static Node getSibling(Node node) {
    if (node == null) return null;

    Node parent = node.parent;

    if (parent == null) return null;

    return parent.left == node ? parent.right : parent.left;
  }

//  public static Node getFirstCommonAncestor(Node p, Node q) {
//    if (p == null || q == null) return null;
//
//    System.out.println("p = " + p.value);
//    System.out.println("q = " + q.value);
//
//    int pDepth = getDepth(p);
//    int qDepth = getDepth(q);
//
//    System.out.println("pDepth = " + pDepth);
//    System.out.println("qDepth = " + qDepth);
//
//    int delta = pDepth - qDepth;
//
//    Node first = delta > 0 ? q : p; // get shallower node
//    Node second = delta > 0 ? p : q; // get deeper node
//
//    System.out.println("First val: " + first.value);
//    System.out.println("Second val: " + second.value);
//
//    second = goUpBy(second, Math.abs(delta));
//
//    while (first != second && first != null && second != null) {
//      first = first.parent;
//      second = second.parent;
//    }
//
//    return first == null || second == null ? null : first;
//  }

//  private static int getDepth(Node node) {
//    System.out.println("get depth for: " + node.value);
//    int depth = 0;
//
//    while (node != null) {
//      System.out.println("Depth: " + depth + " , now at node: " + node.value);
//      node = node.parent;
//      depth++;
//    }
//    return depth;
//  }

//  private static Node goUpBy(Node node, int delta) {
//    while (delta > 0 && node != null) {
//      node = node.parent;
//      delta--;
//    }
//    return node;
//  }

  public static void printTree(Node root) {
    Queue<Node> level = new LinkedList<>();
    level.add(root);
    while(level.peek() != null) {
      int size = level.size();
      for (int i = 0; i < size; i++) {
        Node cur = level.poll();
        assert cur != null;
        System.out.print(cur.value + " ");
        if (cur.left != null) level.add(cur.left);
        if (cur.right != null) level.add(cur.right);
      }
      System.out.println();
    }
  }

  static class Node {
    Node parent;
    Node left;
    Node right;
    int value;

    Node(int value) {
      this.value = value;
    }

    /*
      Generally its expected that "set" methods are void. In this case, I return "this" to be able to chain setters.
      Many recommend to use the "builder" pattern for this instead. Resources:
        - https://stackoverflow.com/questions/1345001/is-it-bad-practice-to-make-a-setter-return-this
        - https://www.vogella.com/tutorials/DesignPatternBuilder/article.html
     */
    public Node setParent(Node parent) {
      this.parent = parent;
      return this;
    }
  }
}