package july10;

public class RecursionDemos {

	public static void main(String[] args) {
//		System.out.println(PowerBtr(2, 10));
//		int[] arr = { 2, 8, 3, 8, 5, 8, 7 };
//		int[] indices = allIndices(arr, 0, 8, 0);
//		display(indices, 0);
		System.out.println(Factorial(5));
	}

	public static void PrintDecreasingIncreasing(int n) {
		if (n == 0) {
			return;
		}

		if (n % 2 == 1) {
			System.out.println(n);
		}

		PrintDecreasingIncreasing(n - 1);

		if (n % 2 == 0) {
			System.out.println(n);
		}
	}

	public static void PrintDIWJumps(int n) {
	}

	public static int Factorial(int n) {
		if (n == 0) {
			return 1;
		}

		int fnm1 = Factorial(n - 1);
		int fn = n * fnm1;

		return fn;
	}

	public static int Power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnm1 = Power(x, n - 1);
		int xpn = x * xpnm1;
		return xpn;
	}

	public static int PowerBtr(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnb2 = PowerBtr(x, n / 2);
		int xpn = 1;

		if (n % 2 == 0) {
			xpn = xpnb2 * xpnb2;
		} else {
			xpn = xpnb2 * xpnb2 * x;
		}

		return xpn;
	}

	public static void displayStupid(int[] arr) {
		if (arr.length == 0) {
			return;
		}

		int[] sa = new int[arr.length - 1];
		for (int i = 0; i < sa.length; i++) {
			sa[i] = arr[i + 1];
		}

		System.out.println(arr[0]);
		displayStupid(sa);
	}

	public static void display(int[] arr, int vidx) {
		if (vidx == arr.length) { // same as arr.length == 0
			return;
		}

		System.out.println(arr[vidx]); // same as arr[0]
		display(arr, vidx + 1); // same as call for sa
	}

	public static void displayReverse(int[] arr, int vidx) {
		if (vidx == arr.length) { // same as arr.length == 0
			return;
		}

		displayReverse(arr, vidx + 1); // same as call for sa
		System.out.println(arr[vidx]); // same as arr[0]
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return arr[vidx];
		}

		int misa = max(arr, vidx + 1);
		if (misa > arr[vidx]) {
			return misa;
		} else {
			return arr[vidx];
		}
	}

	public static boolean findStupid(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}

		boolean fisa = findStupid(arr, vidx + 1, data);
		if (fisa == true) {
			return true;
		} else {
			if (arr[vidx] == data) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean find(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}

		if (arr[vidx] == data) {
			return true;
		}

		boolean fisa = find(arr, vidx + 1, data);
		return fisa;
	}

	public static int firstIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data) {
			return vidx;
		}

		int fiisa = firstIndex(arr, vidx + 1, data);
		return fiisa;
	}

	public static int lastIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		int liisa = lastIndex(arr, vidx + 1, data);
		if (liisa != -1) {
			return liisa;
		} else {
			if (arr[vidx] == data) {
				return vidx;
			} else {
				return -1;
			}
		}
	}

	public static int[] allIndices(int[] arr, int vidx, int data, int fsf) {
		if (vidx == arr.length) {
			return new int[fsf];
		}

		if (arr[vidx] == data) {
			fsf++;
		}
		
		int[] result = allIndices(arr, vidx + 1, data, fsf);
		
		if (arr[vidx] == data) {
			result[fsf - 1] = vidx;
		}

		return result;
	}

}
