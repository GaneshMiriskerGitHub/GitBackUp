package packagee14_BinaryTrees;


public class A1_Uni_Valued_or_not {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// Question : write a program to check whether all the nodes of a given binary
	// tree are same or not
	public static boolean univalueOrNot(Node root, int n) {
		if (root == null) {
			return true;
		}

		if (root.data != n) {
			return false;
		}

		boolean leftSubTree = univalueOrNot(root.left, n);
		boolean rightSubTree = univalueOrNot(root.right, n);

		return leftSubTree && rightSubTree;
	}

	public static void main(String[] args) {

		// Create a binary tree
		Node root = new Node(1);
		root.left = new Node(1);
		root.right = new Node(1);
		root.left.left = new Node(1);
		root.left.right = new Node(1);
		root.right.right = new Node(1);

		int valueToCheck = 1;

		// Check if all nodes have the same value
		boolean isUniValued = univalueOrNot(root, valueToCheck);

		System.out.println(isUniValued);

	}

}
