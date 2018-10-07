package BinaryTree.Lowest_Common_Ancestor;

public class Client {

	public static void main(String[] args) {
		/*
50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false
		 */

		// Q01_Lowest_Common_Ancestor bt=new Q01_Lowest_Common_Ancestor();
		// bt.ancestor(62, 520);

//		Q04Print_common_nodes_on_path_from_common_ancestors bt = new Q04Print_common_nodes_on_path_from_common_ancestors();
//		bt.printPath(62, 60);

		Q02_Find_distance_between_two_nodes bt = new Q02_Find_distance_between_two_nodes();
		bt.distanceBetween(87, 60);
	}

}
