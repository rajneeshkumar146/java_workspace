package aug6;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class HMNode {
		K key;
		V value;
	}

	private LinkedList<HMNode>[] buckets; // N
	private int size = 0; // n

	public HashMap() {
		buckets = new LinkedList[4];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			HMNode n2add = new HMNode();
			n2add.key = key;
			n2add.value = value;
			buckets[bi].addLast(n2add);
			this.size++;
		} else {
			HMNode n2update = buckets[bi].getAt(foundAt);
			n2update.value = value;
		}
		
		double lambda = (this.size * 1.0) / this.buckets.length;
		if(lambda > 2.0){
			rehash();
		}
	}



	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			return null;
		} else {
			HMNode n2r = buckets[bi].getAt(foundAt);
			return n2r.value;
		}
	}

	public V remove(K key) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			return null;
		} else {
			HMNode n2r = buckets[bi].removeAt(foundAt);
			this.size--;
			return n2r.value;
		}
	}

	public boolean containsKey(K key) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<K> keyset() throws Exception {
		ArrayList<K> rv = new ArrayList<>();
		
		for(int i = 0; i < buckets.length; i++){
			for(int j = 0; j < buckets[i].size(); j++){
				HMNode node = buckets[i].getAt(j);
				rv.add(node.key);
			}
		}
		
		return rv;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() throws Exception {
		System.out.println("-----------------------------------------------------");
		for(int i = 0; i < buckets.length; i++){
			String str = "BUCKET " + i + " => ";
			for(int j = 0; j < buckets[i].size(); j++){
				HMNode node = buckets[i].getAt(j);
				str += "[" + node.key + "@" + node.value + "], ";
			}
			System.out.println(str + ".");
		}
		System.out.println("-----------------------------------------------------");
	}

	private int hashFunction(K key) {
		int hc = key.hashCode(); // pending discussion

		hc = Math.abs(hc);
		int bi = hc % buckets.length;

		return bi;
	}

	private int findInBucket(LinkedList<HMNode> list, K key) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			HMNode node = list.getAt(i);
			if (node.key.equals(key)) {
				return i;
			}
		}

		return -1;
	}

	private void rehash() throws Exception {
		LinkedList<HMNode>[] oba = this.buckets;
		
		// ctor
		buckets = new LinkedList[2 * oba.length];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		size = 0;
		
		// loop
		for(int i = 0; i < oba.length; i++){
			for(int j = 0; j < oba[i].size(); j++){
				HMNode node = oba[i].getAt(j);
				put(node.key, node.value);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
