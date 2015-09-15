package iterator;

public interface Iterator <T extends Comparable<T>>{
	public boolean hasNext();
	public T next();
}
