package july31;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] arr; // declared
		
		arr = new int[3];
		System.out.println(arr);
		
		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
//		System.out.println(arr[3]);
		
		// set
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		// length
		System.out.println(arr.length);
		
		// normal loop
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
		}
		System.out.println(".");
		
		// enhanced for loop
		for(int val: arr){
			System.out.print(val + "\t");
			val = 0;
		}
		System.out.println(".");
		
		// shortcut
		int[] arr2 = {10, 20, 30, 40};
		display(arr2);
		
		// swap 1
		System.out.println(arr2[0] + ", " + arr2[3]);
		Swap(arr2[0], arr2[3]);
		System.out.println(arr2[0] + ", " + arr2[3]);
		
		// swap 2
		System.out.println(arr2[0] + ", " + arr2[3]);
		Swap(arr2, 0, 3);
		System.out.println(arr2[0] + ", " + arr2[3]);
	}
	
	public static void Swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void Swap(int one, int two){
		int temp = one;
		one = two;
		two = temp;
	}
		
	
	public static void display(int[] arr){
		for(int val: arr){
			System.out.print(val + "\t");
		}
		System.out.println(".");
	}
	
	
	
	
	
	
	

}
