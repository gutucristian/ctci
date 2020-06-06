import java.util.Queue;
import java.util.LinkedList;

class Node {
	Node left;
	Node right;
	int val;
	Node(int val) {
		this.val = val;
	}
}

class Main {
	public static void main(String[] args) {
		int[] tree = {12, 9, 15, 4, 11, 13, 22};
		Node root = buildTree(tree, 0);
		printLevels(root);
	}

	public static Node inorderSuccessor(Node node) {
		// TODO
	}

	/**
	* Find Node in BST with given value.
	* 
	* @param		val		the value of the Node to find
	* @return					the associated Node	
	*/
	public static void findNode(int val) {
		// TODO
	}

	public static Node buildTree(int[] tree, int i) {
		if (tree.length == 0 || i >= tree.length)
			return null;
		Node root = new Node(tree[i]);
		root.left = buildTree(tree, 2*i + 1);
		root.right = buildTree(tree, 2*i + 2);
		return root;
	}

	public static void printLevels(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (q.size() != 0) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				Node cur = q.remove();
				System.out.print(cur.val + " ");
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
			System.out.println();
		}
	}
}
