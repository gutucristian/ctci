import java.util.*;

public class BuildOrderDFS {
  public static void main(String[] args) {
    String[] projects = { "a", "b", "c", "d", "e", "f", "g" };
    String[][] dependencies = { {"f", "b"}, {"f", "a"}, {"f", "c"}, {"a", "e"}, {"b", "e"}, {"d" ,"g"} };
    Stack<Project> order = findBuildOrder(projects, dependencies);
    // for (Project project: order) {
    //   System.out.print(project.getName() + " ");
    // }
    int len = order.size();
    for (int i = 0; i < len; i++) {
      System.out.print(order.pop().getName() + " ");
    }
  }

  static Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.getNodes());
  }

  static Stack<Project> orderProjects(ArrayList<Project> projects) {
    Stack<Project> stack = new Stack<Project>();
    for (Project project: projects) {
      if (project.getState() == Project.State.BLANK) {
        if (!doDFS(project, stack)) {
          return null;
        }
      }
    }
    return stack;
  }

  static boolean doDFS(Project project, Stack<Project> stack) {
    if (project.getState() == Project.State.PARTIAL) {
      return false; // cycle
    }

    if (project.getState() == Project.State.BLANK) {
      project.setState(Project.State.PARTIAL);
      ArrayList<Project> children = project.getChildren();
      for (Project child: children) {
        if (!doDFS(child, stack)) {
          return false;
        }
      }
      project.setState(Project.State.COMPLETE);
      stack.push(project);
    }

    return true;
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
    public enum State {COMPLETE, PARTIAL, BLANK};
    private State state = State.BLANK;

    Project(String n) { name = n; }

    void addNeighbor(Project node) {
      if (!map.containsKey(node.getName())) {
        children.add(node);
        map.put(node.getName(), node);
      }
    }

    public State getState() { return state; }
    public void setState(State st) { state = st; }

    String getName() { return name; }
    ArrayList<Project> getChildren() { return children; }
  }
}