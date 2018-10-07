package BinaryTree;

import java.io.IOException;
import java.util.Scanner;

public class Q354_FindHeightOfBinaryTreeReprsentedByParentArray {
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

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	// ==============================================================================================================================

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int[] heightArray = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1 && heightArray[i] == 0) {
				heightArray[i] = Height(arr, i, heightArray)+1;
			}

			if (heightArray[i] > max) {
				max = heightArray[i];
			}

		}

//		 System.out.println(max);
		displayArray(heightArray);

		// display(root);

	}

	// ==========================================================================================================================

	private static int Height(int[] arr, int idx, int[] heightArray) {
		if (arr[idx] == -1) {
			return -1;
		}

		if (heightArray[arr[idx]] != 0) {
			return heightArray[arr[idx]];
		}

		heightArray[idx] = Height(arr, arr[idx], heightArray)+1;

		return heightArray[idx];

	}

	private static void displayArray(int[] arr) throws IOException {
		for (int i = 0; i < arr.length; i++) {
			// pnter.print(arr[i] + " ");
			System.out.print(arr[i] + " ");
		}
		// pnter.printLine("");
		System.out.println();
	}
}



/* Test Case 1
7
1 5 5 2 2 -1 3
3
*/

/* Test Case 2
8
5 -1 1 1 2 3 4 4
3
*/