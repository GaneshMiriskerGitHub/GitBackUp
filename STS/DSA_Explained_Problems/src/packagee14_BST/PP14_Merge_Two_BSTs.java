package packagee14_BST;

import java.util.ArrayList;

import packagee14_BST.PP12_Covert_to_Balanced_BST.Node;

public class PP14_Merge_Two_BSTs {
	
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
	
	public static void getPathUsingInOrder(Node root, ArrayList<Integer> list ) {
		if(root == null) {
			return;
		}
		
		getPathUsingInOrder(root.left, list);
		list.add(root.data);
		getPathUsingInOrder(root.right, list);
	}
	
	public static void mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list) {
		
		int i=0;
		int j=0;
		int k=0;
		while(j < list1.size() && k < list2.size()) {
			if(list1.get(i) > list2.get(i)) {
				list.add(list1.get(j));
				j++;
				i++;
			}else {
				list.add(list2.get(k));
				k++;
				i++;
			}
		}
		
		while(j < list1.size()) {
			list.add(list1.get(j));
			j++;
			i++;
		}
		
		while( k < list2.size()) {
			list.add(list2.get(k));
			k++;
			i++;
		}
		
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
		
		Node root1 = new Node(2);
		root1.left = new Node(1);
		root1.right = new Node(4);
		
		Node root2 = new Node(9);
		root2.left = new Node(3);
		root2.right = new Node(4);
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		getPathUsingInOrder(root1, list1);
		getPathUsingInOrder(root2, list2);
		
		mergeLists(list1, list2, list);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list);
		Node root = buildBalancedBST(list, 0, list.size()-1);
		printTree(root);
	}

}
