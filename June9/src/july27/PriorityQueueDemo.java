package july27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
//		int[] arr = {2, 6, 1, 9, 0, 18};
//		printKLargestItems(arr, 3);
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//		
//		// nlogn
//		for(int val: arr){
//			pq.add(val);
//		}
//		
//		// nlogn
//		while(pq.size() > 0){
//			System.out.println(pq.remove());
//		}
		
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//		lists.add(new ArrayList<>(Arrays.asList(11, 15, 20, 25)));
//		lists.add(new ArrayList<>(Arrays.asList(5, 7, 14)));
//		lists.add(new ArrayList<>(Arrays.asList(8, 12, 16, 24, 32)));
//		lists.add(new ArrayList<>(Arrays.asList(30, 40)));
//		mergeKSortedLists(lists);
		
		int[] arr = {30, 10, 22, 40, 55, 60, 50, 70};
		sortAlmostSorted(arr, 2);
	}
	
	public static void printKLargestItems(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < arr.length; i++){
			if(i < k){
				pq.add(arr[i]);
			} else {
				if(arr[i] > pq.peek()){
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		
		System.out.println(pq);
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
		// space ok, time nlogk
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < lists.size(); i++){
			Pair p = new Pair(i, 0, lists.get(i).get(0));
			pq.add(p);
		}
		
		while(pq.size() > 0){
			Pair rp = pq.remove();
			System.out.print(rp.value + " ");
			
			rp.dataidx++;
			if(rp.dataidx < lists.get(rp.listidx).size()){
				rp.value = lists.get(rp.listidx).get(rp.dataidx);
				pq.add(rp);
			}
		}
	}
	
	private static class Pair implements Comparable<Pair>{
		int listidx;
		int dataidx;
		int value;
		
		Pair(int listidx, int dataidx, int value){
			this.listidx = listidx;
			this.dataidx = dataidx;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}

		
	}
	
	public static void sortAlmostSorted(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; true; i++){
			if(i < k + 1){
				pq.add(arr[i]);
			} else if(i < arr.length){
				System.out.println(pq.remove());
				pq.add(arr[i]);
			} else if(pq.size() > 0){
				System.out.println(pq.remove());
			} else {
				break;
			}
		}
	}
}
