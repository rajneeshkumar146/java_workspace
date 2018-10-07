package june16;

public class A4Q14 {

	public static void main(String[] args) {
		int[] one = {	9, 9, 9, 9};
		int[] two = {8, 9, 9, 9, 9};
		
		int[] sum = new int[one.length > two.length? 
							one.length + 1: 
							two.length + 1];
		int carry = 0;
		
		int i = one.length - 1;
		int j = two.length - 1;
		int k = sum.length - 1;
		
		while(k >= 0){
			int s = carry;
			
			if(i >= 0){
				s += one[i];
			}
			
			if(j >= 0){
				s += two[j];
			}
			
			sum[k] = s % 10;
			carry = s / 10;
			
			i--;
			j--;
			k--;
		}
		
		for(int ii = 0; ii < sum.length; ii++){
			if(ii == 0 && sum[ii]== 0){
				continue;
			}
			
			System.out.print(sum[ii] + "\t");
		}
		
	}

}
