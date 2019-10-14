package leetcode;

import support.TreeNode;

public class SymmetricTree_101 {
	
	public static boolean isSymmetric(TreeNode root) {
		/*if (root == null) return true;
		if (root.left == null && root.right == null) return true;
		return isMirror(root.left, root.right);*/
		return isMirror(root, root);
    }
	
	private static boolean isMirror(TreeNode l, TreeNode r) {
		if (l == null && r == null) return true;
		if (l == null || r == null) return false;
		return (l.val == r.val) && isMirror(l.left, r.right) && isMirror(l.right, r.left);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println(isSymmetric(root));
	}

}
