package Extra;

public class FenwickTree {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 2, -5, 4, -6, -2, -5, 8, 9 };
		FenwickTree ft = new FenwickTree(arr);
		System.out.println(ft.getSum(7));
		ft.update(2, 5);
		ft.update(5, 7);
	}

	private int[] arr;
	private int[] oarr;

	private FenwickTree(int[] arr) {
		this.arr = new int[arr.length + 1];
		this.oarr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			this.update(i, arr[i]);
		}
	}

	public int getsum(int i, int j) {
		return getSum(j) - getSum(i - 1);
	}

	public int getSum(int i) {
		int pos = i + 1;
		int sum = 0;

		while (pos != 0) {
			sum += this.arr[pos];
			int lsbofpos = getLastbitof(pos);
			pos -= lsbofpos;
		}

		return sum;
	}

	public void update(int i, int delta) {
		int pos = i + 1;

		while (pos < this.arr.length) {
			this.arr[pos] += delta;
			int lsbofpos = getLastbitof(pos);
			pos += lsbofpos;
		}

		this.oarr[i] += delta;

	}

	public int getLastbitof(int pos) {
		return pos & -pos;
	}

}
