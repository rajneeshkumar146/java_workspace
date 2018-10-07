package june23;

public class RecursionWithArrays {

	public static void main(String[] args) {
//		int[] arr = { 11, 44, 2, 55, 9 };
		// display(arr, 0);
//		System.out.println(max(arr, 0));
		
//		int[] arr = {3, 5, 0, 6, 3, 8, 3, 3, 9, 4};
//		int[] res = allIndices(arr, 0, 3, 0);
//		for(int val: res){
//			System.out.println(val);
//		}
		
//		printColsOfARow(5, 4, 1);
//		printRowsOfABox(5, 1, 1);
		printPattern(5, 1, 1);
	}

	// Expectation -> should print everything from vidx to end
	public static void display(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		System.out.print(arr[vidx] + " ");
		// faith -> it already knows how to print everything from vidx + 1 to
		// end
		display(arr, vidx + 1);
	}

	public static void revDisplay(int[] arr, int vidx) {
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
		} else if (arr[vidx] == data) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean findSmart(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}

		if (arr[vidx] == data) {
			return true;
		} else {
			boolean fisa = findSmart(arr, vidx + 1, data);
			if(fisa == true){
				return true;
			} else {
				return false;
			}
		}
	}

	// return -1 if not found, if found twice then the first index
	public static int firstIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data) {
			return vidx;
		} else {
			int fisa = firstIndex(arr, vidx + 1, data);
			return fisa;
		}

	}

	// return -1 if not found, if found twice then the last index
	public static int lastIndex(int[] arr, int vidx, int data){
		if (vidx == arr.length) {
			return -1;
		}

		int lisa = lastIndex(arr, vidx + 1, data);
		if(lisa != -1){
			return lisa;
		} else if(arr[vidx] == data){
			return vidx;
		} else {
			return -1;
		}
	}

	public static int[] allIndices(int[] arr, int vidx, int data, int csf){
		if(vidx == arr.length){
			int[] ba = new int[csf];
			return ba;
		}
		
		if(arr[vidx] == data){
			csf++;
		}
		
		int[] res = allIndices(arr, vidx + 1, data, csf);
		
		if(arr[vidx] == data){
			res[csf - 1] = vidx;
		}
		
		return res;
	}

	public static void bubbleSort(int[] arr, int i, int j){
	}
	
	public static void printPattern(int n, int i, int j){
		if(i > n){
			return;
		}
		
		if(j <= i){
			System.out.print("*");
			printPattern(n, i, j + 1);
		} else {
			System.out.println();
			printPattern(n, i + 1, 1);
		}
	}

	
	
	
	
	
	
	
	
	
	
}

