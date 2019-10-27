package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import support.TreeNode;

public class BinaryTreeRightSideView_199 {
	
	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> out = new ArrayList<>();
		if (root == null)
			return out;
		Queue<TreeNode> n = new LinkedList<>();
		Queue<Integer> l = new LinkedList<>();
		n.add(root);
		l.add(1);
		
		if ((root.left == null && root.right == null)) {
			out.add(root.val);
			return out;
		}
		
		while(!n.isEmpty()) {
			TreeNode t = n.poll();
			int level = l.poll();
			if (n.isEmpty()) out.add(t.val);
			else if (l.peek() != level) out.add(t.val);
			
			if (t.left != null) {n.add(t.left); l.add(level + 1);}
			if (t.right != null) {n.add(t.right); l.add(level + 1);}
		}
		
        return out;
    }

	public static void main(String[] args) {
		BinaryTreeRightSideView_199 o = new BinaryTreeRightSideView_199();
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(3);
		r.right.right = new TreeNode(4);
		r.left.right = new TreeNode(5);
		List<Integer> out = o.rightSideView(r);
		for (int i: out) {
			System.out.print(i + " ");
		}
	}

}
