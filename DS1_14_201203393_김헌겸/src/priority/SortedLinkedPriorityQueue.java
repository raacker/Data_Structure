package priority;

public class SortedLinkedPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>{
	private static final int DEFAULT_MAX_CAPACITY = 100;
	private int _maxSize;
	private int _size;
	private Node<T> _head;
	
	public SortedLinkedPriorityQueue() {
		this(SortedLinkedPriorityQueue.DEFAULT_MAX_CAPACITY);
	}
	public SortedLinkedPriorityQueue(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._size = 0;
		this._head = null;
	}
	
	public PriorityQueueIterator priorityQueueIterator()
	{
		return new PriorityQueueIterator();
	}
	
	public class PriorityQueueIterator implements Iterator<T>
	{
		private Node<T> _IterNext;
		private PriorityQueueIterator()
		{
			this._IterNext = _head;
		}
		public boolean hasNext() {
			return (this._IterNext != null);
		}

		public T next() {
			if(isEmpty())
				return null;
			else
			{	
				T returnElement = this._IterNext.element();
				this._IterNext = this._IterNext.next();
				return returnElement;
			}
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
		
		Node<T> currentNode = this._head;
		Node<T> previousNode = null;
		while(currentNode != null)
		{
			if(currentNode.element().compareTo(anElement) < 0)
				break;
			else
			{
				previousNode = currentNode;
				currentNode = currentNode.next();
			}
		}
		
		Node<T> newNode = new Node<T>(anElement);
		if(currentNode == this._head)
		{
			newNode.setNext(this._head);
			this._head = newNode;
		}
		else
		{
			newNode.setNext(previousNode.next());
			previousNode.setNext(newNode);
		}
		
		this._size++;
		return true;
	}

	@Override
	public T max() {
		if(this.isEmpty())
			return null;
		return this._head.element();
	}

	@Override
	public T removeMax() {
		if(this.isEmpty())
			return null;
		T removeElement = this._head.element();
		this._head = this._head.next();
		this._size--;
		return removeElement;
	}

}
