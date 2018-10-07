package Class_18and19th_LinkedList.Two_Stacks_in_array;

public class twoStacks {
	
	private int[] data;
	private int tos1;
	private int tos2;
	private int tsc;
	
	twoStacks(int cap){
		this.tsc=2*cap;  //tsc=two_stack_capacity
		this.data=new int[tsc];
		this.tos1=-1;
		this.tos2=cap-1;
		
	}

	public void push1(int item) throws Exception {
		if (this.tos1 == (this.tsc/2 )- 1) {
			throw new Exception("Stack is full");
		}
		tos1++;
		this.data[this.tos1]=item;
	}
	
	public void push2(int item) throws Exception {
		if (this.tos2 == this.tsc- 1) {
			throw new Exception("Stack is full");
		}
		tos2++;
		this.data[this.tos2]=item;
	}
	
	public int pop1() throws Exception { //remove
		if (this.tos1 == -1) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos1];
		this.tos1--;
		return rv;
	}
	
	public int pop2() throws Exception { //remove
		if (this.tos2 == (this.tsc/2)-1) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos2];
		this.tos2--;
		return rv;
	}
	
	public int top1() throws Exception {  //show
		if (this.tos1 == -1) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos1];
		return rv;
	}

	public int top2() throws Exception {  //show
		if (this.tos2 == (this.tsc/2)-1) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos2];
		return rv;
	}
	
	public int size1() {
		return this.tos1 + 1;
	}
	
	public int size2() {
		return this.tos2 + 1;
	}

	public boolean isEmpty1() {
		return this.tos1==-1;
			
	}
	
	public boolean isEmpty2() {
		return this.tos2==(this.tsc/2)-1;
			
	}
	
	public void display1(){
		for (int i = this.tos1; i >= 0; i--) {
			System.out.print(this.data[i] + ", ");
		}
	}
	
	public void display2(){
		for (int i = this.tos2; i >=  this.tsc/2; i--) {
			System.out.print(this.data[i] + ", ");
		}
	}
	
	
	
}
