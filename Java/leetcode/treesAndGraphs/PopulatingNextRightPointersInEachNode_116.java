package leetcode.treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

import support.Node;

public class PopulatingNextRightPointersInEachNode_116 {
	
	public Node connect(Node root) {
		if (root == null) return null;
		
		Queue<Node> q = new LinkedList<>();
		Queue<Integer> l = new LinkedList<>();
		
		q.add(root);
		l.add(1);
		
		while (!q.isEmpty()) {
			Node f = q.poll();
			int h = l.poll();
			
			if (f != null) {
				if (!l.isEmpty() && h == l.peek()) {
					f.next = q.peek();
				}
				q.add(f.left);
				l.add(h+1);
				q.add(f.right);
				l.add(h+1);
			}
		}
		
		return root;
    }

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode_116 o = new PopulatingNextRightPointersInEachNode_116();
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

