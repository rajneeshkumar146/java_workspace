package july29;

public class Client {

	public static void main(String[] args) {
		// 10 5 400 0 20 2 50 0 60 0 30 3 70 2 110 0 120 0 80 0 90 2 140 0 150 0 40 1 100 0 500 0
		GenericTree gt = new GenericTree();
		gt.display();
		gt.removeLeaves();
		gt.display();
	}

}
