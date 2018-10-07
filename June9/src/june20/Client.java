package june20;

public class Client {

	public static void main(String[] args) {
//		int[] arr = {7, 1, 8, 2, 5};
//		june18.ArrayUtils.display(arr);
//		insertionSort(arr);
//		june18.ArrayUtils.display(arr);
		
//		int[][] arr = {
//				{11, 12, 13, 14},
//				{21, 22, 23, 24},
//				{31, 32, 33, 34},
//				{41, 42, 43, 44}
//		};
//		rotate90(arr);
		
		int[][] arr = {
				{0, 0, 1, 0},
				{1, 0, 0, 0},
				{0, 0, 0, 0},
				{1, 0, 1, 0}
		};
		exitPoint(arr);
	}
	
	public static void bubbleSort(int[] arr){
		int jc = 1;
		
		while(jc <= arr.length - 1){
			for(int i = 0; i < arr.length - jc; i++){
				if(arr[i] > arr[i + 1]){
					june18.ArrayUtils.swap(arr, i, i + 1);
				}
			}
			
			jc++;
		}
	}
	
	public static void selectionSort(int[] arr){
		int jc = 1;
		
		while(jc <= arr.length - 1){
			for(int i = jc; i < arr.length; i++){
				if(arr[jc - 1] > arr[i]){
					june18.ArrayUtils.swap(arr, i, jc - 1);
				}
			}
			
			jc++;
		}
	}
	
	public static void insertionSort(int[] arr){
		int jc = 1;
		
		while(jc <= arr.length - 1){
			for(int i = jc; i > 0; i--){
				if(arr[i] < arr[i - 1]){
					june18.ArrayUtils.swap(arr, i, i - 1);
				} else {
					break;
				}
			}
			
			jc++;
		}
	}

	public static void rotate90(int[][] arr){
		// transpose
		for(int i = 0; i < arr.length; i++){
			for(int j = i; j < arr[0].length; j++){
				swap(arr, i, j);
			}
		}
		
		// reverse columns
		for(int i = 0; i < arr.length; i++){
			int left  = 0;
			int right = arr[0].length - 1;
			while(left < right){
				int temp = arr[i][left];
				arr[i][left] = arr[i][right];
				arr[i][right] = temp;
				
				left++;
				right--;
			}
		}
		
		// display
		june19.MatrixMult.display(arr);
	}
	
	private static void swap(int[][] arr, int i, int j){
		int temp = arr[i][j];
		arr[i][j] = arr[j][i];
		arr[j][i] = temp;
	}

	public static void exitPoint(int[][] arr){
		int i = 0;
		int j = 0;
		int dir = 0; // 0e, 1s, 2w, 3n
		
		while(true){
			dir = (dir + arr[i][j]) % 4;
			
			if(dir == 0){
				j++;
			} else if(dir == 1){
				i++;
			} else if(dir == 2){
				j--;
			} else if(dir == 3){
				i--;
			}
			
			if(i < 0){
				i++;
				System.out.println(i + " " + j);
				break;
			} else if(j < 0){
				j++;
				System.out.println(i + " " + j);
				break;
			} else if(i >= arr.length){
				i--;
				System.out.println(i + " " + j);
				break;
			} else if(j >= arr[0].length){
				j--;
				System.out.println(i + " " + j);
				break;
			}
		}
	}
}
