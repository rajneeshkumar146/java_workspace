package Class_25th_Trie;

public class ClientTrie {

	public static void main(String[] args) {
		
		Trie tr=new Trie();
		
		tr.addWord("art");
		tr.addWord("arc");
		tr.addWord("and");
		tr.addWord("ant");
		tr.addWord("an");
		tr.addWord("bug");
		tr.addWord("bugs");
		tr.addWord("sea");
		tr.addWord("see");
		tr.addWord("seen");
		
		System.out.println(tr.searchWord("art"));
		System.out.println(tr.searchWord("ant"));
		
		tr.dispaly();
		
		tr.removeWord("art");
		System.out.println();
		tr.dispaly();

	}

}
