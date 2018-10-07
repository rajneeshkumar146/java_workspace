package Class_32_SegmentTree;

public class SegmentMaxOperator implements ISegmentOperator {

	@Override
	public int operation(int n1, int n2) {
		return Math.max(n1, n2);

	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE;
	}

}
