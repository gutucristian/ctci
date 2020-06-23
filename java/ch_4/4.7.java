import java.util.*;

class Main {
  public static void main(String[] args) {
    String[] projects = { "a", "b", "c", "d", "e", "f" };
    /*
      In the pairs, the second project depends on the first.
      I.e., index 0 is provider and index 1 is dependency.
    */
    String[][] dependencies = { {"a", "d"}, {"b", "d"}, {"c", "d"}, {"f", "b"}, {"a", "f"} };
    Graph dependencyGraph = new Graph(projects, dependencies);
    System.out.println(dependencyGraph.map.size());
    ArrayList<Node> buildOrder = getBuildOrder(dependencyGraph);

    for (Node project: buildOrder) {
      System.out.print(project.name + " ");
    }
  }

  public static ArrayList<Node> getBuildOrder(Graph dependencyGraph) {
    ArrayList<Node> buildOrder = new ArrayList<>(dependencyGraph.map.size());
    ArrayList<Node> toBeProcessed = new ArrayList<>();

    do {
      for (Node project: toBeProcessed) {
        // remove project from dependency graph and remove it as a dependency in projects where it is a provider
        dependencyGraph.removeNode(project);
        // add projects to be processed next to build order
        buildOrder.add(project);
      }

      toBeProcessed.clear();

      System.out.println("[INFO] begin inspecting dependency graph...");

      // identify all projects with 0 providers and add to processing
      for (Node project: dependencyGraph.map.values()) {
        System.out.println("checking node \"" + project.name + "\" (requires " + project.providers.size() + " providers)");
        if (project.providers.size() == 0) {
          System.out.println("\tadd node \"" + project.name + "\" to be processed");
          toBeProcessed.add(project);
        }
      }

      System.out.println("[INFO] finished inspecting dependency graph!");

      if (toBeProcessed.size() > 0) System.out.print("[INFO] nodes to be processed: ");

      for (Node project: toBeProcessed) {
        System.out.print(project.name + " ");
      }
      System.out.println();
    } while (toBeProcessed.size() > 0);

    return buildOrder;
  }
}

class Graph {
  public HashMap<String, Node> map = new HashMap<>(); // for O(1) put / get

  public Graph(String[] projects, String[][] dependencies) {
    for (String name: projects) {
      Node project = new Node(name);
      map.put(name, project);
    }
    for (String[] pair: dependencies) {
      Node provider = map.get(pair[0]); // provider is used by dependent
      Node dependent = map.get(pair[1]); // dependent relies on provider
      provider.addDependency(dependent);
      dependent.addProvider(provider);
    }
  }

  public void removeNode(Node project) {
    if (map.containsKey(project.name)) {
      // remove node from graph
      map.remove(project.name);

      // remove node as a provider from its dependencies (its been built, so its no longer a dependency)
      for (Node dependent: project.dependents.values()) {
        dependent.removeProvider(project);
      }
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

  public void removeProvider(Node provider) {
    providers.remove(provider.name);
  }
}