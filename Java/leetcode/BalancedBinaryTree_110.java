package leetcode;

import support.TreeNode;

public class BalancedBinaryTree_110 {
	
	public static boolean isBalanced(TreeNode root) {
		return dfsHeight(root) == -1? false: true;
	}

	private static int dfsHeight(TreeNode root) {
		if (root == null) return 0;
		int lh = dfsHeight(root.left);
		int rh = dfsHeight(root.right);
		if (lh == -1 || rh == -1 ||Math.abs(lh-rh) > 1) return -1;
		return Math.max(lh, rh) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right.right.right = new TreeNode(4);
		
		System.out.println(isBalanced(root));
	}

}
