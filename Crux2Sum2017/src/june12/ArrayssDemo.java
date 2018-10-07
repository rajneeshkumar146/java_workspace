package june12;

public class ArrayssDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		
		arr = new int[3];
		System.out.println(arr);
		
		// Part 1 - get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
//		System.out.println(arr[3]);
		
		// Part 2 - set
		arr[0] = 10;
		arr[1] = 30;
		arr[2] = 20;
//		arr[3] = 40;
		
		// Part 3 - loop
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		
		
		int i = 0, j = arr.length - 1;
		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr[i], arr[j]);
		System.out.println(arr[i] + ", " + arr[j]);
		
		int[] other = {100, 200, 300};
		System.out.println(arr[0] + ", " + other[0]);
		Swap(arr, other);
		System.out.println(arr[0] + ", " + other[0]);
		
		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr, i, j);
		System.out.println(arr[i] + ", " + arr[j]);
	}
	
	public static void Swap(int[] arr, int i, int j) {
//		System.out.println(arr[i] + ", " + arr[j]);

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
//		System.out.println(arr[i] + ", " + arr[j]);
	}
	
	public static void Swap(int[] one, int[] two){
		int[] temp = one;
		one = two;
		two = temp;
	}
	
	public static void Swap(int one, int two){
		int temp = one;
		one = two;
		two = temp;
	}

}
