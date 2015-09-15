package postfix;

public class ArrayList<T> implements Stack<T>{

	private static final int DEFAULT_MAX_STACK_SIZE = 5;
	private int _maxSize;
	private int _top;
	private T[] _elements;
	
	public ArrayList()
	{
		this(ArrayList.DEFAULT_MAX_STACK_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int maxSize)
	{
		this._maxSize = maxSize;
		this._top = -1;
		this._elements = (T[]) new Object[this._maxSize];
	}
	public boolean isEmpty()
	{
		return (this._top == -1);
	}
	public boolean isFull()
	{
		return (this._top+1 == this._maxSize);
	}
	public int size()
	{
		return (this._top + 1);
	}
	
	@Override
	public boolean push(T anElement) {
		// TODO Auto-generated method stub
		if(this.isFull())
			return false;
		else
		{
			this._elements[++this._top] = anElement;
			return true;
		}
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return null;
		else
			return this._elements[this._top--];
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return null;
		else
			return this._elements[this._top];
	}
	
	public void clear()
	{
		for(int index = this._top; index > -1; index--)
			this._elements[index] = null;
		this._top = -1;
	}
	
	public T elementAt(int order)
	{
		if(this.isEmpty())
			return null;
		else
			return this._elements[order];
	}

}
