package july30;

public class HeapClient {

	public static void main(String[] args) {
//		int[] arr = {2, 9, 14, 19, 28, 7, 5, 11, -1};
//		Heap heap = new Heap(true, arr);
//		
//		while(heap.size() > 0){
//			System.out.println(heap.remove());
//		}
		
		int[] arr = {2, 9, 14, 19, 28, 7, 5, 11, -1};
		heapsort(arr);
		for(int val: arr){
			System.out.println(val);
		}
	}

	public static void heapsort(int[] arr){
		for(int i = arr.length - 1; i >= 0; i--){
			downheapify(arr, i, arr.length);
		}
		
		for(int i = arr.length - 1; i >= 0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			downheapify(arr, 0, i);
		}
	}
	
	public static void downheapify(int[] arr, int pi, int vep){
		int maxi = pi;

		int lci = 2 * pi + 1;
		if (lci < vep && arr[lci] > arr[maxi]) {
			maxi = lci;
		}

		int rci = 2 * pi + 2;
		if (rci < vep && arr[rci] > arr[maxi]) {
			maxi = rci;
		}

		if (pi != maxi) {
			int temp = arr[pi];
			arr[pi] = arr[maxi];
			arr[maxi] = temp;
			
			downheapify(arr, maxi, vep);
		}
	}
}
