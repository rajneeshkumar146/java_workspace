package june16;

public class A4Q15 {

	public static void main(String[] args) {
		int[] arr = {7, 9, 2};
		
		int limit = (int)Math.pow(2, 3);
		int counter = 0;
		
		while(counter < limit){
			int temp = counter;
			
			System.out.print("[");
			for(int i = 0; i < arr.length; i++){
				int rem = temp % 2;
				
				if(rem == 1){
					System.out.print(arr[i] + " ");
				}
				
				temp = temp / 2;
			}
			System.out.println("]");
			
			counter++;
		}
	}
	
	

}
