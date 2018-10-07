package aug19;

public class ProductOperator implements ISegmentOperator {

	@Override
	public int operation(int left, int right) {
		return left * right;
	}

	@Override
	public int identity() {
		return 1;
	}

}
