package packagee14_BinaryTrees;

import java.util.HashMap;

public class A4_Find_All_Duplicate_Subtrees {

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

	public static void printAllNodes(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		printAllNodes(root.left);
		printAllNodes(root.right);

	}

	static HashMap<String, Integer> m;

	public static String inOrder(Node root) {

		if (root == null) {
			return "";
		}

		String str = "(";

		str = str + inOrder(root.left);
		str = str + Integer.toString(root.data);
		str = str + inOrder(root.right);

		str += ")";

		if (m.containsKey(str) && m.get(str) == 1) {
			System.out.print(root.data + " ");
		}

		if (!m.containsKey(str)) {
			m.put(str, 1);
		} else {
			m.put(str, m.get(str) + 1);
		}

		return str;
	}

	public static void printAllDuplicatesInTree(Node root) {
		m = new HashMap<>();
		inOrder(root);
	}

	public static void main(String[] args) {

		Node root = null;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(2);
		root.right.left.left = new Node(4);
		root.right.right = new Node(4);
		printAllDuplicatesInTree(root);

	}

}
