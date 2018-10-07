package july31;

public class TwoArraysOps {

	public static void main(String[] args) {
		int[][] one = {{10, 0, 20, 0}, {0, 30, 0, 40}};
		int[][] two = {{1, 0, 2}, {0, 0, 0}, {2, 3, 1}, {0, 1, 4}};
		
		int[][] result = matrixmultiply(one, two);
		display(one);
		display(two);
		display(result);
	}
	
	public static void display(int[][] arr){
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[0].length; col++){
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}
	
	public static int[][] matrixmultiply(int[][] one, int[][] two){
		// if product is not possible return null;
		int or = one.length;
		int oc = one[0].length;
		int tr = two.length;
		int tc = two[0].length;
		
		if(oc != tr){
			return null;
		} else {
			int cd = oc;
			int[][] prdct = new int[or][tc];
			
			for(int row = 0; row < prdct.length; row++){
				for(int col = 0; col < prdct[0].length; col++){
					int sum = 0;
					
					for(int k = 0; k < cd; k++){
						sum = sum + one[row][k] * two[k][col];
					}
					
					prdct[row][col] = sum;
				}
				System.out.println();
			}
			
			return prdct;
		}
	}

	public static void exitPoint(int[][] arr){
		
	}
}
