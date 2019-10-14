package leetcode;

import java.util.Stack;

import support.TreeNode;

public class LeafSimilarTrees_872 {
	
	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String s1 = ""; 
        Stack<TreeNode> st1 = new Stack<>();
        st1.push(root1);
        
        while (!st1.isEmpty()) {
        	TreeNode t = st1.pop();
        	if (t.left == null && t.right == null) s1 += t.val;
        	if(t.right != null) st1.push(t.right);
        	if(t.left != null) st1.push(t.left);
        }

        String s2 = "";
        Stack<TreeNode> st2 = new Stack<>();
        st2.push(root2);
        
        while (!st2.isEmpty()) {
        	TreeNode t = st2.pop();
        	if (t.left == null && t.right == null) s2 += t.val;
        	if(t.right != null) st2.push(t.right);
        	if(t.left != null) st2.push(t.left);
        }
        
        return s1.equals(s2);
    }

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(44);
		root1.left = new TreeNode(79);
		root1.right = new TreeNode(25);
		root1.right.left = new TreeNode(112);
		root1.right.right = new TreeNode(7);
		root1.right.left.left = new TreeNode(74);
		root1.right.left.right = new TreeNode(49);
		root1.right.right.left = new TreeNode(2);
		root1.right.right.right = new TreeNode(122);
		
		TreeNode root2 = new TreeNode(38);
		root2.left = new TreeNode(86);
		root2.right = new TreeNode(120);
		root2.left.left = new TreeNode(49);
		root2.left.right = new TreeNode(54);
		root2.left.right.left = new TreeNode(74);
		root2.left.right.right = new TreeNode(79);
		root2.right.left = new TreeNode(2);
		root2.right.right = new TreeNode(122);
		
		System.out.println(leafSimilar(root1, root2));
	}

}
