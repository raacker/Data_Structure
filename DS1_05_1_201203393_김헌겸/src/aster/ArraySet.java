package aster;

public class ArraySet {
	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Star _element[];
	
	public ArraySet()
	{
		this._maxSize = ArraySet.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._element = new Star[this._maxSize];
	}
	public ArraySet(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = new Star[this._maxSize];
	}
	public int size()
	{
		return this._size;
	}
	public boolean isEmpty()
	{
		return (this._size == 0);
	}
	public boolean isFull()
	{
		return (this._size == this._maxSize);
	}
	public boolean doesContain(Star anElement)
	{
		boolean found = false;
		for(int i=0;(i<this._size && !found); i++)
		{
			if(this._element[i].equals(anElement))
				found = true;
		}
		return found;
	}
	public boolean add(Star anElement)
	{
		if(this.isFull())
			return false;
		else
		{
			if(this.doesContain(anElement))
				return false;
			else
			{
				this._element[this._size++] = anElement;
				return true;
			}
		}
	}
	public Star remove(Star anElement)
	{
		int foundIndex=0;
		boolean found = false;
		Star removedStar = null;
		
		if(this.isEmpty())
			return null;
		else
		{
			for(int index = 0;(index<this._size && !found); index++)
			{
				if(this._element[index].equals(anElement))
				{
					removedStar = this._element[index];
					foundIndex = index;
					found = true;
				}
			}
		}
		if(!found)
		{
			return null;
		}
		else
		{
			for(int i = foundIndex; i<this._size-1; i++)
			{
				this._element[i] = this._element[i+1];
			}
			this._element[--this._size] = null;
			return removedStar;
		}
	}
	public Star removeAny()
	{
		Star removedStar = null;
		if(this.isEmpty())
			return null;
		else
		{
			removedStar = this._element[--this._size];
			return removedStar;
		}
	}
	public void clear()
	{
		for(int i=0;i<this._size;i++)
			this._element[i] = null;
		this._size = 0;
	}
}
