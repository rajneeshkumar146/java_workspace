package BinaryTree.Traversal;

import java.util.Scanner;

public class Q11_postOder_from_InOder_and_PreOder {
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public void postOderFromInPr(int[] In, int[] pr) {
		int[] post = new int[In.length];
		postOderFromInPr(post, In, pr, 0, In.length - 1, 0, pr.length - 1);

	}

	private void postOderFromInPr(int[] post, int[] in, int[] pr, int insi, int inei, int prsi, int prei) {
		if (insi > inei || prsi > prei) {
			return;
		}

		int idx = -1;
		for (int i = insi; i <= inei; i++) {
			if (in[i] == pr[prsi]) {
				idx = i;
				break;
			}
		}
		int tnoel = idx - insi;
		if (idx != 0) {
			postOderFromInPr(post, in, pr, 0, idx - 1, prsi + 1, prsi + tnoel);
		}
		if (idx != in.length - 1) {
			postOderFromInPr(post, in, pr, idx + 1, inei, prsi + tnoel + 1, prei);
		}
		System.out.print(pr[prsi] + " ");
	}

}
