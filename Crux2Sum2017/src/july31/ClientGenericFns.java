package july31;

import java.util.ArrayList;
import java.util.Comparator;

public class ClientGenericFns {

	public static void main(String[] args) {
		Integer[] iarr = {10, 20, 30, 40, 50};
		display(iarr);
		
		String[] sarr = {"Hi", "world", "universe", "running"};
		display(sarr);
		
		Double[] darr = {11.5, 22.7, 33.8, 44.2};
		display(darr);
		
		
		Student[] students = new Student[5];
		students[0] = new Student("Modi", 100, 1);
		students[1] = new Student("Rahul", 0, Integer.MAX_VALUE);
		students[2] = new Student("Kejri", 10, 10);
		students[3] = new Student("ABC", 50, 50);
		students[4] = new Student("DEF", 60, 40);
		
		bubblesort(students, Student.NameComparator);
		display(students);
	}
	
	public static <T> void display(T[] arr){
		for(T val: arr){
			System.out.print(val + ", ");
		}
		System.out.println(".");
	}
	
	public static <T extends Comparable<T>> void bubblesort(T[] arr){
		int count = 1;
		
		while(count <= arr.length - 1){
			for(int i = 0; i < arr.length - count; i++){
				if(arr[i].compareTo(arr[i + 1]) > 0){
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			
			count++;
		}
		
	}
	
	public static <T> void bubblesort(T[] arr, Comparator<T> ctor){
		int count = 1;
		
		while(count <= arr.length - 1){
			for(int i = 0; i < arr.length - count; i++){
				if(ctor.compare(arr[i], arr[i + 1]) > 0){
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			
			count++;
		}
		
	}
	
//	public static void display(int[] arr){
//		for(int val: arr){
//			System.out.print(val + ", ");
//		}
//		System.out.println(".");
//	}
	
	
	
	
	
	
	
	
	
}
