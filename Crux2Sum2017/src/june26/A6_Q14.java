package june26;

public class A6_Q14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = {55, 11, 44, 33, 22};
//		bubbleSort(arr, 0, 0);
//		
//		for(int val: arr){
//			System.out.println(val);
//		}
		
		printPattern(0, 0, 6, 1);
	}
	
	// cse - count of sorted elements
	public static void bubbleSort(int[] arr, int vidx, int cse){
		if(cse == arr.length - 1){
			return;
		}
		
		if(vidx == arr.length - 1 - cse){
			bubbleSort(arr, 0, cse + 1);
			return;
		}
		
		if(arr[vidx] > arr[vidx+ 1]){
			int temp = arr[vidx];
			arr[vidx] = arr[vidx + 1];
			arr[vidx + 1] = temp;
		}
		
		bubbleSort(arr, vidx + 1, cse);
	}

	public static void inverse(int[] arr, int vidx){
		if(vidx == arr.length){
			return;
		}
		
		int temp = arr[vidx];
		inverse(arr, vidx + 1);
		arr[temp] = vidx;
	}

	public static boolean IsSorted(int[] arr, int vidx){
		if(vidx == arr.length - 1){
			return true;
		}
		
		boolean isSaSorted = IsSorted(arr, vidx + 1);
		
		if(isSaSorted == false){
			return false;
		} else {
			if(arr[vidx] < arr[vidx + 1]){
				return true;
			} else {
				return false;
			}
		}
		
	}

	public static void printPattern(int row, int col, int n, int value){
		if(row == n){
			return;
		}
		
		if(col > row){
			System.out.println();
			printPattern(row + 1, 0, n, 1);
			return;
		}
		
		System.out.print(value + "\t");
		printPattern(row, col + 1, n, (value * (row - col)) / (col + 1));
	}
}
