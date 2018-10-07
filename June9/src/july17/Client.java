package july17;

import java.util.LinkedList;

public class Client {

	public static void main(String[] args) {
		
		int[] arr = {50, 25, 12, 10, -1, 20, -1, -1, 37, 30, -1, 40, -1, -1, -1, 75,
				62, 60, -1, 70, -1, -1, 87, 80, -1, 90, -1, -1, -1, -1};

//		int[] preo = {50, 25, 12, 37, 30, 40, 62, 60, 70, 87};
//		int[] posto = {12, 30, 40, 37, 25, 60, 70, 62, 87, 75, 50};
//		int[] ino = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
		
		BinaryTree bt = new BinaryTree(arr);
		bt.lca(20, 40);
//		bt.preo();
//		bt.traversalIterative();
//		bt.posto();
//		bt.ino();
		
		bt.display();
		System.out.println(bt.isBST());
		
		
//		int[] arr = {1, 'a', 'b', 'd', '@', -1, -1, 'e', 'i', 'y', -1, 'z', 
//					 -1, -1, 'j', 'k', 'm', 't', 'u', 11, -1, -1, 'v', 
//					 10, -1, -1, -1, -1, 'n', 'r', -1, 's', 'w', 9, -1, -1,
//					 'x', 7, -1, 8, -1, -1, -1, -1, -1, 'l', 'o', 'p', -1,
//					 'q', -1, -1, -1, -1, -1, -1, 'c', 'f', -1, 'g', -1, -1,
//					 -1, 2, 3, -1, 4, 5, -1, 6, -1, -1, -1, -1};
//		BinaryTree bt = new BinaryTree(arr);
//		bt.display();
//		
//		System.out.println(bt.nodeToRootPath(40));
//		bt.printRootToLeafPathsInRange(150, 250);
//		bt.printStepsFar('k', 4);
//		bt.levelOrder();
//		System.out.println("---------------------");
//		printBinaries(15);
		
		System.out.println(bt.diameter());
		System.out.println(bt.diameter2());
	}

	public static void printBinaries(int n){
		LinkedList<BinaryNode> queue = new LinkedList<>();
		queue.addLast(new BinaryNode(1, "1"));
		
		for(int i = 0; i <n; i++){
			BinaryNode rem = queue.removeFirst();
			System.out.println(rem.data + " " + rem.binary);
			
			queue.addLast(new BinaryNode(2 * rem.data, rem.binary + "0"));
			queue.addLast(new BinaryNode(2 * rem.data + 1, rem.binary + "1"));
		}
	}
	
	private static class BinaryNode{
		int data;
		String binary;
		
		public BinaryNode(int data, String binary) {
			this.data = data;
			this.binary = binary;
		}
	}
}
