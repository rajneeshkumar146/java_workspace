package july12;

public class Client {

	public static void main(String[] args) {
		int[] one = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		GenericTree gt1 = new GenericTree(one);
		int[] two = {100, 200, 500, -1, 600, -1, -1, 300, 700, -1, 800, 1200, -1, -1, 900, -1, -1, 400, 1000, -1, -1, -1};
		GenericTree gt2 = new GenericTree(two);
		System.out.println(gt1.isIsomorphic(gt2));
//		GenericTree gt = new GenericTree(arr);
//		gt.display();
//		System.out.println(gt.size());
//		System.out.println(gt.max());
//		System.out.println(gt.height());
//		
//		System.out.println("---------------------");
//		gt.mirror();
//		gt.removeLeaves();
//		gt.linearize();
//		gt.levelorderLW();
//		gt.levelorderLWZZ();
//		gt.multisolver(5);
//		System.out.println(gt.kthLargest(12));
//		System.out.println(gt.serialize());
		
//		gt.display();
	}

}
