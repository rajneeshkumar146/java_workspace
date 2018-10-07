package Class_16th_OPPs_basic_and_stack_que;

public class Stack {

	int[] data;
	int tos = -1;

	Stack(int capacity) {
		this.data = new int[capacity];
	}

	public void push(int item) throws Exception {
		if(this.tos==this.data.length){
			throw new Exception("Stack overflow");
		}

		this.tos++;
		this.data[this.tos] = item;

	}

	public int top() throws Exception {
		if(this.tos==-1){
			throw new Exception("No Element present init");
		}

		int rv = this.data[this.tos];
		return rv;

	}

	public int pop() throws Exception{
		if(this.tos==-1){
			throw new Exception("No Elements present init");
		}
		

		int rv = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;
		return rv;

	}

	public int size() {
		return this.tos + 1;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.println(this.data[i]);
		}
	}
	
	public boolean isempty(){
		
		if(this.tos==-1){
			return true;
		}else{
			return false;
		}
		
		
	}

}
