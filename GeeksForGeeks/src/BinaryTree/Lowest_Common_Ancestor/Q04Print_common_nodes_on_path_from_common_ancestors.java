package BinaryTree.Lowest_Common_Ancestor;

import java.util.ArrayList;
import java.util.Scanner;

public class Q04Print_common_nodes_on_path_from_common_ancestors {
	public static Scanner scn = new Scanner(System.in);

	public class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q04Print_common_nodes_on_path_from_common_ancestors() {
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

	public void printPath(int a, int b) {
		int ca = ancestor(root, a, b);
		CommonAncestorsReverseOder(root, ca);

		System.out.println();
		pair p = new pair();
		CommonAncestorsPath(root, ca, b, p);
		for (int i = 0; i < p.a.size() && i < p.b.size(); i++) {
			System.out.print(p.a.get(i) + " ");
			if (p.a.get(i) != p.b.get(i)) {
				return;
			}
		}

	}

	private int ancestor(Node node, int a, int b) {
		if (node == null) {
			return -1;
		}

		if (node.data == a || node.data == b) {
			return node.data;
		}

		int lancestor = ancestor(node.left, a, b);
		int rancestor = ancestor(node.right, a, b);

		if (lancestor != -1 && rancestor != -1) {
			return node.data;
		}

		return lancestor != -1 ? lancestor : rancestor;
	}

	private boolean CommonAncestorsReverseOder(Node node, int ca) {

		if (node == null) {
			return false;
		}

		if (node.data == ca) {
			System.out.print(ca + " ");
			return true;
		}

		if (CommonAncestorsReverseOder(node.left, ca) || CommonAncestorsReverseOder(node.right, ca)) { // agar_Target_left_ya_right_maise_kahipr_bhi_hai_to_print_karo.
			System.out.print(node.data + " ");
			return true;
		}

		return false;
	}

	private void CommonAncestorsPath(Node node, int a, int b, pair p) { // Ek_traversal_mai_common_ancesstor_ka_path_milgya+vo_bhi_sahi_oder_mai.
		if (node == null) {
			return;
		}

		if (!p.isAdone) {
			p.a.add(node.data);
		}
		if (node.data == a) {
			p.isAdone = true;
		}

		if (!p.isBdone) {
			p.b.add(node.data);
		}

		if (node.data == b) {
			p.isBdone = true;
		}

		CommonAncestorsPath(node.left, a, b, p);
		CommonAncestorsPath(node.right, a, b, p);

		if (!p.isAdone) {
			p.a.remove(p.a.size() - 1);
		}

		if (!p.isBdone) {
			p.b.remove(p.b.size() - 1);
		}

	}

	private class pair {
		private ArrayList<Integer> a = new ArrayList<>();
		private boolean isAdone;
		private ArrayList<Integer> b = new ArrayList<>();
		private boolean isBdone;
	}
}
