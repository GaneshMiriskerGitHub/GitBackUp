package packagee13__BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import packagee13__BinaryTrees.BT1.Node;

public class BT2 {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static class BinaryTree {
		Node root;

		public int height(Node root) {
			if (root == null) {
				return 0;
			}

			int leftHeight = height(root.left);
			int rightHeight = height(root.right);

			return Math.max(leftHeight, rightHeight) + 1;
		}

		public int diameter(Node root) {
			if (root == null) {
				return 0;
			}

			int leftHeight = height(root.left);
			int rightHeight = height(root.right);

			int leftDiameter = diameter(root.left);
			int rightDiameter = diameter(root.right);

			int selfDiameter = leftHeight + rightHeight + 1;

			return Math.max(Math.max(leftDiameter, rightDiameter), selfDiameter);
		}

//		static class Info {
//			int diameter;
//			int height;
//
//			public Info(int diameter, int height) {
//				this.diameter = diameter;
//				this.height = height;
//			}
//
//		}
//
//		public static Info diamaterAppraoch2(Node root) {
//
//			if (root == null) {
//				return new Info(0, 0);
//			}
//
//			Info leftInfo = diamaterAppraoch2(root.left);
//			Info rightInfo = diamaterAppraoch2(root.right);
//			int selfDiamter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
//					leftInfo.height + rightInfo.height + 1);
//			int selfHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
//			Info selfInfo = (new Info(selfDiamter, selfHeight));
//
//			return selfInfo;
//
//		}
//
//		public static boolean isIdentical(Node root1, Node subRoot) {
//			if (root1 == null && subRoot == null) {
//				return true;
//			} else if (root1 == null || subRoot == null || root1.data != subRoot.data) {
//				return false;
//			}
//
//			if (!isIdentical(root1.left, subRoot.left)) {
//				return false;
//			}
//			if (!isIdentical(root1.right, subRoot.right)) {
//				return false;
//			}
//
//			return true;
//		}
//
//		public static boolean isSubTree(Node root1, Node subRoot) {
//
//			if (root1 == null || subRoot == null) {
//				return false;
//			}
//
//			if (root1.data == subRoot.data) {
//				if (isIdentical(root1, subRoot)) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//
//			boolean leftSubTreeLo = isSubTree(root1.left, subRoot);
//			boolean rightSubTreeLo = isSubTree(root1.right, subRoot);
//
//			return leftSubTreeLo || rightSubTreeLo;
//
//		}

		static class Info {
			Node node;
			int hd;

			public Info(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}

		public static void topView(Node root) {
			Queue<Info> q = new LinkedList<>();

			Map<Integer, Node> map = new HashMap<>();

			int min = 0;
			int max = 0;

			q.add(new Info(root, 0));
			q.add(null);

			while (!q.isEmpty()) {
				Info curr = q.remove();

				if (curr == null) {
					if (q.isEmpty()) {
						break;
					} else {
						System.out.println();
						q.add(null);
					}
				} else {
					if (!map.containsKey(curr.hd)) {
						map.put(curr.hd, curr.node);
					}

					if (curr.node.left != null) {
						q.add(new Info(curr.node.left, curr.hd - 1));
						min = Math.min(min, curr.hd - 1);
					}
					if (curr.node.right != null) {
						q.add(new Info(curr.node.right, curr.hd + 1));
						max = Math.max(max, curr.hd + 1);
					}
				}

			}

			for (int i = min; i <= max; i++) {
				System.out.print(map.get(i).data+ " ");
			}
		}
		
		// print all elements in kth level : approach 1
		public static void levelOrderTraversal(Node root, int k) {
			if(root == null) {
				return;
			}
			
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			int level = 1;
			while(!q.isEmpty()) {
				Node currNode = q.remove();
				if(currNode == null) {
					level++;
					if(!q.isEmpty()) {
						q.add(null);
					}else {
						break;
					}
				}else {
					if(level == k) {
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
			
			if(root == null) {
				return;
			}
			
			if(level == k) {
				System.out.print(root.data+" ");
				return;
			}
			
			printKthLevelElements(root.left, k, level+1);
			printKthLevelElements(root.right, k, level+1);
			
		}
		
		

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1, null, null);
		tree.root.left = new Node(2, null, null);
		tree.root.right = new Node(3, null, null);
		tree.root.left.left = new Node(4, null, null);
		tree.root.left.right = new Node(5, null, null);

		// Function Call
		//System.out.println("The diameter of the given binary tree is: " + tree.diamaterAppraoch2(tree.root).diameter);
		tree.topView(tree.root);
		System.out.println();
		System.out.println("print all elements from kth level using normal loop ");
		tree.levelOrderTraversal(tree.root,3);
		System.out.println();
		System.out.println("print all elements from kth level using recursion ");
		tree.printKthLevelElements(tree.root, 2, 1);
	}
}
