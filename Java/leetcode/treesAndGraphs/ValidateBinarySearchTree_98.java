package leetcode.treesAndGraphs;

import java.util.Stack;

import support.TreeNode;

public class ValidateBinarySearchTree_98 {
	
	Stack<TreeNode> st = new Stack<>();
	int in = Integer.MAX_VALUE;
	
	public boolean isValidBST(TreeNode root) {
		inOrder(root);
		if (!st.isEmpty()) in = st.pop().val;
		while (!st.isEmpty()) {
			int i = st.pop().val;
			if (i < in) {
				in = i;
			} else return false;
		}
			
		return true;
    }

	private void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			st.add(root);
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree_98 o = new ValidateBinarySearchTree_98();
		TreeNode r = new TreeNode(-2147483648);
		//r.left = null; //new TreeNode(1);
		r.right = new TreeNode(2147483647);
		//r.right.left = new TreeNode(3);
		//r.right.right = new TreeNode(6);
		System.out.println(o.isValidBST(r));
	}

}
