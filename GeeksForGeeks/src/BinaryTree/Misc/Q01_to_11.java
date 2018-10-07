package BinaryTree.Misc;

import java.util.Scanner;

public class Q01_to_11 {
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q01_to_11() {
		Scanner scn = new Scanner(System.in);
		this.root = takeinput(null, false, scn);

	}

	private Node takeinput(Node parent, boolean ilc, Scanner scn) {
		// prompt
		if (parent == null) {
			System.out.println("Entre Data for Root");
		} else {
			System.out.format("Enter data for %s for" + parent.data + "%n", ilc ? "Left Child" : "right Child");
		}

		// Set_Data
		int data = scn.nextInt();
		Node node = new Node();
		node.data = data;
		this.size++;

		System.out.println("Do you have a left Child: ");
		Boolean hlc = scn.nextBoolean();
		if (hlc) {
			node.left = takeinput(node, true, scn);
		}

		System.out.println("Do you have a right child: ");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			node.right = takeinput(node, false, scn);
		}

		return node;
	}

	// Q1_Delete_a_tree---------------------------------------------------------------------------------------------------------

	public void clear() {
		root = null;

	}

	// Q02_Height_and_depth.

	public int Height() {
		return Height(root);
	}

	private int Height(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = Height(node.left);
		int rh = Height(node.right);

		return (Math.max(lh, rh) + 1);
	}

	// Q03_Two_tree_identical_or_not.

	public boolean Identical(Q01_to_11 t) {

		return Identical(this.root, t.root);

	}

	private boolean Identical(Node node, Node onode) {
		if (node == null && onode == null) {
			return true;
		}

		if (node != null && onode != null) {
			if (node.data == onode.data && Identical(node.left, onode.left) && Identical(node.right, onode.right)) {
				return true;
			}

		}
		return false;
	}

	// Q04_Size_of_tree.

	public int Size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}
		return (size(node.left) + size(node.right) + 1);
	}

	// Q05_Root_to_leaf_path_sum_equal_to_a_given_number.

	public boolean TargetSumExist(int sum) {
		return TargetSumExist(root, 0, sum);
	}

	private boolean TargetSumExist(Node node, int target, int sum) {
		if (node == null) {
			if (target == sum) {
				return true;
			} else {
				return false;
			}
		}

		if (TargetSumExist(node.left, target + node.data, sum) || TargetSumExist(node.right, target + node.data, sum)) {
			return true;
		}

		return false;

	}

	// Q06_binary_tree_is_height_balanced----------------------------------------------------------------------------------------------------

	public boolean heightBalanced1() {
		return heightBalanced1(root);
	}

	private boolean heightBalanced1(Node node) {
		if (node == null) {
			return true;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		if (Math.abs(lh - rh) <= 1 && heightBalanced1(node.left) && heightBalanced1(node.right)) {
			return true;
		}

		return false;

	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public boolean heightBalanced2() { // Using_height_and_isbalanced_pair.
		return heightBalanced2(root).isbalanced;
	}

	private class heightBalancedPair {
		private int height = 0;
		private boolean isbalanced;
	}

	private heightBalancedPair heightBalanced2(Node node) {
		if (node == null) {
			heightBalancedPair rp = new heightBalancedPair();
			rp.height = -1;
			rp.isbalanced = true;
			return rp;
		}

		heightBalancedPair lp = heightBalanced2(node.left);
		heightBalancedPair rp = heightBalanced2(node.right);

		heightBalancedPair mr = new heightBalancedPair();
		mr.height = Math.max(lp.height, rp.height) + 1;

		if (lp.isbalanced && rp.isbalanced && Math.abs(rp.height - lp.height) <= 1) {
			mr.isbalanced = true;
		} else {
			mr.isbalanced = false;
		}
		return mr;
	}

	// Q07_Diameter-------------------------------------------------------------------------------------------------------------------

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		int ld = diameter(node.left);
		int rd = diameter(node.right);

		return Math.max(Math.max(ld, rd), lh + rh + 2);

	}

	private class diapair {
		private int height;
		private int diameter;
	}

	public int diameter1() {
		return diameter1(root).diameter;
	}

	private diapair diameter1(Node node) {

		if (node == null) {
			diapair pair = new diapair();
			pair.height = -1;
			pair.diameter = 0;
			return pair;
		}

		diapair lp = diameter1(node.left);
		diapair rp = diameter1(node.right);

		diapair mr = new diapair();

		mr.height = Math.max(lp.height, rp.height) + 1;

		mr.diameter = Math.max(Math.max(lp.diameter, rp.diameter), lp.height + rp.height + 2);
		return mr;

	}

	/*
	 * the diameter of a tree is nothing but maximum value of (left_height +
	 * right_height + 1) with current diameter for each node.
	 */

	public int diameterbtr() {
		int ans = -1;
		diameterbtr(root, ans);
		return ans;
	}

	private int diameterbtr(Node node, int ans) {
		if (node == null) {
			return 0;
		}
		int lheight = diameterbtr(node.left, ans);
		int rheight = diameterbtr(node.right, ans);

		ans = Math.max(ans, lheight + rheight + 1);

		return Math.max(lheight, rheight) + 1;

	}

	// Q08_Check_for_Children_Sum_Property---------------------------------------------------------------------------------------------------

	public boolean childrenSum() {
		return childrenSum(root);
	}

	private boolean childrenSum(Node node) {

		int left = 0, right = 0;

		if (node == null || (node.left == null && node.right == null)) {
			return true;
		} else {

			if (node.left != null) {
				left = node.left.data;
			}

			if (node.right != null) {
				right = node.right.data;
			}

			if (childrenSum(node.left) && childrenSum(node.right) && node.data == left + right) {
				return true;
			} else {
				return false;
			}
		}
	}

	// Q09_count_leaf_nodes--------------------------------------------------------------------------------------------------------------------

	public int countLeafs() {
		return countLeafs(root);
	}

	private int countLeafs(Node node) {

		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			return 1;
		} else {
			return countLeafs(node.left) + countLeafs(node.right);
		}
	}

	// Q10_The_Great_Tree-List----------------------------------------------------------------------------------------------------------------

	// Q11_print_out_all_of_its_root-to-leaf_paths_LIne_By_Line--------------------------------------------------------------------------------

	public void printPathRootToLeaf() {
		printPathRootToLeaf(root, "");
	}

	private void printPathRootToLeaf(Node node, String ans) {
		if (node.left == null && node.right == null) {
			System.out.println(ans + " " + node.data);
			return;
		}
		printPathRootToLeaf(node.left, ans + " " + node.data);
		printPathRootToLeaf(node.right, ans + " " + node.data);

	}








}
