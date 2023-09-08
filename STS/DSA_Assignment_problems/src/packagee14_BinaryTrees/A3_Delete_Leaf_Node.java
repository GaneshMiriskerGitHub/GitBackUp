package packagee14_BinaryTrees;


public class A3_Delete_Leaf_Node { // delete all the leaf nodes for a given value

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
	
	public static void deleteLeafNode(Node root, int n) {
		if(root == null) {
			return;
		}
		if(root.left == null) {
			return;
		}
		if(root.right == null) {
			return;
		}
		if(root.left.data == n && (root.left.left == null && root.left.right == null)) {
			root.left = null;
			return;
		}
		if(root.right.data == n && (root.right.right == null && root.right.left == null)) {
			root.right = null;
		}
		
		deleteLeafNode(root.left, n);
		deleteLeafNode(root.right, n);
	}
	
	// same problem with different implementation , Node as return value instead of void
	public static Node deleteLeafNodeForGivenN(Node root, int n) {
		
		if(root == null) {
			return null;
		}
		
		
		root.left = deleteLeafNodeForGivenN(root.left, n);
		root.right = deleteLeafNodeForGivenN(root.right, n);
		
		if(root.data == n && root.left == null && root.right == null) {
			return null;
		}
		
		return root;
	}

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        printAllNodes(root);System.out.println();
//        deleteLeafNode(root, 4);  // to delete a value which is at leaf node
//        printAllNodes(root);
        
        Node deletedNode = deleteLeafNodeForGivenN(root, 4);
        printAllNodes(deletedNode);
		
	}

}
