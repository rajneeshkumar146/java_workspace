package BinaryTree;

import java.util.HashSet;
import java.util.Scanner;

public class Q363_HeightOfSpecialTree {
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		if (isLeaf(node)) {
			System.out.println(". => " + node.data + " <= .");
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	private static boolean isLeaf(Node node) {
		Node left = node.left;
		Node right = node.right;

		if (left != null && left.right == node) {
			return true;
		} else if (right != null && right.left == node) {
			return true;
		} else {
			return false;
		}
	}

	private static void linkLeaves(HashSet<Node> leaves) {
		Node first = null;
		Node last = null;

		Node curr = null;
		Node prev = null;
		for (Node node : leaves) {
			if (first == null) {
				first = node;
			}

			curr = node;

			if (prev != null) {
				curr.left = prev;
				prev.right = curr;
			}

			prev = curr;
		}

		last = prev;
		first.left = last;
		last.right = first;
	}

	// =====================================================================================================

	public static void main(String[] args) {
		Node root = null;

		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		HashSet<Node> leaves = new HashSet<>();
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				Node node = new Node(arr[i], null, null);
				nodes[i] = node;
				leaves.add(node);

				if (i > 0) {

					int PIidx = (i - 1) >> 1;
					Node pi = nodes[PIidx];
					if (leaves.contains(pi)) { // child_ke_pass_authority_hogi_apne_parent_ko_remove_krne_ki.
						// leafes_kisi_ka_parent_nahi_hots_isliye_last_mai_sirf_leafes_hi_bachenge.

						leaves.remove(pi);
					}

					if (i == (2 * PIidx + 1)) {
						pi.left = node;
					} else if (i == 2 * PIidx + 2) {
						pi.right = node;
					}

				}

			}

		}

		linkLeaves(leaves);

		root = nodes[0];

		System.out.println(height(root));

	}

	// Question.===========================================================================================

	private static int height(Node node) {
		if (node == null) {    //vo_leafe_nahi_hai_but_uska_right_child_ahi_hai_so_isko_inssure_krne_ke_liye_ye_base_ayegaa.

			return -1;
		}

		if (isLeaf(node)) {
			return 0;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;

	}
}


//https://www.geeksforgeeks.org/width-binary-tree-set-1/
/*Test Case 1
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
3
*/

/*Test Case 2
7
1 2 3 4 5 6 7
2
*/
