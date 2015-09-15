package priority;

public interface PriorityQueue<T extends Comparable<T>> {
	public abstract boolean isEmpty();
	public abstract boolean isFull();
	public abstract int size();
	
	public abstract boolean add(T anElement);
	public abstract T max();
	public abstract T removeMax();
}
