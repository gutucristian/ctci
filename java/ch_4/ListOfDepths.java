import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

class ListOfDepths {
  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.right = null;
      this.left = null;
    }
  }

  // recursively creates a minimal binary search tree from a sorted array
  // and returns the root
  public static TreeNode createMinimalBST(int[] array, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(array[mid]);
    node.left = createMinimalBST(array, start, mid - 1);
    node.right = createMinimalBST(array, mid + 1, end);
    return node;
  }

  // returns a list of lists where each list contains
  // the nodes at each level in the tree. we use level
  // order traversal via breadth first search
  public static List<ArrayList<TreeNode>> listOfDepths(TreeNode root) {
    List<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    TreeNode cur;
    while (q.peek() != null) {
      int count = q.size();
      ArrayList<TreeNode> level = new ArrayList<TreeNode>(count);
      for (int i = 0; i < count; i++) {
        cur = q.poll();
        level.add(cur);
        if (cur.left != null) q.add(cur.left);
        if (cur.right != null) q.add(cur.right);
      }
      result.add(level);
    }
    return result;
  }

  public static void printListOfDepths(List<ArrayList<TreeNode>> listOfDepths) {
    for (ArrayList<TreeNode> list: listOfDepths) {
      for (TreeNode node: list) {
        System.out.print(node.val + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 3, 4, 5, 7, 8 , 11};
    TreeNode root = createMinimalBST(array, 0, array.length - 1);
    List<ArrayList<TreeNode>> listOfDepths = listOfDepths(root);
    printListOfDepths(listOfDepths);
  }
}