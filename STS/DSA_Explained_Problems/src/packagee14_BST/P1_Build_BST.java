package packagee14_BST;

import java.util.ArrayList;

public class P1_Build_BST {

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
		if (root == null) {
			root = new Node(value);
			return root;
		}

		if (value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}

		return root;
	}

	public static Node buildBST(int[] arr) {

		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(root, arr[i]);
		}

		return root;
	}

	public static void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static boolean searchInBST(Node root, int key) {
		if(root == null) {
			return false;
		}
		if(root.data == key) {
			return true;
		}
		
		boolean foundLeft = searchInBST(root.left, key);
		boolean foundRight = searchInBST(root.right, key);
		
		return foundLeft || foundRight;
	}
	
	public static Node deleteInBST(Node root, int key) {
		if(key < root.data) {
			root.left = deleteInBST(root.left, key);
		}else if(key > root.data) {
			root.right = deleteInBST(root.right, key);
		}else {
			// case 1 : leaf node
			if(root.left == null && root.right == null) {
				return null;
			}
			// case 2 : single child
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			// case 2 : two nodes
			Node IS = findMinInRightSubTree(root.right); // In Order Successor
			root.data = IS.data;
			root.right = deleteInBST(root.right, IS.data);
			
		}
		
		return root;
	}
		
		public static Node findMinInRightSubTree(Node root) {
			if(root.left == null) {
				return root;
			}
			return findMinInRightSubTree(root.left);
		
	}
		
	public static void printInRange(Node root, int k1, int k2) {
		if(root == null) {
			return;
		}
		if(k1 <= root.data && k2 >= root.data) {
			printInRange(root.left, k1, k2);
			System.out.print(root.data+ " ");
			printInRange(root.right, k1, k2);
		}else if(k1 <= root.data) {
			printInRange(root.left, k1, k2);
		}else if(k2 >= root.data) {
			printInRange(root.right, k1, k2);
		}
	}
	
	public static void allRootToLeafPaths(Node root, ArrayList<Integer> list) {
		
		if(root == null) return;
	
		if(root.left == null && root.right == null) {
			list.add(root.data);
			System.out.println(list);
			return;
		}
		
		list.add(root.data);
		
		allRootToLeafPaths(root.left, list);
		allRootToLeafPaths(root.right, list);
		
		list.remove(list.size()-1);
	}
	
	// Approach 1 : take inOrder and if  find sorted then valid , if not sorted then invalid
	// Approach 2 : 
	public static boolean validBST(Node root, Node min, Node max) {
		if(root == null) {
			return true;
		}
		
		if(min != null && root.data <= min.data) return false;
		if(max != null && root.data >= max.data) return false;
		
		boolean validLeft = validBST(root.left, min, root);
		boolean validRight = validBST(root.right, root, max);
		
		return validLeft && validRight;
	}
	
	// when return type is not expected
	public static void mirror(Node root) {
		if(root == null) {
			return;
		}
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirror(root.left);
		mirror(root.right);
	}
	
	//when return type is expected
	public static Node mirror2(Node root) {
		if(root == null) {
			return null;
		}
		
		Node left = mirror2(root.left);
		Node right = mirror2(root.right);
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		return root;
	}
	
	public static Node buildBSTFromSortedArray(int[] arr, int s, int e) {
		if(s>e) {
			return null;
		}
		int m = (s+e)/2;
		Node newNode = new Node(arr[m]);
		newNode.left = buildBSTFromSortedArray(arr, s, m-1);
		newNode.right = buildBSTFromSortedArray(arr, m+1, e);
		
		return newNode;
	}

	public static void main(String[] args) {

		int[] arr = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

		Node root = buildBST(arr);

//		inOrder(root);System.out.println();
		
//		System.out.println(searchInBST(root, 0));
		
//		root = deleteInBST(root, 1);
//		inOrder(root);System.out.println();

//		printInRange(root, 1, 14);System.out.println();
		
//		allRootToLeafPaths(root, new ArrayList<>());
//		System.out.println(validBST(root, null, null));
		
//		mirror(root);System.out.println();
//		inOrder(root);
		
		int[] arr2 = {3, 5, 6, 8, 10, 11, 12};
		
		// build a BST from the above sorted array
		Node createdBST = buildBSTFromSortedArray(arr2, 0, arr2.length-1);
		inOrder(createdBST);
	}

}
