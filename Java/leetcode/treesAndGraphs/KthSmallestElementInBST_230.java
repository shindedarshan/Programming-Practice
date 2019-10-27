package leetcode.treesAndGraphs;

import java.util.LinkedList;

import support.TreeNode;

public class KthSmallestElementInBST_230 {
	
	public int kthSmallest(TreeNode root, int k) {
		LinkedList<TreeNode> st = new LinkedList<>();
		
		while(true) {
			while (root != null) {
				st.add(root);
				root = root.left;
			}
			root = st.removeLast();
			k--;
			if (k == 0) return root.val;
			root = root.right;
		}
    }

	public static void main(String[] args) {
		KthSmallestElementInBST_230 o = new KthSmallestElementInBST_230();
		TreeNode r = new TreeNode(5);
		r.left = new TreeNode(3);
		r.right = new TreeNode(6);
		r.left.left = new TreeNode(2);
		r.left.right = new TreeNode(4);
		r.left.left.left = new TreeNode(1);
		System.out.println(o.kthSmallest(r, 3));
	}

}
