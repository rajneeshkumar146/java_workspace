package july7;

import july6.stacksstory.DynamicStack;
import july6.stacksstory.Stack;

public class Client {

	public static void main(String[] args) {
//		System.out.println(isBalancedExpression("[{(a+b)+(c+d)}]"));
//		System.out.println(duplicate("()"));
		int[] prices = {10, 20, 30, 25, 22, 28, 50, 40, 45, 47, 35};
		int[] spans = spans(prices);
		for(int val: spans){
			System.out.print(val + " ");
		}
		System.out.println(".");
		
	}

	public static boolean isBalancedExpression(String str) {
		Stack st = new DynamicStack(str.length());

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (st.size() == 0) {
					return false; // extra closing brackets
				} else if (ch == ')' && st.top() != '(') {
					return false; // mismatch
				} else if (ch == '}' && st.top() != '{') {
					return false; // mismatch
				} else if (ch == ']' && st.top() != '[') {
					return false; // mismatch
				} else {
					st.pop();
				}
			}
		}
		
		if(st.size() != 0){
			return false; // extra opening brackets
		} else {
			return true;
		}
	}

	public static boolean duplicate(String str){
		DynamicStack st = new DynamicStack(str.length());
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if(ch != ')'){
				st.push(ch);
			} else {
				if(st.top() == '('){
					return true;
				} else {
					while(st.top() != '('){
						st.pop();
					}
					st.pop();
				}
			}
		}
		
		return false;
	}

	public static int[] spans(int[] prices){
		StackUsingQueuesPushO1 st = new StackUsingQueuesPushO1(prices.length);
		int[] spans = new int[prices.length];
		
		spans[0] = 1;
		st.push(0);
		
		for(int i = 1; i < prices.length; i++){
			// make pops
			while(st.size() > 0 && prices[st.top()] < prices[i]){
				st.pop();
			}
			
			// set value
			spans[i] = st.size() == 0? i + 1: i - st.top();
			
			// push
			st.push(i);
		}
		
		return spans;
	}
	
	
	
	
	
	
	
	
	
	
}
