package leetcode;

import support.TreeNode;

public class RecoverTreeFromPreorderTraversal_1028 {
	int p = 0;
	
	public TreeNode recoverFromPreorder(String s) {
        int h = 0;
        if (s == null || s.length() == 0) return null;
        String nodeVal = "";
        while (p < s.length() && s.charAt(p) != '-') {
        	nodeVal += String.valueOf(s.charAt(p));
        	p++;
        }
        p--;
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal));
        setNode(root, h, s);
        return root;
    }

	private void setNode(TreeNode root, int h, String s) {
		h++; p++;
		boolean flag = true;
		int i;
		for (i = p; i < p+h && i < s.length(); i++) {
			if (s.charAt(i) != '-') {
				flag = false;
				break;
			}
		}
		if (flag && i < s.length()) {
			p = i;
			String nodeVal = "";
	        while (p < s.length() && s.charAt(p) != '-') {
	        	nodeVal += String.valueOf(s.charAt(p));
	        	p++;
	        }
	        p--;
			root.left = new TreeNode(Integer.parseInt(nodeVal));
			setNode(root.left, h, s);
		}
		
		flag = true;
		for (i = p; i < p+h && i < s.length(); i++) {
			if (s.charAt(i) != '-') {
				flag = false;
				break;
			}
		}
		if (flag && i < s.length()) {
			p = i;
			String nodeVal = "";
	        while (p < s.length() && s.charAt(p) != '-') {
	        	nodeVal += String.valueOf(s.charAt(p));
	        	p++;
	        }
	        p--;
			root.right = new TreeNode(Integer.parseInt(nodeVal));
			setNode(root.right, h, s);
		}
	}

	public static void main(String[] args) {
		String st = "1-2--3---4-5--6---7";
		RecoverTreeFromPreorderTraversal_1028 o = new RecoverTreeFromPreorderTraversal_1028();
		System.out.println(o.recoverFromPreorder(st).val);
	}

}
