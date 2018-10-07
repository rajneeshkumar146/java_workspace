package july31;

import java.util.Arrays;

public class ArrayOps {
	public static void display(int[] arr){
		for(int val: arr){
			System.out.print(val + "\t");
		}
		System.out.println(".");
	}
	
	public static void main(String[] args) {
//		int[] arr = {55, 11, 44, 77, 22, 88, 33};
//		
//		int maxvalue = getMax(arr);
//		System.out.println(maxvalue);
//		
//		System.out.println(linearSearch(arr, 77));
//		System.out.println(linearSearch(arr, 770));
//		
//		display(arr);
//		reverse(arr);
//		display(arr);
//		
//		Arrays.sort(arr);
//		display(arr);
//		
//		System.out.println(binarySearch(arr, 77));
//		System.out.println(binarySearch(arr, 770));
		int[] arr = {4, 1, 3, 0, 2};
		int[] inv = inverse(arr);
		display(inv);
		
		int[] rot = rotate(inv, 2);
		display(rot);
		
		bytes(-1);
	}
	
	public static int getMax(int[] arr){
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		
		return max;
	}
	
	public static int linearSearch(int[] arr, int data){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == data){
				return i;
			} 
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] arr, int data){
		int lo = 0, hi = arr.length - 1;
		
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			
			if(data == arr[mid]){
				return mid;
			} else if(data > arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void reverse(int[] arr){
		int left = 0, right = arr.length - 1;
		
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
	}
	
	public static int[] inverse(int[] arr){
		int[] inv = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			inv[arr[i]] = i;
		}
		
		return inv;
	}
	
	public static int[] rotate(int[] arr, int k){
		int[] rot = new int[arr.length];
		
		k = k % arr.length;
		if(k < 0){
			k = k + arr.length;
		}
		
		int ridx = 0;
		for(int i = arr.length - k; i < arr.length; i++){
			rot[ridx] = arr[i];
			ridx++;
		}
		
		for(int i = 0; i < arr.length - k; i++){
			rot[ridx] = arr[i];
			ridx++;
		}
		
		return rot;
	}
	
	public static void bytes(int n){
		int count = 0;
		
		for(byte i = 0; i <= 7; i++){
			byte test = (byte)(1 << i);
			if((n & test) == test){
				count++;
			}
		}
		
		System.out.println(count);
	}
}
