package june19;

public class TwodDemo {

	public static void main(String[] args) {
		int[][] arr = new int[2][4];
		
		// rows
		System.out.println(arr.length);
		
		// columns
		System.out.println(arr[0].length);
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		System.out.println(arr[0][0]);
	}

}
