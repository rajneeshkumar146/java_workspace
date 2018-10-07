package june12;

public class TwodArrayDemos {

	public static void main(String[] args) {
		int[][] arr = null;
		
		// both dimensions provided
		System.out.println("***************************");
		arr = new int[4][3];
		
		System.out.println(arr);
		for(int row = 0; row < arr.length; row++){
			System.out.println(arr[row] + " => ");
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
		
		// jagged array
		arr = new int[4][];
		for(int row = 0; row < arr.length; row++){
			System.out.println(arr[row] + " => ");
		}
		
		arr[0] = new int[2];
		arr[1] = new int[4];
		arr[2] = new int[5];
		arr[3] = new int[3];
		
		for(int row = 0; row < arr.length; row++){
			System.out.println(arr[row] + " => ");
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}

}
