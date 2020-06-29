import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

class ValidateBST {
  private static class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    // int[] arr = {17, 10, 28, 5, 13, 24, 35, 3, 7, 12, 15, 21, 27, 30, 38}; // valid BST
    int[] arr = {17, 10, 28, 5, 13, 24, 35, 3, 7, 12, 15, 27, 27, 30, 38}; // invalid BST
    TreeNode root = buildTree(arr, 0);
		printTree(root);
		// System.out.println(getTreeAsList(root, new ArrayList<Integer>()));
		System.out.println(isBST(root));
		System.out.println(isBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }

  /*
    Constructs binary tree based on given array. If root is at index i then
    left child is at index (2*i + 1) and right child is at index (2*i + 2).
  */
  public static TreeNode buildTree(int[] array, int i) {
    if (i < 0 || i >= array.length) return null;
    TreeNode node = new TreeNode(array[i]);
    node.left = buildTree(array, 2*i + 1);
    node.right = buildTree(array, 2*i + 2);
    return node;
  }

	public static void printTree(TreeNode root) {
		Queue<TreeNode> level = new LinkedList<TreeNode>();
		level.add(root);
		while(level.peek() != null) {
			int size = level.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = level.poll();
				System.out.print(cur.val + " ");
				level.add(cur.left);
				level.add(cur.right);
			}
			System.out.println();
		}
	}

	public static List<Integer> getTreeAsList(TreeNode root, List<Integer> tree) {
		if (root == null) return tree;
		getTreeAsList(root.left, tree);
		tree.add(root.val);
		getTreeAsList(root.right, tree);
		return tree;
	}

	public static boolean isSorted(List<Integer> list) {
		for (int i = 1; i < list.size(); i++)
			if (list.get(i) < list.get(i-1)) return false;
		return true;
	}

	public static boolean isBST(TreeNode root) {
		List<Integer> treeAsList = getTreeAsList(root, new ArrayList<Integer>());
		return isSorted(treeAsList);
	}

	public static boolean isBSTRecur(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val < min || root.val > max)
			return false;
		return isBSTRecur(root.left, min, root.val) && isBSTRecur(root.right, root.val, max);
	}
}
