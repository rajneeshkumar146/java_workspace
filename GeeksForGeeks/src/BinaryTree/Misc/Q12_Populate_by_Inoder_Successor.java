package BinaryTree.Misc;

import java.util.Scanner;

public class Q12_Populate_by_Inoder_Successor {
	public static Scanner scn = new Scanner(System.in);

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node next;
	}

	private Node root;
	private int size;

	public Q12_Populate_by_Inoder_Successor() {
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

	public void InOderSuccessor() { // Isme_right_Se_Start_Krne_Ka_Bahut_Faida_Milega_or_bahut_easily_se_hojyega_bs_patter_follow_krna_hai.
		// 12_25_30_37_40_50_60_62_70_75_87_null.

		pair p = new pair();
		InOderSuccessor(root, p);

	}

	private void InOderSuccessor(Node node, pair p) { // Iss_function_ne_InoderSuccessor_ka_kaam_toh_krdiya_
															// pr_Vo_node-nahi_diya_Jaha_se_inoder_shurur_hota_hai.

		if (node == null) {
			return;
		}

		InOderSuccessor(node.right, p);

		node.next = p.next; // curr_mai_next;
		p.next = node; //// next_mai_curr.

		InOderSuccessor(node.right, p);

	}

	// Display_ke_layak_InoderSuccessor_or_starting_node_bhi_return_kre_jo------------------------------------------------------------

	private class pair{
		private Node next;
	}
	
	public void DisplayInoderSuccessor() {
		pair p = new pair();
		Node starting = DisplayInoderSuccessor(root, p);
		display(starting);
	}

	private Node DisplayInoderSuccessor(Node node, pair p) {

		if (node == null) {
			return null;
		}

		DisplayInoderSuccessor(node.right, p);

		node.next = p.next; //curr_mai_next.
		p.next = node; //next_mai_curr.

		DisplayInoderSuccessor(node.left, p);

		return p.next;
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " => ");
		display(node.next);
	}

}
