package Class_8th_Recursion;

public class Practice {

	public static void main(String[] args) {
		// int[] arr = { 5, 3, 2, 1, 9, 7, 8 };
		// int[] arr={-5,-3,-10,-9,-7,-8};
		int[] arr = { 7, 3, 7, 6, 7, 4, 7, 4, 7 };
		// increasing(5);
		// decreasing(5);
		// incre_and_decre(5);
		// System.out.println(fact(6));
		// odd_even(5);
		// arr_print(arr,0);
		// arr_rev_print(arr,0);
		// System.out.println(max(arr,0));
		// System.out.println(find(arr, 0, 5));
		// System.out.println(firstindex(arr, 0, 4));
		//System.out.println(lastindex(arr, 0, 4));
         /* arr=allindices(arr,0,7,0);
          arr_print(arr,0);*/
		//star_column(0,5);
		//star_row(0,5);
		//star_box(0,0,5);
		//star_triangle(0,0,5);
		star_rev_triangle(0,0,5);
	}

	public static void increasing(int n) {
		if (n == 0) {
			return;
		}

		increasing(n - 1);
		System.out.println(n);
		return;

	}

	public static void decreasing(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		decreasing(n - 1);
	}

	public static void incre_and_decre(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		incre_and_decre(n - 1);
		System.out.println(n);

	}

	public static int fact(int n) {
		if (n == 1) {
			return 1;
		}

		int resu = n * fact(n - 1);
		return resu;
	}

	public static void odd_even(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 != 0) {
			System.out.println(n);
		}
		odd_even(n - 1);
		if (n % 2 == 0) {
			System.out.println(n);
		}

	}

	public static void arr_print(int[] arr, int vidx) { // vidx=vertual index
		if (vidx == arr.length) {
			return;
		}

		System.out.print(arr[vidx]+ "\t");
		arr_print(arr, vidx + 1);
	}

	public static void arr_rev_print(int[] arr, int vidx) { // vidx=vertual
															// index
		if (vidx == arr.length) {
			return;
		}
		arr_rev_print(arr, vidx + 1);
		System.out.print
		(arr[vidx]+ "\t");
	}

	public static int max(int[] arr, int vidx) { // vidx=vertual index
		if (vidx == (arr.length - 1)) {
			return arr[vidx];
		}

		int res = max(arr, vidx + 1); // res=result
		if (arr[vidx] > res) {
			return arr[vidx];
		} else {
			return res;
		}

	}

	public static boolean find(int[] arr, int vidx, int data) { // vidx=vertualindex

		if (vidx == arr.length) {
			return false;
		}
		boolean res = find(arr, vidx + 1, data); // res=result
		if (res == true) {
			return true;
		} else if (arr[vidx] == data) {
			return true;

		} else {
			return false;
		}

	}

	public static int firstindex(int[] arr, int vidx, int data) { // vidx=vertuindex
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data) {
			return vidx;
		}
		int res = firstindex(arr, vidx + 1, data); // res=result

		return res;

	}

	public static int lastindex(int[] arr, int vidx, int data) { // vidx=vertuindex
		if (vidx == arr.length) {
			return -1;
		}

		int res = lastindex(arr, vidx + 1, data); // res=result
		if (res == -1) {
			if (arr[vidx] == data) {
				return vidx;
			}
		}
		
		return res;

	}

	public static int[] allindices(int[] arr, int vidx, int data, int count){ // vidx=vertuindex
		if(vidx==arr.length){
			 int[] new_arr=new int[count];
			 return new_arr;
		}
		if(arr[vidx]==data){
			int[] new_arr=allindices(arr,vidx+1,data,count+1);
			new_arr[count]=vidx;
			return new_arr;
		}
		else{
			int[] new_arr=allindices(arr,vidx+1,data,count);
			return new_arr;
		}
	}

	public static void star_column(int col, int col_end){
		if(col==col_end){
			return;
		}
		
		star_column(col+1,col_end);
		System.out.print("*");
		
	}
	
	public static void star_row(int row,int row_end){
		if(row==row_end){
			return;
		}
		
		star_row(row+1,row_end);
		System.out.println("*");
		
	}

    public static void star_box(int row,int col,int end_stage){
    	if(row==end_stage){
    		return;
    	}
    	
    	if(col==end_stage){
    		star_box(row+1,0,end_stage);
    		if(row<end_stage-1){
    		System.out.println();
    		}
    		return;
    	}
    	
    	star_box(row,col+1,end_stage);
    	System.out.print("*");
    	
    	
    }

    public static void star_triangle(int row,int col,int end_stage){
    	if(row==end_stage){
    		return;
    	}
    	
    	if(col>row){
    		System.out.println();
    		star_triangle(row+1,0,end_stage);	
    		return;
    	}
    	System.out.print("*");
    	star_triangle(row,col+1,end_stage);
    	
    	
    	
    }
    
    public static void star_rev_triangle(int row,int col,int end_stage){
    	if(row==end_stage){
    		return;
    	}
    	
    	if(col>row){
    		
    		star_rev_triangle(row+1,0,end_stage);	
    		if(row<end_stage-1){
        		System.out.println();
        		}
    		return;
    	}
    
    	star_rev_triangle(row,col+1,end_stage);
    	System.out.print("*");
    	
    	
    	
    }
    
    
}
