package com.gutucristian.Misc;

class Node {
  public int val;
  public Node next;
  Node(int val) {
    this.val = val;
    this.next = null;
  }
}

class LinkedList {
  private Node first;
  public void addToBeginningOfList(Node node) {
    node.next = this.first;
    this.first = node;
  }
  public String toString() {
    StringBuilder list = new StringBuilder();
    Node cur = this.first;
    while (cur != null) {
      list.append(cur.val).append(" ");
      cur = cur.next;
    }
    return list.toString();
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addToBeginningOfList(new Node(7));
    ll.addToBeginningOfList(new Node(9));
    ll.addToBeginningOfList(new Node(2));
    ll.addToBeginningOfList(new Node(8));
    System.out.println(ll);
    System.out.println("apple".compareTo("banana"));
    //int a = 123451234512345;
    //System.out.println(a);
//    int array[] = {1, 2, 3, 4};
//    for (int i = 0; i < array.size(); i++) {
//      System.out.print(array[i]);
//    }
    for (int i=0; i<10; i+=1) {
      System.out.println("Hello World");
    }
    print();
  }

  static void print() {
    try {
      System.out.print("Hello");
    } finally {
      System.out.println("!");
    }
  }
}
