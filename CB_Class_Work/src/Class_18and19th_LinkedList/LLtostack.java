package Class_18and19th_LinkedList;

public class LLtostack extends LinkedList_simple{
	public void push(int item) throws Exception {  //add
		this.addfirst(item);
	}

	public int top() throws Exception {  //show
		return this.getfirst();
	}

	public int pop() throws Exception { //remove
		return this.removeFirst();
	}

	public int Size() {
		return this.size();
	}

	public boolean IsEmpty() {
		return this.isempty();
	}

	public void Display(){
		this.display();
	}
	
	
	

}
