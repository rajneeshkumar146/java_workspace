package june19;

public class Client {

	public static void main(String[] args) {
		int[] arr = {-5, 2, -1, 3, 6, -11, 8, 9, -10, 5, 6, -4, -5};
		kadanes(arr);
	}
	
	public static void kadanes(int[] arr){
		int csp = 0;
		int cep = 0;
		int csum = arr[0];
		
		int osp = 0;
		int oep = 0;
		int osum = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(csum > 0){
				csum += arr[i];
				cep = i;
			} else {
				csum = arr[i];
				csp = cep = i;
			}
			
			if(csum > osum){
				osum = csum;
				osp = csp;
				oep = cep;
			}
		}
		
		System.out.println(osum);
		for(int i = osp; i <= oep; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println(".");
	}

}
