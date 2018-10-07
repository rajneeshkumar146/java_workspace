package june19;

public class TwodArrayOps {

	public static void main(String[] args) {
//		int[][] one = {
//				{0, 1, 1, 0},
//				{10, 0, 5, 0}
//		};
//		int[][] two = {
//				{15, 0, 8},
//				{9, 10, 6},
//				{20, 40, 2},
//				{3, 10, 100}
//		};
//
//		int[][] prd = matrixMultiply(one, two);
//		display(one);
//		display(two);
//		display(prd);
//		int[][] maze = {
//				{0, 0, 1, 0},
//				{1, 0, 0, 0},
//				{0, 0, 0, 0},
//				{1, 0, 1, 0}
//		};
//		exitPoint(maze);
		int[][] arr = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44}
		};
		display(arr);
		spiral(arr);
	}

	public static void display(int[][] arr) {
		if (arr == null) {
			System.out.println("NULL");
			return;
		}
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
	}

	public static int[][] matrixMultiply(int[][] one, int[][] two) {
		int r1 = one.length;
		int c1 = one[0].length;
		int r2 = two.length;
		int c2 = two[0].length;

		if (c1 != r2) {
			return null;
		}
		
		int[][] result = new int[r1][c2];
		
		for(int row = 0; row < result.length; row++){
			for(int col = 0; col < result[0].length; col++){
				int sum = 0;
				
				for(int i = 0; i < c1; i++){
					sum = sum + one[row][i] * two[i][col];
				}
				
				result[row][col] = sum;
			}
		}
		
		return result;
	}

	public static void exitPoint(int[][] arr){
		int dir = 0, row = 0, col = 0;
		// 0 for east, 1 for south, 2 for west, 3 for north
		
		while(true){
			dir = (dir + arr[row][col]) % 4;
			
			if(dir == 0){
				col++;
				
				if(col == arr[0].length){
					col--;
					System.out.println(row + ", " + col);
					break;
				}
			} else if(dir == 1){
				row++;
				
				if(row == arr.length){
					row--;
					System.out.println(row + ", " + col);
					break;
				}
			} else if(dir == 2){
				col--;
				
				if(col == -1){
					col++;
					System.out.println(row + ", " + col);
					break;
				}
			} else if(dir == 3){
				row--;
				
				if(row == -1){
					row++;
					System.out.println(row + ", " + col);
					break;
				}
			}
		}
		
	}

	public static void wave(int[][] arr){
		for(int col = 0; col < arr[0].length; col++){
			if(col % 2 == 0){
				for(int row = 0; row < arr.length; row++){
					System.out.println(arr[row][col]);
				}
			} else {
				for(int row = arr.length - 1; row >= 0; row--){
					System.out.println(arr[row][col]);
				}
			}
		}
	}
	
	public static void spiral(int[][] arr){
		int cmin = 0, rmin = 0;
		int cmax = arr[0].length - 1, rmax = arr.length - 1;
		
		int counter = 1;
		int tne = arr.length * arr[0].length;
		while(counter <= tne){
			// left
			for(int row = rmin; counter <= tne && row <= rmax; row++){
				System.out.println(arr[row][cmin]);
				counter++;
			}
			cmin++;
			
			// bottom
			for(int col = cmin; counter <= tne && col <= cmax; col++){
				System.out.println(arr[rmax][col]);
				counter++;
			}
			rmax--;
			
			// right
			for(int row = rmax; counter <= tne && row >= rmin; row--){
				System.out.println(arr[row][cmax]);
				counter++;
			}
			cmax--;
			
			// top
			for(int col = cmax; counter <= tne && col >= cmin; col--){
				System.out.println(arr[rmin][col]);
				counter++;
			}
			rmin++;
		}
	}
}
