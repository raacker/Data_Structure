package priority;

public class SortedArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>{
	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private T[] _element;
	
	public SortedArrayPriorityQueue()
	{
		this(SortedArrayPriorityQueue.DEFAULT_MAX_SIZE);	
	}
	@SuppressWarnings("unchecked")
	public SortedArrayPriorityQueue(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element =  (T[]) new Comparable[this._maxSize];
	}
	
	public PriorityQueueIterator priorityQueueIterator()
	{
		return new PriorityQueueIterator();
	}
	
	public class PriorityQueueIterator implements Iterator<T>
	{
		private int _nextPosition;
		private PriorityQueueIterator()
		{
			this._nextPosition = _size;
		}
		public boolean hasNext() {
			return (this._nextPosition-1 >= 0);
		}

		public T next() {
			if(isEmpty())
				return null;
			return _element[--this._nextPosition];
		}
	}
	@Override
	public boolean isEmpty() {
		return (this._size == 0);
	}
	@Override
	public boolean isFull() {
		return (this._size == this._maxSize);
	}
	@Override
	public int size() {
		return this._size;
	}
	@Override
	public boolean add(T anElement) {
		if(this.isFull())
			return false;
		
		int targetIndex = 0;
		
		for(int index = 0; index < this._size; index++)
		{
			if(anElement.compareTo(this._element[index]) < 0)
			{
				targetIndex = index;
				break;
			}
			targetIndex++;
		}
		if(targetIndex < this._size)
		{
			for(int index = this._size; index > targetIndex; index--)
				this._element[index] = this._element[index-1];
		}
		this._element[targetIndex] = anElement;
		this._size++;
		return true;
	}
	@Override
	public T max() {
		if(this.isEmpty())
		
			return null;
		return this._element[this._size-1];
	}
	@Override
	public T removeMax() {
		if(this.isEmpty())
			return null;
		
		T removeElement = this._element[this._size-1];
		this._element[--this._size] = null;
		return removeElement;
	}
}
