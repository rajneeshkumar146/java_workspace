package BinaryTree.Misc;

import java.util.LinkedList;
import java.util.Scanner;

public class Q15 {
	public static Scanner scn = new Scanner(System.in);

	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q15() {
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

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		display(node.left);
		display(node.right);

	}

	// Q15_IsSubtree---------------------------------------------------------------------------------------------------------------------------

	public boolean isSubtree(Q15 other) {

		return isSubtree(root, other.root);
	}

	private boolean isSubtree(Node node, Node onode) {
		if (node == null && onode != null) {
			return false;
		} else if (node == null && onode == null) {
			return true;
		}

		Node f = find(node, onode);

		return isIdentical(f, onode);
	}

	private boolean isIdentical(Node node, Node onode) {

		// if (node == null && onode == null) {
		// return true;
		// } else if (node == null && onode != null) {
		// return false;
		// } else if (node != null && onode == null) {
		// return false;
		// }
		// Ya_to_uuper_wale_use_krlo_ya_phir_niche_vala.

		if (node == null && onode == null) { // If_both_become_zero_at_same_time.
			return true;
		} else if (node == null || onode == null) { // If_one_of_the_trees_is_NULL_and_other_is_not.
			return false;
		}

		if (node.data == onode.data && isIdentical(node.left, onode.left) && isIdentical(node.right, onode.right)) {
			return true;
		}
		return false;

	}

	private Node find(Node node, Node onode) {
		if (node == null) {
			return null;
		}

		if (node.data == onode.data) {
			return node;
		}

		Node ln = find(node.left, onode);
		if (ln != null) {
			return ln;
		}

		Node rn = find(node.right, onode);
		if (rn != null) {
			return rn;
		}
		return null;
	}

	// Q16_SumTree_check------------------------------------------------------------------------------------------------------------------------

	public boolean Issum() {
		return isSum(root);
	}

	private boolean isSum(Node node) { // O(n^2).
		if (node == null) {
			return true;
		}
		int lsum = 0, rsum = 0;

		if (isLeaf(node)) {
			return true;
		} else {
			lsum = sum(node.left);
			rsum = sum(node.right);
		}
		if (isSum(node.left) && isSum(node.right) && lsum + rsum == node.data) {
			return true;
		} else {
			return false;
		}

	}

	private int sum(Node node) {
		if (node == null) {
			return 0;
		}

		return sum(node.left) + node.data + sum(node.right);
	}

	// ---------------------------------------------

	public boolean IsSumBtr() {
		return isSumBtr(root);
	}

	private boolean isSumBtr(Node node) { // O(n).

		if (node == null) {
			return true;
		}

		int lsum = 0, rsum = 0;

		if (node.left == null) {
			lsum += 0;
		} else if (isLeaf(node.left)) {
			lsum += node.left.data;
		} else {
			lsum += 2 * node.left.data;
		}

		if (node.right == null) {
			rsum += 0;
		} else if (isLeaf(node.right)) {
			lsum += node.right.data;
		} else {
			rsum += 2 * (node.right.data);
		}

		if (node.data == lsum + rsum) {
			return true;
		}

		if (isSumBtr(node.left) && isSumBtr(node.right)) {
			return true;
		}

		return false;

	}

	private boolean isLeaf(Node node) {

		if (node.left == null && node.right == null) {
			return true;
		} else {
			return false;
		}
	}

	// Q17_Print_Ancestors----------------------------------------------------------------------------------------------------------------------

	public void PrintAncestors(int target) {
		PrintAncestors(root, target);
	}

	private boolean PrintAncestors(Node node, int target) {
		if (node == null) {
			return false;
		}

		if (node.data == target) {
			return true;
		}

		if (PrintAncestors(node.left, target) || PrintAncestors(node.right, target)) {
			System.out.println(node.data + " ");
			return true;
		}

		return false;
	}

	// Q18_Get_level_value----------------------------------------------------------------------------------------------------------------------

	public int getLevelValue(int targetLevel) {
		return getLevelValue(root, 1, targetLevel);
	}

	private int getLevelValue(Node node, int lev, int targetLevel) {
		if (node == null) {
			return 0;
		}

		if (targetLevel == lev) {
			return node.data;
		}

		int leftans = getLevelValue(node.left, lev + 1, targetLevel);
		if (leftans != 0) {
			return leftans;
		}

		int rightans = getLevelValue(node.right, lev + 1, targetLevel);
		if (rightans != 0) {
			return rightans;
		}

		return 0;

	}

	// Q19_kDistance_from_root-------------------------------------------------------------------------------------------------------------------

	public void KDistanceprint(int k) {
		KDistanceprint(root, k);
	}

	private void KDistanceprint(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		}

		KDistanceprint(node.left, k - 1);
		KDistanceprint(node.right, k - 1);
	}

	// Q20_Foldable_BinaryTree-------------------------------------------------------------------------------------------------------------------

	public boolean isFoldable() {
		if (root == null) {
			return true;
		}
		return isfoldable(root.left, root.right);
	}

	private boolean isfoldable(Node left, Node right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null && right == null) { // If_one_of_the_trees_is_NULL_and_other_is_not.
			return false;
		}
		if (isfoldable(left.left, right.right) || isfoldable(left.right, right.left)) {
			return true;
		}
		return false;
	}

	// Q21_Maximum_width--------------------------------------------------------------------------------------------------------------------

	public int MaxWidth() { // O(n^2logn)==O(n^2).

		int height = height(root);
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= height; i++) {
			max = Math.max(max, MaxWidth(root, i));
		}

		return max;
	}

	private int MaxWidth(Node node, int i) {
		if (node == null) {
			return 0;
		}

		if (i == 0) {
			return 1;
		}

		return MaxWidth(node.left, i - 1) + MaxWidth(node.right, i - 1);

	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		return Math.max(height(node.left), height(node.right)) + 1;
	}

	// ---------------------------------------

	public int MaxWidthQueBased() { // O(n).Queue_Basesd_More_best_than_next_one.
		LinkedList<Node> que = new LinkedList<Node>();
		que.addLast(root);

		int max = Integer.MIN_VALUE;

		while (!que.isEmpty()) {
			int count = que.size();

			max = Math.max(max, count);

			while (count-- > 0) {
				Node q = que.removeFirst();
				if (q.left != null) {
					que.addLast(q.left);
				}
				if (q.right != null) {
					que.addLast(q.right);
				}
			}
		}
		return max;
	}

	// ------------------------------------------

	public int MaxWidthArray() { // O(n).
									// By_Use_Of_array_storing_count_against_index_which_represent_its_height.

		int height = height(root);
		int[] arr = new int[height + 1];

		MaxWidthArray(root, arr, 0);

		return Max(arr);

	}

	private void MaxWidthArray(Node node, int[] arr, int cheight) {
		if (node == null) {
			return;
		}
		arr[cheight]++;
		MaxWidthArray(node.left, arr, cheight + 1);
		MaxWidthArray(node.right, arr, cheight + 1);
	}

	private int Max(int[] arr) {
		int max = arr[0];

		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	// Q22_Double_Tree-----------------------------------------------------------------------------------------------------------------------------

	public void doubleTree() {
		doubleTree(root);
	}

	private void doubleTree(Node node) {
		if (node == null) {
			return;
		}

		doubleTree(node.left);
		doubleTree(node.right);

		Node oldleft = node.left;
		Node nnode = new Node();
		nnode.data = node.data;
		nnode.left = oldleft;
		node.left = nnode;

	}

	// Q23_Root_to_leaf----------------------------------------------------------------------------------------------------------------------------

	public void rootToLeaf() {
		rootToLeaf(root, "");
	}

	private void rootToLeaf(Node node, String psf) {
		if (node.left == null && node.right == null) {
			System.out.println(psf + " " + node.data);
			return;
		}

		rootToLeaf(node.left, psf + " " + node.data);
		rootToLeaf(node.right, psf + " " + node.data);

	}

	// Q24_Check_complete_binary_tree-------------------------------------------------------------------------------------------------------------

	public boolean CompleteBinaryTree(){
		return CompleteBinaryTree(root);
	}

	private boolean CompleteBinaryTree(Node node) {

		LinkedList<Node> queue=new LinkedList<Node>();
		
		
		
		
		
		
		
		
		return false;
	}
	
	
	
	
	
	
}
