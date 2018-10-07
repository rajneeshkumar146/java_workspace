package aug19;

public class MaxOperator implements ISegmentOperator {

	@Override
	public int operation(int left, int right) {
		return Math.max(left, right);
	}

	@Override
	public int identity() {
		return Integer.MIN_VALUE;
	}

}
