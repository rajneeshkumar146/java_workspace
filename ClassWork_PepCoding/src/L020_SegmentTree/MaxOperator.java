package L020_SegmentTree;

public class MaxOperator implements ISegmentOperator {

	@Override
	public int operation(int n1, int n2) {
		// TODO Auto-generated method stub
		return Math.max(n1, n2);
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

}
