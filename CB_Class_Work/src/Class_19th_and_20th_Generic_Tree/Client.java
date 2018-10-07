package Class_19th_and_20th_Generic_Tree;

public class Client {

	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 0 30 3 70 1 110 0 80 0 90 0 40 1 100 0
		GenericTree gt = new GenericTree();
		gt.display();
		// System.out.println(gt.size2());
		// System.out.println(gt.max());
		// System.out.println(gt.height());

		// System.out.println();
		// gt.mirrorimage();
		// gt.display();
		// System.out.println();
		// gt.mirrorimage();
		// gt.display();

		// gt.printAtDepth(1);
		// System.out.println();

		// gt.predisplay();
		// System.out.println();
		// gt.postdisplay();

		// gt.levelOderDisplay();
		// System.out.println();
		// gt.levelOderLinerwise();

		// System.out.println();
		// gt.multisolver(10);
		//
		 System.out.println();
		 System.out.println(gt.kthsmallest(3));
		//
		// System.out.println();
		// gt.removeLeaves();
		// gt.display();
		//

		// gt.linearize();
		// gt.display();

		// System.out.println();
		// gt.linearizeBtr();
		// gt.display();

		gt.flatten();
		gt.display();

		// gt.flattenBtr();
		// gt.display();

		// GenericTree gt2 = new GenericTree();
		// System.out.println(gt.isomorphic(gt2));
		// System.out.println(gt.ismirroriso());
	}

}
