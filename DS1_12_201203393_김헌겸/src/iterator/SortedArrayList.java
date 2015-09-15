package iterator;

public class SortedArrayList <T extends Comparable<T>> implements List<T>{
	
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private T[] _elements;
	
	public SortedArrayList()
	{
		this(SortedArrayList.DEFAULT_MAX_SIZE);
	}

	@SuppressWarnings("unchecked")
	public SortedArrayList(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._size = 0;
		this._elements = (T[])new Comparable[this._maxSize];
	}
	@Override
	public boolean add(T anElement) {
		if(this.isFull())
			return false;
		
		boolean found = false;
		int targetIndex = 0;
		for(int i = 0; (i < this._size) && !found; i++)
		{
			if(anElement.compareTo(this._elements[i]) < 0)
			{
				targetIndex = i;
				found = true;
			}
		}
		if(found)
		{
			for(int i = this._size; i >= targetIndex; i--)
			{
				this._elements[i+1] = this._elements[i];
			}
			this._elements[targetIndex] = anElement;
			this._size++;
		}
		else
		{
			this._elements[this._size++] = anElement;
		}
		
		return true;
	}

	@Override
	public boolean contains(T anElement) {
		boolean found = false;
		for(int i=0; i<this._size; i++)
		{
			if(this._elements[i].compareTo(anElement) == 0)
				found = true;
		}
		return found;
	}

	@Override
	public boolean isFull() {
		return (this._size == this._maxSize);
	}

	@Override
	public boolean isEmpty() {
		return (this._size == 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this._size = 0;
		this._elements = (T[])new Comparable[this._maxSize];
	}

	@Override
	public int size() {
		return this._size;
	}

	@Override
	public T removeMin() {
		if(this.isEmpty())
			return null;
		int minPosition = this.minElementPosition(this._elements, 0, this._size-1);
		T removedElement = this._elements[minPosition];
		
		for(int i = minPosition; i < this._size; i++)
			this._elements[i] = this._elements[i+1];
		this._elements[this._size--] = null;
		return removedElement;
	}

	@Override
	public T removeMax() {
		if(this.isEmpty())
			return null;
		int maxPosition = this.maxElementPosition(this._elements, 0, this._size-1);
		T removedElement = this._elements[maxPosition];
		
		for(int i = maxPosition; i < this._size; i++)
			this._elements[i] = this._elements[i+1];
		this._elements[this._size--] = null;
		return removedElement;
	}

	@Override
	public T removeFrom(int aPosition) {
		if(this.isEmpty())
			return null;
		if((aPosition >= this._size) || (aPosition < 0))
			return null;
		
		T removedElement = this._elements[aPosition];
		for(int i = aPosition; i< this._size;i++)
			this._elements[i] = this._elements[i+1];
		this._elements[this._size--] = null;
		return removedElement;
	}
	
	private int maxElementPosition(T[] arr, int left, int right)
	{
		if(left == right)
			return left;
		
		int mid = (left+right)/2;
		
		int maxLeft = maxElementPosition(arr,left,mid);
		int maxRight = maxElementPosition(arr,mid+1,right);
		return ((this._elements[maxLeft].compareTo(this._elements[maxRight]) > 0)? maxLeft:maxRight);
	}
	private int minElementPosition(T[] arr, int left, int right)
	{
		if(left == right)
			return left;
		
		int mid = (left+right)/2;
		
		int minLeft = minElementPosition(arr,left,mid);
		int minRight = minElementPosition(arr,mid+1,right);
		return ((this._elements[minLeft].compareTo(this._elements[minRight]) < 0)? minLeft:minRight);
	}
	
	public Iterator<T> ListIterator()
	{
		return new Iterator<T>(){
			private int _nextPosition = 0;

			@Override
			public boolean hasNext() 
			{
				return (this._nextPosition < SortedArrayList.this.size());
			}

			@Override
			public T next() 
			{
				if(!this.hasNext())
					return null;
				else
				{
					T element = SortedArrayList.this._elements[this._nextPosition];
					this._nextPosition++;
					return element;
				}
			}
		};
	}
}
