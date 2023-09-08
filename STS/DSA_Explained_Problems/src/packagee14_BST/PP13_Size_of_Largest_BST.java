package packagee14_BST;

public class PP13_Size_of_Largest_BST {
	
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
	
	static class Info {
		boolean isBST;
		int size;
		int min;
		int max;
		
		public Info(boolean isBST, int size, int min, int max) {
			this.isBST = isBST;
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}
	
	public static int maxBST = 0;
	
	public static Info maximumBSTSize(Node root) {
		
		if(root == null) {
			return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		
		Info leftTree = maximumBSTSize(root.left);
		Info rightTree = maximumBSTSize(root.right);
		
		int size = leftTree.size + rightTree.size + 1;
		int max = Math.max(root.data, Math.max(leftTree.max, rightTree.max));
		int min = Math.min(root.data, Math.min(leftTree.min, rightTree.min));
		
		if(root.data <= leftTree.max || root.data >= rightTree.min) {
			return new Info(false, size, min, max);
		}
		
		if(leftTree.isBST && rightTree.isBST) {
			maxBST = Math.max(maxBST, size);
			return new Info(true, size, min, max);
		}
		
		return new Info(false, size, min, max);
		
	}

	public static void main(String[] args) {
		
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		
		root.right = new Node(60);
		root.right.left = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);
		
		Info finalInfo = maximumBSTSize(root);
		System.out.println(maxBST);
		

	}

}
