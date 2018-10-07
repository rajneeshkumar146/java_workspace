package june25;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();
//		
//		System.out.println("Contents = " + list);
//		System.out.println("Size = " + list.size());
//		
//		list.add(10);
//		list.add(20);
//		list.add(30);
//		
//		System.out.println("Contents = " + list);
//		System.out.println("Size = " + list.size());
//		
//		System.out.println(list.get(1)); // 0 to s - 1
//		list.set(1, 200); // 0 to s - 1
//		
//		System.out.println("Contents = " + list);
//		System.out.println("Size = " + list.size());
//		
//		list.add(1, 5); // 0 to s
//		
//		System.out.println("Contents = " + list);
//		System.out.println("Size = " + list.size());
//		
//		list.remove(1);
//		
//		System.out.println("Contents = " + list);
//		System.out.println("Size = " + list.size());
//		
//		ArrayList<String> slist = new ArrayList<>();
//		slist.add("Hello");
//		slist.add("World");
//		System.out.println(slist);
		
//		System.out.println(getSSWAscii("ab"));
		
//		int i = '5';
//		System.out.println(i - '0');
//		System.out.println(getKPC("245"));
		System.out.println(getBoardPaths(0, 10));
		
	}
	
	public static ArrayList<String> getSS(String str){
		if(str.equals("")){
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rres = getSS(ros);
		ArrayList<String> mres = new ArrayList<>();
		
		for(String rstr: rres){
			mres.add("_" + rstr); // ch says no
			mres.add(ch + rstr); // ch says yes
		}
		
		return mres;
	}
	
	public static ArrayList<String> getSSWAscii(String str){
		if(str.equals("")){
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rres = getSSWAscii(ros);
		ArrayList<String> mres = new ArrayList<>();
		
		for(String rstr: rres){
			mres.add("_" + rstr); // ch says no
			mres.add(ch + rstr); // ch says yes
			mres.add((int)ch + rstr); // ch says ascii
		}
		
		return mres;
	}
	
	static String[] codes = {".;", "abc", "def", "ghij", "kl", "mnop", "qrs", "tuv", "wx", "yz"};
	public static ArrayList<String> getKPC(String str){
		if(str.equals("")){
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rres = getKPC(ros);
		ArrayList<String> mres = new ArrayList<>();
		
		String code = codes[ch - '0'];
		for(String rstr: rres){
			for(int i = 0; i < code.length(); i++){
				mres.add(code.charAt(i) + rstr);
			}
		}
		
		return mres;
	}
	
	// reactive approach
	public static ArrayList<String> getBoardPaths(int s, int d){
		if(s == d){
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("\n");
			return bresult;
		}
		
		if(s > d){
			ArrayList<String> bresult = new ArrayList<>();
			return bresult;
		}
		
		ArrayList<String> pathsfromstod = new ArrayList<>();
		
		for(int dice = 1; dice <= 6; dice++){
			int inter = s + dice;
			ArrayList<String> pathsfromintertod = getBoardPaths(inter, d);
			
			for(String interpath: pathsfromintertod){
				String srcpath = dice + interpath;
				pathsfromstod.add(srcpath);
			}
		}
		
		return pathsfromstod;
	}
}
