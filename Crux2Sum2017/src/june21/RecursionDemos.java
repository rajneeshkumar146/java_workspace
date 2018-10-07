package june21;

public class RecursionDemos {

	public static void main(String[] args) {
//		int[] arr = {5, 11, 22, 44, 33};
//		displayRev(arr, 0);
		
//		int[] arr = {3, 7, 4, 7, 7, 6, 2, 8, 7, 7};
//		int[] idces = allIndices(arr, 0, 7, 0);
//		
//		displayBtr(idces, 0);
		
//		printRows(1, 5);
//		printColumns(1, 5);
		printTriangle(1, 1, 4);
	}
	
	public static void displayBtr(int[] arr, int vidx) {
		if(vidx == arr.length){
			return;
		}
		
		System.out.println(arr[vidx]);
		displayBtr(arr, vidx + 1);
	}
	
	public static void displayRev(int[] arr, int vidx) {
		if(vidx == arr.length){
			return;
		}
		
		displayRev(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}
	
	public static int max(int[] arr, int vidx){
		if(vidx == arr.length - 1){
			return arr[vidx];
		}
		
		int misa = max(arr, vidx + 1);
		if(misa > arr[vidx]){
			return misa;
		} else {
			return arr[vidx];
		}
	}

	public static boolean find(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return false;
		}
		
		if(arr[vidx] == data){
			return true;
		}
		
		boolean fisa = find(arr, vidx + 1, data);
		return fisa;
	}
	
	public static int firstIndex(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return -1;
		}
		
		if(arr[vidx] == data){
			return vidx;
		}
		
		int fiisa = firstIndex(arr, vidx + 1, data);
		return fiisa;
	}
	
	public static int lastIndex(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return -1;
		}
		
		int liisa = lastIndex(arr, vidx + 1, data);
		if(liisa == -1){
			if(arr[vidx] == data){
				return vidx;
			} else {
				return -1;
			}
		} else {
			return liisa;
		}
	}
	
	public static int[] allIndices(int[] arr, int vidx, int data, int csf){
		if(vidx == arr.length){
			return new int[csf];
		}
		
		int[] rr = null;
		
		if(arr[vidx] == data){
			rr = allIndices(arr, vidx + 1, data, csf + 1);
			rr[csf] = vidx;
		} else {
			rr = allIndices(arr, vidx + 1, data, csf);
		}
		
		return rr;
	}
	
	public static void display(int[] arr) {
		if(arr.length == 0){
			return;
		}
		
		int[] sa = new int[arr.length - 1];
		for (int i = 0; i < sa.length; i++) {
			sa[i] = arr[i + 1];
		}
		
		System.out.println(arr[0]);
		display(sa);
	}
	
	public static void printRows(int row, int n){
		if(row > n){
			return;
		}
		
		System.out.println("hello");
		printRows(row + 1, n);
	}
	
	public static void printColumns(int col, int n){
		if(col > n){
			return;
		}
		
		System.out.print("*");
		printColumns(col + 1, n);
	}
	
	public static void printBox(int row, int col, int n){
		if(row > n){
			return;
		}
		
		if(col > n){
			System.out.println();
			printBox(row + 1, 1, n);
			return;
		}
		
		System.out.print("*");
		printBox(row, col + 1, n);
	}
	
	public static void printTriangle(int row, int col, int n){
		if(row > n){
			return;
		}
		
		if(col > row){
			System.out.println();
			printTriangle(row + 1, 1, n);
			return;
		}
		
		System.out.print("*");
		printTriangle(row, col + 1, n);
	}
	
	public static void printInvTriangle(int row, int col, int n){
		if(row > n){
			return;
		}
		
		if(col > row){
			printInvTriangle(row + 1, 1, n);
			System.out.println();
			return;
		}
		
		printInvTriangle(row, col + 1, n);
		System.out.print("*");
	}
	
	
	
	
	
	
	
	
}
