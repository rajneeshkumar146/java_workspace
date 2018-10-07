package june18;

public class binarysearch {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int data = 900;
		
		int lo = 0;
		int hi = arr.length - 1;
		
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			
			if( data > arr[mid]){
				lo = mid + 1;
			} else if(data < arr[mid]){
				hi = mid - 1;
			} else {
				System.out.println(mid);
				return;
			}
		}
		
		System.out.println(-1);
	}

}
