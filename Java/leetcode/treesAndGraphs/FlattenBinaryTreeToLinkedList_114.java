package leetcode.treesAndGraphs;

import support.TreeNode;

public class FlattenBinaryTreeToLinkedList_114 {
	
	public void flatten(TreeNode root) {
		if (root == null) return;
		recFlatten(root);
    }

	private TreeNode recFlatten(TreeNode root) {
		TreeNode cur = root;
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		if (left != null) {
			cur.left = null;
			cur.right = left;
			cur = recFlatten(left);
		}
		if (right != null) {
			cur.right = right;
			cur = recFlatten(right);
		}
		return cur;
	}

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList_114 o = new FlattenBinaryTreeToLinkedList_114();
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(5);
		r.left.left = new TreeNode(3);
		r.left.right = new TreeNode(4);
		r.right.right = new TreeNode(6);
		
		o.flatten(r);
		System.out.println(r);
	}

}
