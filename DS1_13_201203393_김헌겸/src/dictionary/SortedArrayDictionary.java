package dictionary;

public class SortedArrayDictionary<Key extends Comparable<Key>, Obj> {
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private Element<Key, Obj>[] _element;
	
	public SortedArrayDictionary()
	{
		this(SortedArrayDictionary.DEFAULT_MAX_SIZE);
	}
	@SuppressWarnings("unchecked")
	public SortedArrayDictionary(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = new Element[this._maxSize];
	}
	
	public boolean isEmpty()
	{
		return (this._size == 0);
	}
	public boolean isFull()
	{
		return (this._size == this._maxSize);
	}
	public int size()
	{
		return this._size;
	}
	
	public boolean KeyDoesExist(Key aKey)
	{
		boolean found = false;
		for(int index = 0; (index < this._size) && !found; index++)
		{
			if(this._element[index].key().compareTo(aKey) == 0)
				found = true;
		}
		return found;
	}
	public Obj objectForKey(Key aKey)
	{
		Obj returnObject = null;
		boolean found = false;
		for(int index = 0; (index < this._size) && !found; index++)
		{
			if(this._element[index].key().compareTo(aKey) == 0)
			{
				returnObject = this._element[index].object();
				found = true;
			}
		}
		return returnObject;
	}
	public boolean addKeyAndObject(Key aKey, Obj anObject)
	{
		if(this.isFull())
			return false;
		if(this.KeyDoesExist(aKey))
			return false;
		
		int targetIndex = 0;
		for(int index = 0; index < this._size; index++)
		{
			if(this._element[index].key().compareTo(aKey) < 0)
			{
				targetIndex = index;
				break;
			}
			targetIndex = index;
		}
		if(this._size > 0)
		{
			for(int index = this._size; index > targetIndex; index--)
			{
				this._element[index] = this._element[index-1]; 
			}
		}
		Element<Key,Obj> newElement = new Element<Key,Obj>(aKey,anObject);
		this._element[targetIndex] = newElement;
		this._size++;
		return true;
	}
	public Obj removeObjectForKey(Key aKey)
	{
		if(this.isEmpty())
			return null;
		
		Obj removedObject = null;
		int targetIndex = 0;
		for(int index = 0; index < this._size; index++)
		{
			if(this._element[index].key().compareTo(aKey) == 0)
			{
				removedObject = this._element[index].object();
				targetIndex = index;
				break;
			}
			targetIndex = index;
		}
		
		for(int index = targetIndex; index < this._size-2; index++)
		{
			this._element[index] = this._element[index+1];
		}
		this._element[--this._size] = null;
		return removedObject;
	}
	public boolean replaceObjectForKey(Obj newObject, Key aKey)
	{
		if(this.isEmpty())
			return false;
		
		for(int index = 0; index < this._size; index++)
		{
			if(this._element[index].key().compareTo(aKey) == 0)
			{
				this._element[index].setObject(newObject);	//Key를 찾았다면 object를 바꾸고 true return
				return true;
			}
		}
		return false;   // key값을 통한 object를 찾지 못하였으므로 false
	}
	@SuppressWarnings("unchecked")
	public void clear()
	{
		this._size = 0;
		this._element = (Element<Key,Obj>[]) new Object[this._maxSize];
	}
	
}