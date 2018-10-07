package BinaryTree.Misc;

import java.util.LinkedList;
import java.util.Scanner;

public class Q13_14_Connect_nodes_at_same_level_using_constant_extra_space {
	public static Scanner scn = new Scanner(System.in);

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private Node nextRight;
	}

	private Node root;
	private int size;

	public Q13_14_Connect_nodes_at_same_level_using_constant_extra_space() {
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

	//---------------------------------------
	
	public void SameLevel() {
		SameLevel(root);
		// System.out.println();
		// SameLevelIrr(root);
		// SameLevelBFS();
		displayNextRight(root.left.right.left);
	}

	private void SameLevel(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			if (node.right != null) {
				node.left.nextRight = node.right;
				node.right.nextRight = getNextRight(node);
			} else {
				node.left.nextRight = getNextRight(node);
			}

		} else if (node.right != null) {
			node.right.nextRight = getNextRight(node);
		}

		SameLevel(node.left);
		SameLevel(node.right);

	}

	//----------------------------------------
	
	private void SameLevelIrr(Node node) {
		if (node == null) {
			return;
		}
		Node temp = node;
		while (temp != null) { // ensure_kkrha_hai_sabhi_ka_bridge_bnjaye.
			Node q = temp;

			while (q != null) { // Parent_apne_children_ka_bridge_bnaraha_hai_jabtc_null_nahi_ajata.

				if (q.left != null) {
					if (q.right != null) {
						q.left.nextRight = q.right;
						q.right.nextRight = getNextRight(q);
					} else {
						q.left.nextRight = getNextRight(q);
					}
				} else if (q.right != null) {
					q.right.nextRight = getNextRight(q);
				}

				q = q.nextRight;
			}

			if (temp.left != null) {
				temp = temp.left;
			} else if (temp.right != null) {
				temp = temp.right;
			} else {
				temp = getNextRight(temp);
			}

		}

	}

	private Node getNextRight(Node node) {
		Node temp = node.nextRight;
		while (temp != null) {
			if (temp.left != null) {
				return temp.left;
			} else if (temp.right != null) {
				return temp.right;
			} else {
				temp = temp.nextRight;
			}
		}

		return null;
	}

	//-----------------------------------------
	
	public void SameLevelBFS() {
		LinkedList<Node> que1 = new LinkedList<Node>();
		LinkedList<Node> que2 = new LinkedList<Node>();

		que1.addFirst(root);
		while (!que1.isEmpty() || !que2.isEmpty()) {

			while (!que1.isEmpty()) {

				Node rn = que1.removeFirst();
				rn.nextRight = que1.peek();

				if (rn.left != null) {
					que2.addLast(rn.left);
				}
				if (rn.right != null) {
					que2.addLast(rn.right);
				}
			}

			while (!que2.isEmpty()) {
				Node rn = que2.removeFirst();
				rn.nextRight = que2.peek();

				if (rn.left != null) {
					que1.addLast(rn.left);
				}
				if (rn.right != null) {
					que1.addLast(rn.right);
				}
			}
		}
	}

	private void displayNextRight(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			displayNextRight(node.nextRight);
		}
	}

}
