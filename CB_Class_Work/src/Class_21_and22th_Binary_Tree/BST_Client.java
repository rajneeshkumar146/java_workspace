package Class_21_and22th_Binary_Tree;

public class BST_Client {

	public static void main(String[] args) {
		int[] post = { 12, 30, 40, 37, 25, 60, 70, 62, 87, 75, 50 };
		int[] in = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		
		BST bst=new BST(post,in);
		
		bst.display();
        System.out.println(bst.size());
		System.out.println();
		
//		bst.remove(75);
//		bst.display();
//		System.out.println(bst.size());
		
		
//		bst.replaceWithSumOfLarerNode();
//		bst.display();
		
//		bst.pir(13, 40);
		
//		bst.removeAllLeaves();
//		bst.display();
		
//		bst.printWithoutSublings();
		bst.postOrder();
		
		System.out.println();
		System.out.println(bst.max());

	}

}
