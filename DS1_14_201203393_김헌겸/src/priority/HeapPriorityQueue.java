package priority;

public class HeapPriorityQueue <T extends Comparable<T>> implements PriorityQueue<T>{
	private static final int DEFAULT_CAPACITY = 100;
	private static final int ROOT = 1;	
	private int _maxSize;
	private int _size;
	private T[] _tree;
	
	public HeapPriorityQueue() {
		this(HeapPriorityQueue.DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public HeapPriorityQueue(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._size = 0;
		this._tree = (T[]) new Comparable[this._maxSize+1];
	}
	public PriorityQueueIterator priorityQueueIterator()
	{
		return new PriorityQueueIterator();
	}
	
	private class PriorityQueueIterator implements Iterator<T>
	{
		private HeapPriorityQueue<T> _queue = new HeapPriorityQueue<T>();
		private PriorityQueueIterator()
		{
			System.arraycopy(HeapPriorityQueue.this._tree,0, _queue._tree,0,HeapPriorityQueue.this._tree.length);
			this._queue._size = HeapPriorityQueue.this._size;
		}
		@Override
		public boolean hasNext() {
			return !(this._queue.isEmpty());
		}

		@Override
		public T next() {
			return this._queue.removeMax();
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
		
		if(!(anElement instanceof Comparable))
			throw new IllegalArgumentException();
		int i = ++this._size;	
		while((i > ROOT) && (anElement.compareTo(this._tree[i/2]) > 0))		
		{
			this._tree[i] = this._tree[i/2];
			i /= 2;
		}
		this._tree[i] = anElement;
		return true;
	}

	@Override
	public T max() {
		if(this.isEmpty())
			return null;
		return this._tree[HeapPriorityQueue.ROOT];
	}

	@Override
	public T removeMax() {
		if(this.isEmpty())
			return null;
		
		this._size--;
		T removedElement = this._tree[HeapPriorityQueue.ROOT];
		
		if(this._size > 0)
		{
			int parent = HeapPriorityQueue.ROOT;
			int bigChild;
			T lastElement = this._tree[this._size+1];
			while((parent*2) <= this._size)
			{
				bigChild = parent*2;
				if((bigChild < this._size) && (this._tree[bigChild].compareTo(this._tree[bigChild+1]) < 0))	//왼쪽만 있지않고, 오른쪽이 더 크다면. 
					bigChild++;
				if(lastElement.compareTo(this._tree[bigChild]) >= 0)
					break;
				
				this._tree[parent] = this._tree[bigChild];
				parent = bigChild;
			}
			this._tree[parent] = lastElement;
		}
		this._tree[this._size+1] = null;
		return removedElement;
	}
	

}
