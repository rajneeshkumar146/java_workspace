package Class_8th_Recursion;

public class Recusrion_demos {

	public static void main(String[] args) {
		int[] arr = { 3, 7, 4, 7, 7, 6, 2, 8, 7, 7 };
		// displayrev(arr, 4);

		/*
		 * System.out.println(max(arr, 0)); System.out.println(find(arr,0,22));
		 * 
		 * System.out.println(firstindex(arr,0,22));
		 * 
		 * System.out.println(lastindex(arr,0,22));
		 */

		 displaybtr(allindices(arr, 0, 7, 0),0);
//		System.out.println(firstindex(arr, 0, 7));

	}

	public static void displaybtr(int[] arr, int vindex) {
		if (arr.length == vindex) {
			return;
		}

		System.out.println(arr[vindex]);
		displaybtr(arr, (vindex + 1));

	}

	public static void displayrev(int[] arr, int vindex) {
		if (vindex == -1) {
			return;
		}

		System.out.println(arr[vindex]);
		displayrev(arr, vindex - 1);

	}

	public static int max(int[] arr, int vindex) {
		if (arr.length == vindex) {
			return Integer.MIN_VALUE;
		}

		int m = max(arr, vindex + 1);
		if (arr[vindex] > m) {
			m = arr[vindex];
		}

		return m;
	}

	public static boolean find(int[] arr, int vindex, int data) {
		if (arr.length == vindex) {
			return false;
		}
		if (arr[vindex] == data) {
			return true;
		}
		boolean n = find(arr, vindex + 1, data);

		return n;

	}

	public static int firstindex(int[] arr, int vindex, int data) {
		if (arr.length == vindex) {
			return -1;
		}
		int count = 1;
		int n = firstindex(arr, vindex + 1, data);
		if (arr[vindex] == data) {
			count++;
		}
		if (count > 1) {
			return vindex;
		}

		return n;

	}

	public static int lastindex(int[] arr, int vindex, int data) {

		if (arr.length == vindex) {
			return -1;
		}
		int rv = lastindex(arr, vindex + 1, data);
		if (rv == -1) {
			if (arr[vindex] == data) {
				return vindex;
			}
		}

		return rv;

	}

	public static int[] allindices(int[] arr, int vindex, int data, int csf) {
		if (arr.length == vindex) {
			int[] rr = new int[csf];
			return rr;
		}

		if (arr[vindex] == data) {
			int[] rr = allindices(arr, vindex + 1, data, csf + 1);
			rr[csf] = vindex;
			return rr;

		} else {
			int[] rr = allindices(arr, vindex + 1, data, csf);
			return rr;
		}

	}

	public static void invertedtriangle(int row, int col, int n) {
		if (row > n) {
			return;
		}
		if (col > row) {

			invertedtriangle(row + 1, 1, n);
			System.out.println();
			return;
		}

		invertedtriangle(row, col + 1, n);
		System.out.println("*");

	}

}
