package stack;

public abstract class NodoSuper {
	public Object information;
    public NodoSuper previous;	
    
    public abstract boolean isEmpty();
    public abstract void pop();
    public abstract void top();
    public abstract void size();

}