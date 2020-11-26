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

  public static Node getFirstCommonAncestor(Node p, Node q) {
    if (p == null || q == null) return null;

    System.out.println("p = " + p.value);
    System.out.println("q = " + q.value);

    int pDepth = getDepth(p);
    int qDepth = getDepth(q);

    System.out.println("pDepth = " + pDepth);
    System.out.println("qDepth = " + qDepth);

    int delta = pDepth - qDepth;

    Node first = delta > 0 ? q : p; // get shallower node
    Node second = delta > 0 ? p : q; // get deeper node

    System.out.println("First val: " + first.value);
    System.out.println("Second val: " + second.value);

    second = goUpBy(second, Math.abs(delta));

    while (first != second && first != null && second != null) {
      first = first.parent;
      second = second.parent;
    }

    return first == null || second == null ? null : first;
  }

  private static int getDepth(Node node) {
    System.out.println("get depth for: " + node.value);
    int depth = 0;

    while (node != null) {
      node = node.parent;
      depth++;

      System.out.println("Depth: " + depth + " , now at node: " + node.value);
    }
    return depth;
  }

  private static Node goUpBy(Node node, int delta) {
    while (delta > 0 && node != null) {
      node = node.parent;
      delta--;
    }
    return node;
  }

  public static void printTree(Node root) {
    Queue<Node> level = new LinkedList<Node>();
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
      Generall it is expected that set methods are void. In this case, I return this to be able to chain setters.
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