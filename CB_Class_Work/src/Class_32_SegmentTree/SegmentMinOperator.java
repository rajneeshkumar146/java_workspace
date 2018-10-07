package Class_32_SegmentTree;

public class SegmentMinOperator implements ISegmentOperator{

	@Override
	public int operation(int n1, int n2) {
		// TODO Auto-generated method stub
		return Math.min(n1, n2);
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

}