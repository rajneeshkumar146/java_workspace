package Class_32_SegmentTree;

public class client {

	public static void main(String[] args) {
		int[] arr = { 10, 2, -3, 7, 6, -4, 8, -2 };
		SegmentTreeInterface st = new SegmentTreeInterface(arr, new SegmentMaxOperator());
		System.out.println(st.query(2, 5));
		System.out.println(st.query(2, 6));

		st.update(3, -7);
		System.out.println(st.query(2, 5));
		System.out.println(st.query(2, 6));

	}
}
