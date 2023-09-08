package packagee14_BST;

import java.util.ArrayList;

/*
 * Given a tree,
 * Do inOrder traversal and store in a ArrayList (you will get a sorted list),
 * Now buildBalancedBST function
 */
public class PP12_Covert_to_Balanced_BST { 
	
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
	
	public static void inOrder(Node root, ArrayList<Integer> list) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
	}
	
	public static Node buildBalancedBST(ArrayList<Integer> list, int s, int e) {
		if(s>e) {
			return null;
		}
		int m = (s+e)/2;
		
		Node newNode = new Node(list.get(m));
		newNode.left = buildBalancedBST(list, s, m-1);
		newNode.right = buildBalancedBST(list, m+1, e);
		
		return newNode;
		
	}
	
	public static void printTree(Node root) {
		if(root == null ) {
			return;
		}
		
		printTree(root.left);
		System.out.print(root.data+ " ");
		printTree(root.right);

	}

	public static void main(String[] args) {
		
		Node root = new Node(8);
		root.left = new Node(6);
		root.left.left = new Node(5);
		root.left.left.left = new Node(3);
		
		root.right = new Node(10);
		root.right.right = new Node(11);
		root.right.right = new Node(12);
		
		ArrayList<Integer> list = new ArrayList<>();
		inOrder(root, list);
		
		Node finalNode = buildBalancedBST(list, 0, list.size()-1);

		printTree(finalNode);
	}

}
