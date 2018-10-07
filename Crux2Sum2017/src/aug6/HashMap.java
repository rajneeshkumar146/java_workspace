package aug6;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class HMNode {
		K key;
		V value;
	}
	
	private LinkedList<HMNode>[] buckets; // N
	private int size = 0; // n
	
	public HashMap(){
		buckets = new LinkedList[4];
		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new LinkedList<>();
		}
		this.size = 0;
	}
	
	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucketAt = findInBucket(bucket, key);
		
		if(foundInBucketAt == -1){
			HMNode n2add = new HMNode();
			n2add.key = key;
			n2add.value = value;
			bucket.addLast(n2add);
			this.size++;
		} else {
			HMNode n2update = bucket.getAt(foundInBucketAt);
			n2update.value = value;
		}
		
		// rehash
		double lambda = (this.size * 1.0) / this.buckets.length;
		if(lambda > 2.0){
			this.rehash();
		}
	}
	
	public boolean containsKey(K key) throws Exception{
		int bi = hashFunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucketAt = findInBucket(bucket, key);
		
		if(foundInBucketAt == -1){
			return false;
		} else {
			return true;
		}
	}
	
	public V get(K key) throws Exception{
		int bi = hashFunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucketAt = findInBucket(bucket, key);
		
		if(foundInBucketAt == -1){
			return null;
		} else {
			HMNode nodetoreturn = bucket.getAt(foundInBucketAt);
			return nodetoreturn.value;
		}
	}
	
	public V remove(K key) throws Exception{
		int bi = hashFunction(key);
		LinkedList<HMNode> bucket = buckets[bi];
		int foundInBucketAt = findInBucket(bucket, key);
		
		if(foundInBucketAt == -1){
			return null;
		} else {
			HMNode nodetoreturn = bucket.removeAt(foundInBucketAt);
			this.size--;
			return nodetoreturn.value;
		}
	}
	
	private int hashFunction(K key){
		int hc = key.hashCode(); // what should be a good hashCode
		
		int abshc = Math.abs(hc);
		int bi = abshc % buckets.length;
		
		return bi;
	}
	
	private int findInBucket(LinkedList<HMNode> bucket, K key) throws Exception {
		for(int i = 0; i < bucket.size(); i++){
			HMNode hmnode = bucket.getAt(i);
			if(hmnode.key.equals(key)){
				return i;
			}
		}
		
		return -1;
	}

	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public void display() throws Exception {
		System.out.println("-------------------------------------------------");
		for(int i = 0; i < buckets.length; i++){
			String str = "BUCKET " + i + " => ";
			
			for(int j = 0; j < buckets[i].size(); j++){
				HMNode node = buckets[i].getAt(j);
				str += "{" + node.key + "_" + node.value + "}, ";
			}
			
			System.out.println(str + ".");
		}
		System.out.println("-------------------------------------------------");
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
	
	private void rehash() throws Exception{
		LinkedList<HMNode>[] oba = this.buckets;
		
		// ctor
		this.buckets = new LinkedList[2 * oba.length];
		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new LinkedList<>();
		}
		this.size = 0;
		
		// reinsert the old data
		for(int i = 0; i < oba.length; i++){
			for(int j = 0; j < oba[i].size(); j++){
				HMNode node = oba[i].getAt(j);
				this.put(node.key, node.value);
			}
		}
	}










}
