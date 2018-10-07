package Class_26th_Generics_Overloading_HuffmenEncoder;

import java.util.Comparator;

public class ClientGenericsFun {

	public static void main(String[] args) {
		Integer[] iarr={10,60,20,15,48,-5};
		bubblesort(iarr);
		display(iarr);
		
		student[] stu=new student[5];
		stu[0]=new student("puru", -100, -1);
		stu[1]=new student("modi",100,1);
		stu[2]=new student("kadi Ninda",11,600000);
		stu[3]=new student("AK47",10,12564);
		stu[4]=new student("Rahul",15,1154);
		
		bubblesort(stu,student.MarksComparator);
		display(stu);
		
		
		
	}

	public static <T> void display(T[] arr) {

		for (T val : arr) {
			System.out.print(val + ",");
		}
		System.out.println(".");
	}

	public static <T extends Comparable<T>> void bubblesort(T[] arr) {
		int count = 1;
		while (count < arr.length) {
			for (int i = 0; i < arr.length - count; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			count++;
		}
	}
	
	public static <T> void bubblesort(T[] arr,Comparator<T> comp) {
		int count = 1;
		while (count < arr.length) {
			for (int i = 0; i < arr.length - count; i++) {
				if (comp.compare(arr[i], arr[i+1])>0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			count++;
		}
	}

}
