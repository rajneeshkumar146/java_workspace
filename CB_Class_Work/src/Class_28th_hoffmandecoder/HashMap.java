package Class_28th_hoffmandecoder;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class HMNode {
		K key;
		V value;
	}

	private LinkedList<HMNode>[] buckets; // N
	private int size = 0; // n

	public HashMap() {
		buckets = new LinkedList[5];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
			this.size = 0;
		}
	}

	public void put(K key, V value) throws Exception {
		int bi = hashfunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucket = findInBucket(bucket, key);
		if (foundInBucket == -1) {
			HMNode n2add = new HMNode();
			n2add.key = key;
			n2add.value = value;
			bucket.addLast(n2add);
			this.size++;
		} else {
			HMNode update = bucket.getAt(foundInBucket);
			update.value = value;
		}

		double lambda = (this.size * 1.0) / buckets.length;
		if (lambda > 2.0) {
			rehash();
		}

	}

	public boolean containskey(K key) throws Exception {
		int bi = hashfunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucket = findInBucket(bucket, key);
		if (foundInBucket == -1) {
			return false;
		} else {
			return true;
		}
	}

	public V get(K key) throws Exception {
		int bi = hashfunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucket = findInBucket(bucket, key);
		if (foundInBucket == -1) {
			return null;
		} else {
			HMNode hm = bucket.getAt(foundInBucket);
			return hm.value;
		}
	}

	public V remove(K key) throws Exception {
		int bi = hashfunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucket = findInBucket(bucket, key);
		if (foundInBucket == -1) {
			return null;
		} else {
			HMNode rv = bucket.removeAt(foundInBucket);
			this.size--;
			return rv.value;
		}

	}

	private int findInBucket(LinkedList<HMNode> bucket, K key) throws Exception {
		for (int i = 0; i < bucket.size(); i++) {
			HMNode hmnode = bucket.getAt(i);

			if (hmnode.key.equals(key)) {
				return i;
			}
		}
		return -1;

	}

	public int hashfunction(K key) {
		int hashcode = key.hashCode();
		int abHashcode = Math.abs(hashcode);
		int bi = abHashcode % buckets.length;
		return bi;
	}

	public int size() {
		return this.size;
	}

	public boolean IsEmpty() {
		return this.size == 0;
	}

	public void display() throws Exception {
		for (int i = 0; i < buckets.length; i++) {
			String str = "Bucket No: " + i + "=>";
			for (int j = 0; j < buckets[i].size(); j++) {
				HMNode hmnode = buckets[i].getAt(j);
				str += "{" + hmnode.key + "," + hmnode.value + "}" + ".";
			}
			System.out.println(str);
		}
	}

	public ArrayList<K> keyset() throws Exception {
		ArrayList<K> keyset = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				HMNode hmnode = buckets[i].getAt(j);
				keyset.add(hmnode.key);
			}
		}

		return keyset;

	}

	public void rehash() throws Exception {
		LinkedList<HMNode>[] oba = this.buckets; // oba=oldBucketArray.
		
		

		// ctor
		this.buckets = new LinkedList[2 * oba.length];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
			this.size = 0;
		}

		for (int i = 0; i < oba.length; i++) {
			for (int j = 0; j < oba[i].size(); j++) {
				HMNode hmnode = oba[i].getAt(j);
				put(hmnode.key, hmnode.value);
			}
		}

	}

}
