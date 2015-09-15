package linkedQueue;

public class LinkedQueue<T> {
	private int _size;
	private Node<T> _rear;
	private Node<T> _front;
	
	public LinkedQueue()
	{
		this._front = null;
		this._rear = null;
		this._size = 0;
	}    
	public long maxSize()	//실행시 Java VM에 할당된 메모리에서 객체 생성시의 메모리를 나눈 값을 반환한다.
	{
		System.gc();
		Runtime r = Runtime.getRuntime();
		long firstMemorySize = r.freeMemory();
		@SuppressWarnings({ "unused", "unchecked" })
		Node<T> testNode = new Node<T>((T)new Character('0') ,null);
		long lastMemorySize = r.freeMemory();
		return r.totalMemory() / (firstMemorySize + 1 - lastMemorySize);
	}
	
	public int size()
	{
		return this._size;
	}
	public boolean isEmpty()
	{
		return (this._front == null);
	}
	public boolean isFull()
	{
		return (this._size == this.maxSize());
	}
	
	public T frontElement()
	{
		if(this.isEmpty())
			return null;
		else
			return this._front.element();
	}
	
	
	public boolean enQueue(T anElement)
	{
		if(this.isFull())
			return false;
		
		Node<T> newNode = new Node<T>(anElement);
		if(this.isEmpty())
		{
			this._front = newNode;
			this._rear = newNode;
		}
		else
		{
			this._rear.setNext(newNode);
			this._rear = newNode;
		}
		this._size++;
		return true;
	}
	public T deQueue()
	{
		T removedElement = null;
		if(!this.isEmpty())
		{
			removedElement = this._front.element();
			if(this._front == this._rear)
			{
				this._front = null;
				this._rear = null;
			}
			else
				this._front = this._front.next();
			
			this._size--;
		}
		return removedElement;
	}
	
	public void clear()
	{
		this._front = null;
		this._rear = null;
		this._size = 0;
	}
	public T elementAt(int givenPosition)
	{
		int indexCount=0;
		Node<T> currentNode = this._front; 
		T foundElement = null;
		
		while((currentNode != null) && (indexCount < givenPosition))
		{
			currentNode = currentNode.next();
			indexCount++;
		}
		if(currentNode != null)
			foundElement = currentNode.element();
		
		return foundElement;
	}
			
}
