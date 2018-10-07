package Class_21_and22th_Binary_Tree;

public class Client {

	public static void main(String[] args) {
		// 50 true 25 true 12 false false true 37 true 30 false false true 40
		// false false true 75 true 62 true 60 false false true 70 false false
		// true 87 false false
		// BinaryTree bt = new BinaryTree();
		// bt.display();
		// System.out.println(bt.size());
		//
		// System.out.println(bt.diameter2());
		//
		// bt.InOrderIrr();
		// System.out.println();
		// bt.preOrderIrr();
		// System.out.println();
		// bt.postOrderIrr();

		int[] pre = { 50, 25, 10, 37, 30, 40, 75, 62, 60, 70, 87 };
		// int[] post = { 12, 30, 40, 37, 25, 60, 70, 62, 87, 75, 50 };
		int[] in = { 10, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		//
		BinaryTree btn = new BinaryTree(pre, in);
		btn.display();
		// System.out.println();
//		 btn.kaway(3, 75);
		 btn.printPathtoTargetSum(75);

	}

}
