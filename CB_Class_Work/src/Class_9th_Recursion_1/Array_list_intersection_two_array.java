package Class_9th_Recursion_1;

import java.util.ArrayList;

public class Array_list_intersection_two_array {

	public static void main(String[] args) {
		Integer[] one = { 1, 1, 2, 2, 2, 3, 5 };
		bubble_sort(one);
		Integer[] two = { 1, 1, 1, 2, 2, 4, 5 };
		bubble_sort(two);

		ArrayList<Integer> inter = getIntersection(one, two);
		System.out.println(inter);

	}
	
	public static void bubble_sort(Integer[] arr){
		for(int count=1;count<arr.length;count++){
			for(int i=0;i<arr.length-count;i++){
				if(arr[i]>arr[i+1]){
					swap(arr,i,i+1);
				}
				
			}
		}
	}
	
	public static void swap(Integer[] arr,int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		
	}
	

	public static ArrayList<Integer> getIntersection(Integer[] one, Integer[] two) {

		ArrayList<Integer> list = new ArrayList<>();
		int i=0;
		int j=0;
		while(i<one.length&&j<two.length)
		{
			if(one[i]==two[j]){
				list.add(one[i]);
				i++;
				j++;
			}
			else if(one[i]<two[j]){
				i++;
			}
			else{
				j++;
				
			}
		}
		return list;
	}

}
