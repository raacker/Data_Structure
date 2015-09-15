package stack;

public interface Stack <T>{
	public abstract boolean push(T anElement);
	public abstract T pop();
	public abstract T peek();
}
