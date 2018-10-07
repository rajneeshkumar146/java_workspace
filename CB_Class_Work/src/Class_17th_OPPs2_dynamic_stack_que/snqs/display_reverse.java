package Class_17th_OPPs2_dynamic_stack_que.snqs;

public class display_reverse extends Stack {

	public void displayReverseRecu(int vidx) throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack Is empty");
		}

		if (vidx == this.size()) {
			return;
		}

		System.out.println(this.data[vidx]);
		displayReverseRecu(vidx + 1);

	}

	public void reverseRecu(Stack s) throws Exception {
		Stack sthelp = new Stack();
		this.reverseArgu(s, sthelp);
	}

	private void reverseArgu(Stack s, Stack shelper) throws Exception {
		if (s.size() ==0) {
			if(shelper.size()==0){
			return;
			}
			int temp2 = shelper.pop();
			reverseArgu(s, shelper);
			s.push(temp2);
			return;
		}

		int item = s.pop();
		shelper.push(item);
		reverseArgu(s, shelper);

	}

}
