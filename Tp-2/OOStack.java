package stack;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	
	public static NodoSuper head;

	public OOStack() {
		head= new NodoVacio();
	}
	
	public OOStack push(Object object) {
		NodoSuper newState= new NodoNoVacio();
		newState.information= object;
		newState.previous= head;
		head= newState;
		return this;
	}

	public Object pop() {
		head.pop();
		Object ValueToReturn = head.information;
		head=head.previous;
		return ValueToReturn;
	}
	
	public Object top() {
		head.top();
		return head.information;
	}
	
	public boolean isEmpty() {
		return head.isEmpty();
	}

	public int size() {
		int size=0;
		NodoSuper current = head;
		
		while(current!= null){
			size++;
			current = current.previous;
		}
		return size-1;
	}
}