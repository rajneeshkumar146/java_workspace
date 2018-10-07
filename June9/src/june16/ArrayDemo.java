package june16;

public class ArrayDemo {

	public static void main(String[] args) {
//		int[] marks = new int[5];
//		marks[0] = 10;
//		marks[1] = 20;
//		marks[2] = 30;
//		marks[3] = 40;
//		marks[4] = 50;
//		
//		for(int i = 0; i < marks.length; i++){
//			System.out.println(marks[i]);
//		}
		
//		int i = 10;
//		int j = 20;
//		
//		System.out.println(i + " " + j);
//		swap(i, j);
//		System.out.println(i + " " + j);
		
//		int[] arr = {10, 20, 30};
//		int i = 0;
//		int j = 2;
//		
//		System.out.println(arr[i] + " " + arr[j]);
//		swap(arr, i, j);
//		System.out.println(arr[i] + " " + arr[j]);
		
//		int[] one = {10, 20, 30};
//		int[] two = {100, 200, 300};
//		
//		System.out.println(one[0] + " " + one[2]);
//		swaptest1(one, two);
//		System.out.println(one[0] + " " + one[2]);
		
		int[] test = {10, 20, 30};
		System.out.println(test[0] + " " + test[2]);
		swaptest2(test[0], test[2]);
		System.out.println(test[0] + " " + test[2]);
	}
	
	public static void swaptest2(int one, int two){
		int temp = one;
		one = two;
		two = temp;
	}
	
//	public static void swap(int i, int j){
//		int temp = i;
//		i = j;
//		j = temp;
//	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void swaptest1(int[] one, int[] two){
		int[] temp = one;
		one = two;
		two = temp;
	}

	
}
