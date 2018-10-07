package july29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class HashMapClient {

	public static void main(String[] args) {
//		HashMap<String, Integer> popmap = new HashMap<>();
//		
//		popmap.put("India", 120);
//		popmap.put("China", 200);
//		popmap.put("Pak", 80);
//		popmap.put("US", 25);
//		popmap.put("UK", 20);
//		
//		System.out.println(popmap);
//
//		popmap.put("India", 125);
//		popmap.put("Nigeria", 50);
//		
//		System.out.println(popmap);
//		
//		System.out.println(popmap.get("India"));
//		System.out.println(popmap.get("Utopia"));
//		
//		System.out.println(popmap.containsKey("India"));
//		System.out.println(popmap.containsKey("Utopia"));
//		
//		System.out.println(popmap.remove("Pak"));
//		System.out.println(popmap.remove("Utopia"));
//		
//		System.out.println(popmap);
//		
//		ArrayList<String> keys = new ArrayList<>(popmap.keySet());
//		System.out.println(keys);
//		
//		ArrayList<Integer> values = new ArrayList<>(popmap.values());
//		System.out.println(values);
		
//		highestFreqChar("abbacbcbcadba");
//		
//		int[] one = {1, 1, 2, 2, 2, 3, 5};
//		int[] two = {1, 1, 1, 2, 2, 4, 5};
//		System.out.println(gce1(one, two));
//		System.out.println(gce2(one, two));
		int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
		System.out.println(lcnsSeq(arr));
	}
	
	public static Character highestFreqChar(String word){
		HashMap<Character, Integer> fm = new HashMap<>();
		
		for(int i = 0; i < word.length(); i++){
			Character ch = word.charAt(i);
			
			if(fm.containsKey(ch)){
				fm.put(ch, fm.get(ch) + 1);
			} else {
				fm.put(ch, 1);
			}
		}
		
		System.out.println(fm);
		
		ArrayList<Character> keys = new ArrayList<>(fm.keySet());
		Character maxc = ' ';
		Integer maxcf = 0;
		
		for(Character key: keys){
			if(fm.get(key) > maxcf){
				maxc = key;
				maxcf = fm.get(key);
			}
		}
		
		return maxc;
	}
	
	public static ArrayList<Integer> gce1(int[] one, int[] two){
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int val: one){
			if(map.containsKey(val)){
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int val: two){
			if(map.containsKey(val)){
				list.add(val);
				map.remove(val);
			}
		}
		
		return list;
	}
	
	public static ArrayList<Integer> gce2(int[] one, int[] two){
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int val: one){
			if(map.containsKey(val)){
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int val: two){
			if(map.containsKey(val)){
				list.add(val);
				
				if(map.get(val) > 1){
					map.put(val, map.get(val) - 1);
				} else {
					map.remove(val);
				}
			}
		}
		
		return list;
	}
	
	public static ArrayList<Integer> lcnsSeq(int[] arr){
		HashMap<Integer, Boolean> hm = new HashMap<>();
		
		for(int val: arr){
			hm.put(val, true);
		}
		
		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());
		for(int key: keys){
			if(hm.containsKey(key - 1)){
				hm.put(key, false);
			}
		}
		
		ArrayList<Integer> finalList = new ArrayList<>();
		
		for(int key: keys){
			if(hm.get(key) == true){
				ArrayList<Integer> tempList = new ArrayList<>();
				int count = 0;
				
				while(hm.containsKey(key + count) == true){
					tempList.add(key + count);
					count++;
				}
				
				if(tempList.size() > finalList.size()){
					finalList = tempList;
				}
			}
		}
		
		return finalList;
	}
	
	
	
	
	
	
	
	
	
	
	

}
