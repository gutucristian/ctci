import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Node {
  private String name;
  private List<Node> children;
  boolean visited;

  Node(String name) {
    this.name = name;
    this.visited = false;
    this.children = new ArrayList<Node>();
  }

  boolean addChild(Node child) {
    return this.children.add(child);
  }

  void addChildren(Node... children) {
    this.children.addAll(Arrays.asList(children));
  }

  List<Node> getChildren() {
    return this.children;
  }

  public String toString() {
    return this.name;
  }
}

class Graph {
  private List<Node> nodes;

  public Graph() {
    this.nodes = new ArrayList<Node>();
  }

  public boolean search(Node start, Node end) {
    if (start == end) return true;
    LinkedList<Node> q = new LinkedList<Node>();
    for (Node node : this.nodes) {
      node.visited = false;
    }
    start.visited = true;
    q.add(start);
    Node u;
    while (!q.isEmpty()) {
      System.out.println("q = " + Arrays.toString(q.toArray()));
      u = q.removeFirst();
      for (Node node : u.getChildren()) {
        if (!node.visited) {
          if (node == end) {
            return true;
          } else {
            node.visited = true;
            q.add(node);
          }
        }
      }
    }
    return false;
  }

  public void addNodes(Node... nodes) {
    this.nodes.addAll(Arrays.asList(nodes));
  }
}

class Main {
  public static void main(String[] args) {
    Graph g = new Graph();
    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    Node E = new Node("E");
    Node F = new Node("F");
    A.addChildren(B, C);
    B.addChildren(A, C, D);
    C.addChildren(A, B, D);
    D.addChildren(C, B, E);
    E.addChildren(E);
    g.addNodes(A, B, C, D, E);
    System.out.println("Start...");
    System.out.printf("Exists path from %c to %c: %b\n", 'A', 'E', g.search(A, E));
    System.out.println("Done.");
  }
}