package july23;

public class Client {

	public static void main(String[] args) {
		int[] sa = { 12, 25, 37, 50, 62, 75, 87 };
		BST bst = new BST(sa);
		// bst.display();
		// System.out.println(bst.max() + " " + bst.min());
		// bst.pir(39, 81);
		// bst.replaceWithSUmOfLarger();
		bst.add(30);
		bst.add(40);
		bst.add(60);
		bst.add(70);
		bst.add(10);
		bst.add(15);
		bst.display();
		bst.removeANode(25);
		System.out.println("--------------------");
		bst.display();
	}

}
