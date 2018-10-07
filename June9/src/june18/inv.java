package june18;

public class inv {

	public static void main(String[] args) {
		int[] arr = {3, 0, 1, 4, 2};
		int[] inv = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			int val = arr[i];
			inv[val] = i;
		}
		
		ArrayUtils.display(inv);
	}

}
