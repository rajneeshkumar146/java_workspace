package Class_18and19th_LinkedList;

public class LLtoqueue extends LinkedList_simple {

	public void enqueue(int value) throws Exception { // push
		this.addlast(value);
	}

	public int dequeue() throws Exception { // pop
		return this.removeFirst();
	}

	public int front() throws Exception { // top
		return this.getfirst();
	}


	public void Display() {
		this.display();

	}

	public int Size() {
		return this.size();
	}

	public boolean IsEmpty() {
		return this.isempty();
	}

}
