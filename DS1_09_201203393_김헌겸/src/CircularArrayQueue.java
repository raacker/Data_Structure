
public class CircularArrayQueue<T> {
	private static final int DEFAULT_INITIAL_CAPACITY = 5;
	private int _maxSize;
	private int _front;
	private int _rear;
	private T[] _elements;
	
	public CircularArrayQueue()
	{
		this(CircularArrayQueue.DEFAULT_INITIAL_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initialCapacity)
	{
		this._maxSize = initialCapacity;
		this._front = 0;
		this._rear = 0;
		this._elements = (T[]) new Object[this._maxSize];
	}
	
	public int front()
	{
		return this._front + 1;
	}
	public int rear()
	{
		return this._rear + 1;	
	}
	public int maxSize()
	{
		return this._maxSize;
	}
	
	public boolean isEmpty()
	{
		return (this._front == this._rear);
	}
	public boolean isFull()
	{
		return (this._front == this.nextPos(this._rear));
	}
	public int nextPos(int pos)
	{
		return ((pos+1) % this._maxSize);
	}
	
	public int size()
	{
		if(this._front <= this._rear)
			return (this._rear - this._front);
		else
			return ((this._rear + this._maxSize) - this._front);
	}
	
	public T frontElement()
	{
		T frontElement = null;
		if(!this.isEmpty())
			frontElement = this._elements[this._front+1];
		return frontElement;
	}
	
	public boolean enQueue(T anElement)
	{
		if(this.isFull())
			return false;
		else
		{
			this._rear = this.nextPos(this._rear);
			this._elements[this._rear] = anElement;
			return true;
		}
	}
	public T deQueue()
	{
		T frontElement = null;
		if(!this.isEmpty())
		{
			this._front = this.nextPos(this._front);
			frontElement = this._elements[this._front];
			this._elements[this._front] = null;
		}
		return frontElement;
	}
	
	public void clear()
	{
		while(!this.isEmpty()) this.deQueue();
		this._front = 0;		
		this._rear = 0;
		//this._elements = (T[]) new Object[this._maxSize];
	}
	public T elementAt(int givenPosition)
	{
		return this._elements[givenPosition];
	}
			
}
