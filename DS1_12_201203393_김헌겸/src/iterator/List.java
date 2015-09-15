package iterator;

public interface List<T>{
	public abstract boolean add(T anElement);
	public abstract boolean contains(T anElement);
	
	public abstract boolean isFull();
	public abstract boolean isEmpty();
	public abstract void clear();
	
	public abstract T removeMin();
	public abstract T removeMax();
	public abstract T removeFrom(int aPosition);
	
	public abstract int size();
}
