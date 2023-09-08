package packagee14_BinaryTrees;

public class A5_Maximum_Path_Sum_in_Binary_Tree {

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

    static int maxPathSum; // Global variable to store the maximum path sum

    public static int findMaxPathSum(Node node) {
        if (node == null) {
            return 0;
        }

        int leftMaxSum = findMaxPathSum(node.left);
        int rightMaxSum = findMaxPathSum(node.right);

        // Calculate the maximum sum for the current node
        int currentMaxSum = Math.max(node.data, Math.max(node.data + leftMaxSum, node.data + rightMaxSum));

        // Update the global maximum path sum if the current node's maximum sum is greater
        maxPathSum = Math.max(maxPathSum, Math.max(currentMaxSum, node.data + leftMaxSum + rightMaxSum));

        return currentMaxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        maxPathSum = Integer.MIN_VALUE; // Initialize the global maximum path sum
        findMaxPathSum(root);
        System.out.println("Maximum path sum is: " + maxPathSum);
    }
}
