package aug12a;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
//		HashMap<String, Integer> popmap = new HashMap<>();
//		
//		popmap.put("India", 120);
//		popmap.put("China", 200);
//		popmap.put("Pak", 80);
//		popmap.put("US", 20);
//		popmap.put("UK", 25);
//		
//		System.out.println(popmap);
//		
//		popmap.put("Sweden", 15);
//		System.out.println(popmap);
//		
//		popmap.put("US", 30);
//		System.out.println(popmap);
//		
//		System.out.println(popmap.get("US"));
//		System.out.println(popmap.get("Utopia"));
//		
//		System.out.println(popmap.containsKey("US"));
//		System.out.println(popmap.containsKey("Utopia"));
//		
//		System.out.println(popmap.remove("Pak"));
//		System.out.println(popmap);
//		
//		System.out.println(popmap.remove("Utopia"));
//		System.out.println(popmap);
//		
//		ArrayList<String> keys = new ArrayList<>(popmap.keySet());
//		System.out.println(keys);
		
//		System.out.println(highestFreqCharacter("aaabccbcbbcaaba"));
//		Integer[] one = {3, 1, 2, 2, 1, 5, 1};
//		Integer[] two = {5, 4, 2, 1, 2, 2, 1};
//		System.out.println(gce2(one, two));
		
		Integer[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
		System.out.println(longestConsecutiveSeq(arr));
	}
	
	public static Character highestFreqCharacter(String word){
		HashMap<Character, Integer> fm = new HashMap<>();
		
		for(int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			
			if(fm.containsKey(ch)){
				fm.put(ch, fm.get(ch) + 1);
			} else {
				fm.put(ch, 1);
			}
		}
		
		Integer mf = 0;
		Character mfc = ' ';
		
		ArrayList<Character> keys = new ArrayList<>(fm.keySet());
		for(int i = 0; i < keys.size(); i++){
			Character ch = keys.get(i);
			Integer freq = fm.get(ch);
			
			if(freq > mf){
				mf = freq;
				mfc = ch;
			}
		}
		
		return mfc;
	}

	public static ArrayList<Integer> gce1(Integer[] one, Integer[] two){
		ArrayList<Integer> rv = new ArrayList<>();
		HashMap<Integer, Integer> fm = new HashMap<>();
		
		for(Integer val: one){
			if(fm.containsKey(val)){
				fm.put(val, fm.get(val) + 1);
			} else {
				fm.put(val, 1);
			}
		}
		
		for(Integer val: two){
			if(fm.containsKey(val)){
				rv.add(val);
				fm.remove(val);
			}
		}
		
		return rv;
	}
	
	public static ArrayList<Integer> gce2(Integer[] one, Integer[] two){
		ArrayList<Integer> rv = new ArrayList<>();
		HashMap<Integer, Integer> fm = new HashMap<>();
		
		for(Integer val: one){
			if(fm.containsKey(val)){
				fm.put(val, fm.get(val) + 1);
			} else {
				fm.put(val, 1);
			}
		}
		
		for(Integer val: two){
			if(fm.containsKey(val)){
				rv.add(val);
				
				if(fm.get(val) > 1){
					fm.put(val, fm.get(val) - 1);
				} else {
					fm.remove(val);
				}
			}
		}
		
		return rv;
	}

	public static ArrayList<Integer> longestConsecutiveSeq(Integer[] arr){
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++){
			map.put(arr[i], true);
		}
		
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(arr[i] - 1)){
				map.put(arr[i], false);
			}
		}
		
		int maxSeqLength = 0;
		int maxSeqSP = -1;
		
		for(int i = 0; i < arr.length; i++){
			if(map.get(arr[i]) == true){
				int tempSeqLength = 1;
				int tempSeqSP = arr[i];
				
				while(map.containsKey(tempSeqSP + tempSeqLength) == true){
					tempSeqLength++;
				}
				
				if(tempSeqLength > maxSeqLength){
					maxSeqLength = tempSeqLength;
					maxSeqSP = tempSeqSP;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < maxSeqLength; i++){
			list.add(maxSeqSP + i);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	

}
