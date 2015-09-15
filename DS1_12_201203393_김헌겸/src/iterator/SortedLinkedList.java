package iterator;

public class SortedLinkedList <T extends Comparable<T>> implements List<T>{
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private Node<T> _head;
	
	public SortedLinkedList() {
		this(SortedLinkedList.DEFAULT_MAX_SIZE);
	}
	public SortedLinkedList(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._head = null;
	}
	@Override
	public boolean add(T anElement) {
		if(this.isFull())
			return false;
		
		Node<T> currentNode = this._head;
		Node<T> previousNode = null;
		Node<T> newNode = new Node<T>(anElement);
		
		while(currentNode != null)
		{
			if(anElement.compareTo(currentNode.element()) < 0)
			{
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		
		if(currentNode == this._head)
		{
			newNode.setNext(this._head);
			this._head = newNode;
		}
		else
		{
			newNode.setNext(currentNode);
			previousNode.setNext(newNode);
		}
		this._size++;
		return true;
	}
	@Override
	public boolean contains(T anElement) {
		if(this.isEmpty())
			return false;
		
		boolean found = false;
		Node<T> currentNode = this._head;
		while(!found && currentNode != null)
		{
			if(currentNode.element().compareTo(anElement) == 0)
				found = true;
			currentNode = currentNode.next();
		}
		return true;
	}
	@Override
	public boolean isFull() {
		return (this._size == this._maxSize);
	}
	@Override
	public boolean isEmpty() {
		return (this._size == 0);
	}
	@Override
	public void clear() {
		this._size = 0;
		this._head = null;
	}
	@Override
	public T removeMin() {
		if(this.isEmpty())
			return null;
		
		Node<T> currentNode = this._head;
		Node<T> previousNode = null;
		Node<T> targetNode = this._head;
		Node<T> previousTarget = null;
		
		T removedElement = null;
		
		if(currentNode != null)
		{
			removedElement = currentNode.element();	
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		
		while(currentNode != null)
		{
			if(removedElement.compareTo(currentNode.element()) > 0)
			{
				targetNode = currentNode;
				previousTarget = previousNode;
				removedElement = currentNode.element();
			}
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		
		if(targetNode == this._head)
		{
			targetNode = targetNode.next();
			this._head = targetNode;
		}
		else
			previousTarget.setNext(targetNode.next());
		this._size--;
		return removedElement;
	}
	@Override
	public T removeMax() {
		if(this.isEmpty())
			return null;
		
		Node<T> currentNode = this._head;
		Node<T> previousNode = null;
		Node<T> targetNode = this._head;
		Node<T> previousTarget = null;
		
		T removedElement = null;
		
		if(currentNode != null)
		{
			removedElement = currentNode.element();	
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		
		while(currentNode != null)
		{
			if(removedElement.compareTo(currentNode.element()) < 0)
			{
				targetNode = currentNode;
				previousTarget = previousNode;
				removedElement = currentNode.element();
			}
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		
		if(targetNode == this._head)
		{
			targetNode = targetNode.next();
			this._head = targetNode;
		}
		else
			previousTarget.setNext(targetNode.next());
		this._size--;
		
		return removedElement;
	}
	@Override
	public T removeFrom(int aPosition) {
		
		if(this.isEmpty())
			return null;
		if((aPosition < 0) || (aPosition >= this._size))
				return null;

		int positionCount = 0;
		Node<T> currentNode = this._head;
		Node<T> previousNode = null;
		T removedElement = null;
	
		while((currentNode != null) && (positionCount != aPosition))
		{
			previousNode = currentNode;
			currentNode = currentNode.next();
			positionCount++;
		}
		if(currentNode != null)
			removedElement = currentNode.element();
		
		
		if(aPosition == 0)
		{
			currentNode = currentNode.next();
			this._head = currentNode;
			this._size--;
		}
		else
		{
			previousNode.setNext(currentNode.next());
			this._size--;
		}

		return removedElement;
	}
	@Override
	public int size() {
		return this._size;
	}
	
	public Iterator<T> ListIterator()
	{
		return new Iterator<T>(){
			private Node<T> _nextNode = SortedLinkedList.this._head;

			@Override
			public boolean hasNext() 
			{
				return (this._nextNode != null);
			}

			@Override
			public T next() 
			{
				if(!this.hasNext())
					return null;
				else
				{
					T element = this._nextNode.element();
					this._nextNode = this._nextNode.next();
					return element;
				}
			}
		};
	}
}
