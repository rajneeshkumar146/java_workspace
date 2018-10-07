package july31;

import java.util.Comparator;
import java.util.Scanner;

public class GenericFnsClient {

	public static void main(String[] args) {
		Integer[] iarr = {10, 20, 30, 40, 50};
		display(iarr);
		
		Double[] darr = {11.1, 12.2, 13.3, 14.4, 15.5};
		display(darr);
		
		String[] sarr = {"dey", "ZYX", "ade", "MNO", "frp"};
		display(sarr);
		
		bubbleSort(sarr);
		display(sarr);
		
		Car[] cars = new Car[5];
		cars[0] = new Car("Audi", 100, 1000);
		cars[1] = new Car("BMW", 200, 1500);
		cars[2] = new Car("Porsche", 150, 800);
		cars[3] = new Car("Merc", 140, 900);
		cars[4] = new Car("Lambor", 160, 1400);
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Press 1 for speed comparison, 2 for price comparison and 3 for name comparison");
		int choice = scn.nextInt();
		
		System.out.println("Enter true for regular comparison and false for rev comparison");
		boolean regular = scn.nextBoolean();
		
		if(choice == 1 && regular){
			bubbleSort(cars, Car.speedctor);
		} else if(choice == 1 && !regular){
			bubbleSort(cars, Car.speedrevctor);
		} else if(choice == 2 && regular){
			bubbleSort(cars, Car.pricector);
		} else if(choice == 2 && !regular){
			bubbleSort(cars, Car.pricerevctor);
		} else if(choice == 3 && regular){
			bubbleSort(cars, Car.namector);
		} else if(choice == 3 && !regular){
			bubbleSort(cars, Car.namerevctor);
		}
		
		display(cars);
	}
	
//	public static void display(int[] arr){
//		for(int val: arr){
//			System.out.print(val + ", ");
//		}
//		System.out.println(".");
//	}
	
	public static <T> void display(T[] arr){
		for(T val: arr){
			System.out.print(val + ", ");
		}
		System.out.println();
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr){
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

	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator){
		int count = 1;
		
		while(count <= arr.length - 1){
			for(int i = 0; i < arr.length - count; i++){
				if(comparator.compare(arr[i], arr[i + 1]) > 0){
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			
			count++;
		}
	}
	
	
	
	
	
	
	
	

}
