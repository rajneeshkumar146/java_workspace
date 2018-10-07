package june18;

public class reverse {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.takeInput();
		ArrayUtils.display(arr);
		
		// reverse the array logic starts here
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right){
			ArrayUtils.swap(arr, left, right);
			left++;
			right--;
		}
		
		// reverse the array logic ends here
		
		ArrayUtils.display(arr);
	}

}
