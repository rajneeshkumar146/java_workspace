package june19;

public class MatrixMult {

	public static void main(String[] args) {
		int[][] one = {
				{1, 0, 5, 0},
				{2, 0, 0, 2}
		};
		
		int[][] two = {
				{10, 1, 1},
				{1, 10, 1},
				{1, 1, 10},
				{0, 0, 0}
		};
		multiply(one, two);
	}

	public static void display(int[][] mat){
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``");
	}
	
	private static void multiply(int[][] one, int[][] two){
		// check if they can be multplied, if not return by saying not possible
		int r1 = one.length;
		int c1 = one[0].length;
		int r2 = two.length;
		int c2 = two[0].length;
		
		int cd = r2;
		
		if(c1 != r2){
			System.out.println("Not possible");
			return;
		}
		
		// create the new matrix
		int[][] prd = new int[r1][c2];
		
		// populate data
		for(int i = 0; i < prd.length; i++){
			for(int j = 0; j < prd[0].length; j++){
				for(int k = 0; k < cd; k++){
					prd[i][j] = prd[i][j] + one[i][k] * two[k][j];
				}
			}
		}
		
		// display all 3 matrices
		display(one);
		display(two);
		display(prd);
	}
}
