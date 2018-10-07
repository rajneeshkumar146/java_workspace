package aug19;

public class MinOperator implements ISegmentOperator {

	@Override
	public int operation(int left, int right) {
		return Math.min(left, right);
	}

	@Override
	public int identity() {
		return Integer.MAX_VALUE;
	}

}
