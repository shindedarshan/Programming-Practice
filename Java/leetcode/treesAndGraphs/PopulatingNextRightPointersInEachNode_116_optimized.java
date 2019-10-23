package leetcode.treesAndGraphs;

import support.Node;

public class PopulatingNextRightPointersInEachNode_116_optimized {
	
	public Node connect(Node root) {
		if (root == null || root.left == null || root.right == null)
			return root;
		root.left.next = root.right;
		
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
		
		return root;
	}

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode_116_optimized o = new PopulatingNextRightPointersInEachNode_116_optimized();
		Node r = new Node(1);
		r.left = new Node(2);
		r.right = new Node(3);
		r.left.left = new Node(4);
		r.left.right = new Node(5);
		r.right.left = new Node(6);
		r.right.right = new Node(7);
		
		o.connect(r);
	}

}
