package july4;

public class A6Q13 {

	public static void main(String[] args) {
		int[] arr = {11, 55, 22, 66, 0, 77};
		selectionSort(arr, 0, 1);
		for(int va: arr){
			System.out.println(va);
		}
	}
	
	public static void inverse(int[] arr, int vidx){
		if(vidx == arr.length){
			return;
		}
		
		int temp = arr[vidx];
		inverse(arr, vidx + 1);
		arr[temp] = vidx;
	}

	public static void bubbleSort(int[] arr, int si, int ei){
		if(ei == 0){
			return;
		}
		
		if(si == ei){
			bubbleSort(arr, 0, ei - 1);
			return;
		}
		
		if(arr[si] > arr[si + 1]){
			int tep = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = tep;
		}
		
		bubbleSort(arr, si + 1, ei);
	}
	
	public static void selectionSort(int[] arr, int si, int ei){
		if(si == arr.length - 1){
			return;
		}
		
		if(ei == arr.length){
			selectionSort(arr, si + 1, si + 2);
			return;
		}
		
		if(arr[si] > arr[ei]){
			int tep = arr[si];
			arr[si] = arr[ei];
			arr[ei] = tep;
		}
		
		selectionSort(arr, si, ei + 1);
	}
}
