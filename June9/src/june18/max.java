package june18;

public class max {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.takeInput();
		ArrayUtils.display(arr);
		
		// logic to calculate max
		int max = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		
		System.out.println(max);
		
	}

}
