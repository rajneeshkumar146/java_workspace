package aug10;

public class Client {

	public static void main(String[] args) {
		int[] sa = {12, 25, 37, 50, 62, 75, 87};
		BST bst = new BST(sa);
		
		bst.display();
		System.out.println(bst.max());
		System.out.println(bst.min());
		System.out.println(bst.find(37));
//		
//		bst.rwsol();
//		bst.display();
		
//		bst.pir(27,  63);
		
		bst.add(90);
		bst.add(56);
		bst.add(65);
		
		System.out.println("----------------------------------");
		bst.display();
		
	}

}
