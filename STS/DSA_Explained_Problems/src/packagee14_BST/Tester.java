package packagee14_BST;

public class Tester {
	
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
	
	public static Node insert(Node root, int value) {
		if(root == null) {
			root = new Node(value);
			return root;
		}
		
		if(value < root.data) {
			root.left = insert(root.left, value);
		}else {
			root.right = insert(root.right, value);
		}
		
		return root;
	}
	
	
	public static Node buildBST(int[] arr) {
		
		Node root = null ;
		for(int i=0;i<arr.length;i++) {
			root = insert(root, arr[i]);
		}
		
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		
		
		
	}

}
