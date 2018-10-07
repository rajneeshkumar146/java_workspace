package july23;

public class AVLClient {

	public static void main(String[] args) {
		int[] sa = {12, 25, 37, 50, 62, 75, 87};
		AVL avl = new AVL(sa);
//		avl.display();
		avl.add(10);
		avl.add(20);
		avl.add(30);
		avl.add(40);
		avl.add(60);
		avl.add(70);
		avl.add(80);
		avl.add(90);
		
		avl.display();
		System.out.println(avl.lca(30, 40));
	}

}
