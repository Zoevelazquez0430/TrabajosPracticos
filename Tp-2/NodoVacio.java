package stack;

public class NodoVacio extends NodoSuper{
	
	public boolean isEmpty() {
		return true;
	}
    public void pop() {
    	throw new Error(OOStack.stackEmptyErrorDescription);
    }
    public void top() {
    	throw new Error(OOStack.stackEmptyErrorDescription);
    }
    public void size() {}	
}

