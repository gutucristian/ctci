// Alternative solution to build order problem (i.e., topological sort)
import java.util.HashMap;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    String[] projects = { "a", "b", "c", "d", "e", "f" };
    String[][] dependencies = { {"d", "g"}, {"f", "c"}, {"f", "b"}, {"f", "a"}, {"a", "e"}, {"b", "e"} };
    Project[] order = findBuildOrder(projects, dependencies);
    for (Project project: order) {
      System.out.print(project.getName() + " ");
    }
  }

  static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.getNodes());
  }

  static Graph buildGraph(String[] projects, String[][] dependencies) {
    Graph graph = new Graph();
    for (String project: projects) {
      graph.getOrCreateNode(project);
    }

    for (String[] dependency: dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }

    return graph;
  }

  static Project[] orderProjects(ArrayList<Project> projects) {
    Project[] order = new Project[projects.size()];
    int endOfList = addNonDependent(order, projects, 0);
    int toBeProcessed = 0;
    while (toBeProcessed < order.length) {
      // next project to be processed from build "order" array
      Project current = order[toBeProcessed];

      // if next node to be processed is null (i.e., there is none)
      // and we haven't processed all nodes then there is a circular dependency
      // so we terminate
      if (current == null) return null;

      // get children of current
      ArrayList<Project> children = current.getChildren();
      // for each child node, decrease dependency count by one
      for (Project child: children) {
        child.decrementDependencies();
      }

      // inspect children of processed node (i.e., "current") and add all children
      // with 0 dependencies to build "order" array for subsequent processing
      endOfList = addNonDependent(order, children, endOfList);

      ++toBeProcessed;
    }
    return order;
  }

  /*
    Copies "projects" to "order" array starting at "offset".
  */
  static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
    for (Project project: projects) {
      if (project.getNumberDependencies() == 0) {
        order[offset] = project;
        ++offset;
      }
    }
    return offset;
  }

  private static class Graph {
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<>();

    Project getOrCreateNode(String name) {
      if (!map.containsKey(name)) {
        Project node = new Project(name);
        nodes.add(node);
        map.put(name, node);
      }
      return map.get(name);
    }

    public void addEdge(String startName, String endName) {
      Project start = getOrCreateNode(startName);
      Project end = getOrCreateNode(endName);
      start.addNeighbor(end);
    }
    public ArrayList<Project> getNodes() { return nodes; }
  }

  private static class Project {
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    Project(String n) { name = n; }

    void addNeighbor(Project node) {
      if (!map.containsKey(node.getName())) {
        children.add(node);
        map.put(node.getName(), node);
        node.incrementDependencies();
      }
    }

    void incrementDependencies() { ++dependencies; }
    void decrementDependencies() { --dependencies; }

    String getName() { return name; }
    ArrayList<Project> getChildren() { return children; }
    int getNumberDependencies() { return dependencies; }
  }
}