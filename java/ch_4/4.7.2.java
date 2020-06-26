public class Main {
  public static void main(String[] args) {

  }

  Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.getNodes());
  }

  Stack<Project> orderProjects(ArrayList<Project> projects) {
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

  boolean doDFS(Project project, Stack<Project> stack) {
    if (project.getState() == Projet.State.PARTIAL) {
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
        node.incrementDependencies();
      }
    }

    void incrementDependencies() { ++dependencies; }
    void decrementDependencies() { --dependencies; }

    public State getState() { return state; }
    public void setState(State st) { state = st; }

    String getName() { return name; }
    ArrayList<Project> getChildren() { return children; }
    int getNumberDependencies() { return dependencies; }
  }
}