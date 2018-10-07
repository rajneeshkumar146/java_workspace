package july16.storystacks;

public class Stack {
	protected int[] data;
	protected int tos = -1;

	public Stack(){
		this(5);
	}
	
	public Stack(int cap) {
		this.data = new int[cap];
	}

	public void push(int value) throws Exception {
		if(tos == data.length - 1){
			throw new Exception("Stack is full");
		}
		this.tos++;
		this.data[this.tos] = value;
	}

	public int top() throws Exception {
		if(tos == -1){
			throw new Exception("Stack is empty");
		}
		return this.data[this.tos];
	}

	public int pop()  throws Exception{
		if(tos == -1){
			throw new Exception("Stack is empty");
		}
		
		int rv = this.data[this.tos];

		this.data[this.tos] = 0;
		this.tos--;

		return rv;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return this.tos == -1;
	}
	
	public void display(){
		System.out.println("-------------------------------------");
		
		for(int i = this.tos; i >= 0; i--){
			System.out.print(this.data[i] + ", ");
		}
		System.out.println(".");
		
		System.out.println("-------------------------------------");
	}

}
