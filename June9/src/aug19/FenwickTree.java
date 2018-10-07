package aug19;

public class FenwickTree {
	int[] farr;
	public FenwickTree(int[] oarr){
		this.farr = new int[oarr.length + 1];
		// storage
		for(int i = 0; i < oarr.length; i++){
			update(i, oarr[i]);
		}
	}
	
	public int query(int qsi, int qei){
		return getPrefixSum(qei) - getPrefixSum(qsi - 1);
	}
	
	private int getPrefixSum(int idx){
		idx++; // converting idces to positions
		
		int sum = 0;
		while(idx > 0){
			sum += farr[idx];
			idx -= rsb(idx);
		}
		return sum;
	}

	public void update(int idx, int delta){
		idx++; // position
		
		while(idx < farr.length){
			farr[idx] += delta;
			idx += rsb(idx);
		}
	}
	
	private int rsb(int x){
		return x & -x;
	}
}
