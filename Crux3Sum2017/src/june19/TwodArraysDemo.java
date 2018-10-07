package june19;

public class TwodArraysDemo {

	public static void main(String[] args) {
		int[][] arr;
		
		arr = new int[4][3];
		
		System.out.println(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
		
		int[][] scut = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44},
				{51, 52, 53, 54}
		};
		
		for(int row = 0; row < scut.length; row++){
			for(int col = 0; col < scut[row].length; col++){
				System.out.print(scut[row][col] + "\t");
			}
			System.out.println();
		}
		
		// jagged
		int[][] jagged = new int[3][];
				
		jagged[0] = new int[4];
		jagged[1] = new int[2];
		jagged[2] = new int[5];
				
		for(int row = 0; row < jagged.length; row++){
			for(int col = 0; col < jagged[row].length; col++){
				System.out.print(jagged[row][col] + "\t");
			}
			System.out.println();
		}		
				
				
				
	}

}
