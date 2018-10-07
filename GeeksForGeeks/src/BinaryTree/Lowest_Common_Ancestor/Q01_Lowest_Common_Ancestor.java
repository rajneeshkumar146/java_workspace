package BinaryTree.Lowest_Common_Ancestor;

import java.util.ArrayList;
import java.util.Scanner;

public class Q01_Lowest_Common_Ancestor {
	public static Scanner scn = new Scanner(System.in);

	public class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public Q01_Lowest_Common_Ancestor() {
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

	public void ancestor(int a, int b) {
		ArrayList<Integer> mover1 = new ArrayList<>();
		ArrayList<Integer> mover2 = new ArrayList<>();
		ancestor(root, a, mover1);  //recursiveCall
		ancestor(root, b, mover2);  //recursiveCall
		
		if (mover1.isEmpty() || mover2.isEmpty()) {
			System.out.println("false");
			return;
		} else {
			int n = mover1.size() < mover2.size() ? mover1.size() : mover2.size();
			int i = 0;
			for (i = 0; i < n; i++) {
				if (mover1.get(i) != mover2.get(i)) {
					System.out.println(mover1.get(i - 1));  //sabsePhela_difference_jahaPe_ayega_usse_phele_wala_hi_CA_hoga.
					return;
				}
			}
			System.out.println(mover2.get(i - 1)); //Pr_agar_vo_subtree_hue_to_Sabse_chhote_arrayList_ke_sizea_tc_common_element_ayenge_then_diffrent_element_ayega.

		}

	}

	private boolean ancestor(Node node, int a, ArrayList<Integer> mover) {
		mover.add(node.data);
		if (a == node.data) {
			return true;
		}

		if (node.left != null && ancestor(node.left, a, mover)) {
			return true;
		}
		if (node.right != null && ancestor(node.right, a, mover)) {
			return true;
		}

		mover.remove(mover.size() - 1);

		return false;
	}

	public int ancestorbtr(int a, int b) {
		return ancestorbtr(root, a, b);
	}

	private int ancestorbtr(Node node, int a, int b) {
		if (node == null) {
			return -1;
		}

		if (node.data == a || node.data == b) {  //agar_dono_maise_koi_bhi_root_se_match_hogya_to_vohi_ancestor_hoga.
			return node.data;
		}

		int lances = ancestorbtr(node.left, a, b);
		int rances = ancestorbtr(node.right, a, b);

		if (lances != -1 && rances != -1) {  //agar_left_or_right_dono_se_ancestor_ayya_means_left_or_right_ka_root_common_ancestor_hoga.
			return node.data;
		}

		return lances != -1 ? lances : rances; //agar_ancestor_ek_trf_se_arha_hai_to_vo_hi_ancestor_hoga.
	}

}
