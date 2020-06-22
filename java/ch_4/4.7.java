package foo;

import java.util.*;

class Main {
  public static void main(String[] args) {
    String[] projects = { "a", "b", "c", "d", "e", "f" };
    String[][] dependencies = {{"a", "d"}, {"b", "d"}, {"c", "d"}, {"f", "b"}, {"a", "f"}};
    Graph g = new Graph(projects, dependencies);
    System.out.println(g.toString());
  }
}

class Graph {
  private HashMap<String, Node> nodes = new HashMap<>();
  
  public Graph(String[] projects, String[][] dependencies) {
    for (String project: projects) {
      nodes.put(project, new Node(project));
    }
    for (String[] pair: dependencies) {
      Node provider = nodes.get(pair[0]); // provider is used by dependent
      Node dependent = nodes.get(pair[1]); // dependent relies on provider
      provider.addDependency(dependent);
      dependent.addProvider(provider);
    }
  }
}

class Node {
  public final String name;
  public Map<String, Node> providers; // "programming to an interface"
  public Map<String, Node> dependents;

  Node (String name) {
    this.name = name;
    providers = new HashMap<>();
    dependents = new HashMap<>();
  }

  public void addDependency(Node dependent) {
    dependents.put(dependent.name, dependent);
  }

  public void addProvider(Node provider) {
    providers.put(provider.name, provider);
  }
}