package Class_15th_MCM_knapsack_SOE;

public class Knapsack {

	public static void main(String[] args) {

		int[] price = {10,15,20,5,8};
		int[] wts={20,15,15,5,8};
		
		System.out.println(knapsack2(wts, price, 0, 50,0,0));

		System.out.println(knapsack1(wts, price, 0, 50));
		
		
		System.out.println(knapsackdp(wts, price, 0, 50,new int[wts.length+1][51]));

	}

	public static int knapsack2(int[] wts, int[] price, int vidx, int capacity, int wtssf, int pricesf1) { // wtssf=weght_so_far
		if (vidx == wts.length) {	
			return pricesf1;
		}
		int stay=0;
			int leave = knapsack2(wts, price, vidx + 1, capacity, wtssf, pricesf1);
			if (wtssf+wts[vidx] <= capacity) {
				stay=knapsack2(wts, price, vidx + 1, capacity, wtssf + wts[vidx], pricesf1 + price[vidx]);
				
			}

		
		return Math.max(leave, stay);
	}
	
	public static int knapsack1(int[] wts, int[] price, int vidx, int capacity) {
		if(vidx==wts.length){
			return 0;
		}
		
		int stay=0;
		
		if (capacity>=wts[vidx]) {
			stay=price[vidx]+knapsack1(wts, price, vidx + 1, capacity-wts[vidx]);
		}
		int leave = knapsack1(wts, price, vidx + 1, capacity);
		
		return Math.max(leave, stay);
	}
	
	public static int knapsackdp(int[] wts, int[] price, int vidx, int capacity,int[][] strg) {
		if(vidx==wts.length){
			return 0;
		}
		
		if(strg[vidx][capacity]!=0){
			return strg[vidx][capacity];
		}
		
		int stay_val=0;
		
		if (capacity>=wts[vidx]) {
			stay_val=price[vidx]+knapsackdp(wts, price, vidx + 1, capacity-wts[vidx],strg);
		}
		int leave_val = knapsackdp(wts, price, vidx + 1, capacity,strg);
		
		int result=Math.max(leave_val, stay_val);
		strg[vidx][capacity]=result;
		return result;
	}

}
