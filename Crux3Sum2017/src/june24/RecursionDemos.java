package june24;

import java.util.ArrayList;

public class RecursionDemos {

	public static void main(String[] args) {
//		PrintDecreasingIncreasing(5);
//		System.out.println(Factorial(5));
//		System.out.println(PowerBtr(3, 4));
		int[] arr = {55, 11, 44, 33, 22};
		display(arr);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		displaySmarter(arr, 0);
	}

	public static void PrintDecreasing(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		PrintDecreasing(n - 1);
	}

	public static void PrintIncreasing(int n) {
		if (n == 0) {
			return;
		}

		PrintIncreasing(n - 1);
		System.out.println(n);
	}

	public static void PrintDecreasingIncreasing(int n) {
		if (n == 0) {
			return;
		}

		if (n % 2 == 1) {
			System.out.println("Hi " + n);
		}

		PrintDecreasingIncreasing(n - 1);

		if (n % 2 == 0) {
			System.out.println("Bye " + n);
		}

	}

	public static int Factorial(int n){
		if(n == 0){
			return 1;
		}
		
		int fnm1 = Factorial(n - 1);
		int fn = n * fnm1;
		
		return fn;
	}
	
	public static int Fib(int n){
		if(n == 0 || n == 1){
			return n;
		}
		
		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);
		int fn = fnm1 + fnm2;
		
		return fn;
	}
	
	public static int Power(int x, int n){
		if(n == 0){
			return 1;
		}

		int xpnm1 = Power(x, n - 1);
		int xpn = x * xpnm1;
		
		return xpn;
	}
	
	public static int PowerBtr(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpnb2 = PowerBtr(x, n / 2);
		int xpn = xpnb2 * xpnb2;

		if(n % 2 == 1){
			xpn = xpn * x;
		}
		
		return xpn;
	}
	
	public static void display(int[] arr){
		if(arr.length == 0){
			return;
		}
		
		int[] sa = new int[arr.length - 1];
		for(int i = 0; i < sa.length; i++){
			sa[i] = arr[i + 1];
		}
		
		System.out.println(arr[0]);
		display(sa);
	}
	
	public static void displaySmarter(int[] arr, int vidx){
		if(vidx == arr.length){
			return;
		}
		
		System.out.println(arr[vidx]);
		displaySmarter(arr, vidx + 1);
	}
	
	public static void displayReverse1(int[] arr, int vidx){
		if(vidx == -1){
			return;
		}
		
		System.out.println(arr[vidx]);
		displayReverse1(arr, vidx - 1);
	}
	
	public static void displayReverse2(int[] arr, int vidx){
		if(vidx == arr.length){
			return;
		}
		
		displayReverse2(arr, vidx + 1);
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
	
	public static boolean find1(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return false;
		}
		
		boolean fisa = find1(arr, vidx + 1, data);
		
		if(fisa == true){
			return true;
		} else {
			if(arr[vidx] == data){
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static boolean find2(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return false;
		}
		
		if(arr[vidx] == data){
			return true;
		}
		
		boolean fisa = find2(arr, vidx + 1, data);
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
		
		if(liisa != -1){
			return liisa;
		} else {
			if(arr[vidx] == data){
				return vidx;
			} else {
				return -1;
			}
		}
	}
	
	public static int[] allIndices(int[] arr, int vidx, int data, int fsf){
		if(vidx == arr.length){
			return new int[fsf];
		}
		
		if(arr[vidx] == data){
			int[] aiisa = allIndices(arr, vidx + 1, data, fsf + 1);
			aiisa[fsf] = vidx;
			return aiisa;
		} else {
			int[] aiisa = allIndices(arr, vidx + 1, data, fsf);
			return aiisa;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
