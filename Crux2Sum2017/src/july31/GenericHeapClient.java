package july31;

import java.util.ArrayList;

public class GenericHeapClient {

	public static void main(String[] args) {
		GenericHeap<Student> heap = new GenericHeap<>(Student.NameComparator);
		
		Student[] students = new Student[7];
		students[0] = new Student("Modi", 100, 1);
		students[1] = new Student("Rahul", 0, Integer.MAX_VALUE);
		students[2] = new Student("Kejri", 10, 10);
		students[3] = new Student("ABC", 50, 50);
		students[4] = new Student("DEF", 60, 40);
		students[5] = new Student("GHI", 70, 30);
		students[6] = new Student("JKL", 80, 20);
		
		heap.add(students[0]);
		heap.add(students[1]);
		heap.add(students[2]);
		heap.add(students[3]);
		heap.add(students[4]);
		heap.add(students[5]);
		heap.add(students[6]);
		
		heap.display();
		while(!heap.isEmpty()){
			System.out.println(heap.removeHP());
		}
	}
	
	public static ArrayList<Integer> mergeKSortedArrayLists(ArrayList<ArrayList<Integer>> lists){
		
	}
	
	

}
