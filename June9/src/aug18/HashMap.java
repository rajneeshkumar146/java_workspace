package aug18;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class HMNode {
		K key;
		V value;

		HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<HMNode>[] buckets; // N
	private int size = 0; // n

	public HashMap() {
		buckets = new LinkedList[4];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public boolean containsKey(K key) {
		int bi = hashFn(key);

		LinkedList<HMNode> bucket = buckets[bi];
		int di = findInBucket(bucket, key);
		if (di == -1) {
			return false;
		} else {
			return true;
		}
	}

	public V get(K key) {
		int bi = hashFn(key);

		LinkedList<HMNode> bucket = buckets[bi];
		int di = findInBucket(bucket, key);
		if (di == -1) {
			return null;
		} else {
			return bucket.getAt(di).value;
		}
	}

	public V remove(K key) {
		int bi = hashFn(key);

		LinkedList<HMNode> bucket = buckets[bi];
		int di = findInBucket(bucket, key);
		if (di == -1) {
			return null;
		} else {
			this.size--;
			return bucket.removeAt(di).value;
		}
	}

	public void put(K key, V value) {
		int bi = hashFn(key);

		LinkedList<HMNode> bucket = buckets[bi];
		int di = findInBucket(bucket, key);
		if (di == -1) {
			HMNode n2add = new HMNode(key, value);
			buckets[bi].addLast(n2add);
			this.size++;
		} else {
			HMNode n2u = buckets[bi].getAt(di);
			n2u.value = value;
		}
		
		double lambda = this.size * 1.0 / buckets.length;
		if(lambda > 2.0){
			rehash();
		}
	}

	private void rehash() {
		LinkedList<HMNode>[] oba = buckets;
		
		// ctor - with twice size
		buckets = new LinkedList[oba.length * 2];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		
		this.size = 0;
		
		// loop through oba and call put
		for(int bi = 0; bi < oba.length; bi++){
			for(int di = 0; di < oba[bi].size; di++){
				HMNode node = oba[bi].getAt(di);
				put(node.key, node.value);
			}
		}
	}

	private int findInBucket(LinkedList<HMNode> bucket, K key) {
		for (int i = 0; i < bucket.size; i++) {
			HMNode node = bucket.getAt(i);
			if (node.key.equals(key)) {
				return i;
			}
		}

		return -1;
	}

	private int hashFn(K key) {
		int hc = key.hashCode(); // to be discussed
		int bi = Math.abs(hc) % buckets.length;
		return bi;
	}

	public ArrayList<K> keyset() {
		ArrayList<K> list = new ArrayList<>();

		for(int bi = 0; bi < buckets.length; bi++){
			for(int di = 0; di < buckets[bi].size; di++){
				list.add(buckets[bi].getAt(di).key);
			}
		}
		
		return list;
	}

	public void display() {
		for(int bi = 0; bi < buckets.length; bi++){
			System.out.print("B" + bi + " -> ");
			for(int di = 0; di < buckets[bi].size; di++){
				HMNode node = buckets[bi].getAt(di);
				System.out.print(node.key + "@" + node.value + ", ");
			}
			System.out.println(".");
		}
	}
}
