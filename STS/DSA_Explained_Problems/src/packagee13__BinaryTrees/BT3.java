package packagee13__BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import packagee13__BinaryTrees.BT1.Node;

public class BT3 {

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

	static class BinaryTree {
		Node root;

		// print all elements in kth level : approach 1
		public static void levelOrderTraversal(Node root, int k) {
			if (root == null) {
				return;
			}

			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			int level = 1;
			while (!q.isEmpty()) {
				Node currNode = q.remove();
				if (currNode == null) {
					level++;
					if (!q.isEmpty()) {
						q.add(null);
					} else {
						break;
					}
				} else {
					if (level == k) {
						System.out.print(currNode.data + " ");
					}
					if (currNode.left != null) {
						q.add(currNode.left);
					}
					if (currNode.right != null) {
						q.add(currNode.right);
					}

				}
			}
		}

		// print all elements at level k : approach 2 : using recursion
		public static void printKthLevelElements(Node root, int k, int level) {

			if (root == null) {
				return;
			}

			if (level == k) {
				System.out.print(root.data + " ");
				return;
			}

			printKthLevelElements(root.left, k, level + 1);
			printKthLevelElements(root.right, k, level + 1);

		}

		public static void LowestCommonAncestor(Node root, int data1, int data2) {

			ArrayList<Integer> path1 = new ArrayList<>();
			ArrayList<Integer> path2 = new ArrayList<>();

			getPath(root, data1, path1);
			getPath(root, data2, path2);

			int n = 0;
			if (path1.size() > path2.size()) {
				n = path1.size();
			} else {
				n = path2.size();
			}

			for (int i = 1; i < n; i++) {
				if (path1.get(i) != path2.get(i)) {
					System.out.println();
					System.out.println("lowest common ancestor is : " + path1.get(i - 1));
				}
			}

		}

		public static boolean getPath(Node root, int data, ArrayList<Integer> path) {

			if (root == null) {
				return false;
			}

			path.add(root.data);

			if (root.data == data) {
				return true;
			}

			boolean foundLeft = getPath(root.left, data, path);
			boolean foundRight = getPath(root.right, data, path);

			if (foundLeft || foundRight) {
				return true;
			} else {
				path.remove(path.size() - 1);
				return false;
			}

		}

		// 2nd approach
		public static Node lowestCommonAncestor2(Node root, int n1, int n2) {

			if (root == null) {
				return null;
			}

			if (root.data == n1 || root.data == n2) {
				return root;
			}

			// find in left subtree and right subtree
			Node leftSubTree = lowestCommonAncestor2(root.left, n1, n2);
			Node rightSubTree = lowestCommonAncestor2(root.right, n1, n2);

			if (leftSubTree == null) {
				return rightSubTree;
			}
			if (rightSubTree == null) {
				return leftSubTree;
			}

			return root;
		}

		public static int dist_root_to_n(Node root, int n) {

			if (root == null) {
				return -1;
			}

			if (root.data == n) {
				return 0;
			}

			int valueLeft = dist_root_to_n(root.left, n);
			int valueRight = dist_root_to_n(root.right, n);

			if (valueLeft == -1 && valueRight == -1) {
				return -1;
			}
			if (valueLeft == -1) {
				return valueRight + 1;
			} else {
				return valueLeft + 1;
			}

		}

		public static int minDist(Node root, int n1, int n2) {
			Node lca = lowestCommonAncestor2(root, n1, n2);

			int distn1 = dist_root_to_n(lca, n1);
			int distn2 = dist_root_to_n(lca, n2);

			return distn1 + distn2;
		}

		public static int kthAncestorOfNode(Node root, int n, int k) {

			if (root == null) {
				return -1;
			}

			if (root.data == n) {
				return 0;
			}

			int leftVal = kthAncestorOfNode(root.left, n, k);
			int rightVal = kthAncestorOfNode(root.right, n, k);

			if (leftVal == -1 && rightVal == -1) {
				return -1;
			}

			int max = Math.max(leftVal, rightVal);
			if (max + 1 == k) {
				System.out.println(root.data);
			}

			return max + 1;

		}

		public static void preOrderTraversal(Node root) {

			if (root == null) {
				return;
			}

			System.out.print(root.data + " ");

			preOrderTraversal(root.left);
			preOrderTraversal(root.right);

		}

		public static int sumTree(Node root) {
			
			if(root == null) {
				return 0;
			}
			
			
			int leftRootFinalVal = sumTree(root.left);
			int rightRootFinal = sumTree(root.right);
			
			int currRootData = root.data;
			
			int leftData = 0 , rightData = 0;
			if(root.left != null) {
				leftData += root.left.data;
			}
			if(root.right != null) {
				rightData += root.right.data;
			}
			
			root.data = leftData + rightData + leftRootFinalVal + rightRootFinal;
			
			return  currRootData;
			
		}

	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		BinaryTree tree = new BinaryTree();
		System.out.println("print all elements from kth level using normal loop ");
		BinaryTree.levelOrderTraversal(root, 3);
		System.out.println();
		System.out.println("print all elements from kth level using recursion ");
		BinaryTree.printKthLevelElements(root, 2, 1);
		BinaryTree.LowestCommonAncestor(root, 2, 3);
		System.out.println();
		System.out.println("lca using second approach answer is : " + tree.lowestCommonAncestor2(root, 2, 3).data);
		System.out.println("Minimum distance from n1 and n2 node is : " + tree.minDist(root, 4, 7));
		System.out.print("the kth ancestor of a given node is : ");
		tree.kthAncestorOfNode(root, 4, 1);
		System.out.println();
		BinaryTree.sumTree(root);
		BinaryTree.preOrderTraversal(root);
	}
}
