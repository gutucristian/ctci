class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int val;

  TreeNode(int val) {
    this.val = val;
  }
}

class Main {
  public static void main(String[] args) {
    int[] arr = {17, 10, 28, 5, 13, 24, 35, 3, 7, 21, 15, 21, 27, 30, 38};
    // TreeNode root = buildTree(arr, i);
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
}