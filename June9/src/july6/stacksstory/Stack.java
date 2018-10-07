package july6.stacksstory;

public class Stack {
	int[] arr;
	int tos = -1;
	
	public Stack(int cap){
		arr = new int[cap];
	}
	
	public void push(int val){
		if(tos == arr.length - 1){
			System.out.println("Stack overflow");
			return;
		}
		
		tos++;
		arr[tos] = val;
	}
	
	public int top(){
		if(tos == -1){
			System.out.println("Stack underflow");
			return -1;
		}
		
		return arr[tos];
	}
	
	public int pop(){
		if(tos == -1){
			System.out.println("Stack underflow");
			return -1;
		}
		
		int rv = arr[tos];
		tos--;
		return rv;
	}
	
	public int size(){
		return tos + 1;
	}
	
	public boolean isEmpty(){
		if(tos == -1){
			return true;
		} else {
			return false;
		}
	}
	
	public void display(){
		for(int i = tos; i >= 0; i--){
			System.out.print(arr[i] + " -> ");
		}
		System.out.println(".");
	}
}
