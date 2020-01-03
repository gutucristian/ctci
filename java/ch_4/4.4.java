class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(13);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(14);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(11);
        TreeNode f = new TreeNode(10);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;

        System.out.println("Tree is balanced: " + isBalanced(a));
        // System.out.println("Tree is balanced: " + isBalancedTwo(a));
    }

    static int getHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        System.out.println("At node with value " + root.val);
        int left = getHeight(root.left);
        System.out.println("Left subtree height: " + left);
        int right = getHeight(root.right);
        System.out.println("Right subtree height: " + right);
        if (Math.abs(left-right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    static int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // propagate error up

        System.out.println("At node with value " + root.val + ". Left subtree height: " + leftHeight);

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // propagate error up

        System.out.println("At node with value " + root.val + ". Right subtree height: " + rightHeight);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static boolean isBalancedTwo(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}