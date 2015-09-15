package dictionary;

public class SortedLinkedListDictionary<Key extends Comparable<Key>, Obj> {
	private static final int DEFAULT_INITIAL_CAPACITY = 20;
	private int _maxSize;
	private int _size;
	private Node<Key,Obj> _head;
	
	public SortedLinkedListDictionary()
	{
		this(SortedLinkedListDictionary.DEFAULT_INITIAL_CAPACITY);
	}
	public SortedLinkedListDictionary(int aMaxCapacity)
	{
		this._size = 0;
		this._maxSize = aMaxCapacity;
		this._head = null;
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

	public boolean keyDoesExist(Key aKey)
	{
		if(this.isEmpty())
			return false;
		
		boolean found = false;
		Node<Key,Obj> currentNode = this._head;
		
		while((currentNode != null) && !found)
		{
			if(currentNode.key().compareTo(aKey) == 0)
				found = true;
			else
				currentNode = currentNode.next();
		}
		return found;
	}
	public Obj objectForKey(Key aKey)
	{
		if(this.isEmpty())
			return null;
		
		Obj returnObject = null;
		boolean found = false;
		Node<Key, Obj> currentNode = this._head;
		
		while((currentNode != null) && !found)
		{
			if(currentNode.key().compareTo(aKey) == 0)
			{
				returnObject = currentNode.object();
				found = true;
			}
			else
				currentNode = currentNode.next();
		}
		return returnObject;
	}
	public boolean addKeyAndObject(Key aKey, Obj anObject)
	{
		if(this.isFull())
			return false;
		if(this.keyDoesExist(aKey))
			return false;
		
		Node<Key, Obj> currentNode = this._head;
		Node<Key, Obj> previousNode = null;
		
		while(currentNode != null)
		{
			if(currentNode.key().compareTo(aKey) > 0)
				break;
			else
			{
				previousNode = currentNode;
				currentNode = currentNode.next();
			}
		}
		
		Node<Key, Obj> newNode = new Node<Key, Obj>(aKey, anObject);
		if(currentNode == this._head)
		{
			if(!(this._head == null))
				newNode.setNext(this._head.next());
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
	public Obj removeObjectForKey(Key aKey)
	{
		if(this.isEmpty())
			return null;
		
		Node<Key, Obj> currentNode = this._head;
		Node<Key, Obj> previousNode = null;
		Obj removedObject = null;
		
		while(currentNode != null)
		{
			if(currentNode.key().compareTo(aKey) == 0)
			{
				removedObject = currentNode.object();
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		
		if(removedObject != null)
		{
			if(currentNode == this._head)
				this._head = this._head.next();
			else
				previousNode.setNext(currentNode.next());
			this._size--;
		}

		return removedObject;
	}
	public boolean replaceObjectForKey(Obj newObject, Key aKey)
	{
		if(this.isEmpty())
			return false;
		
		Node<Key, Obj> currentNode = this._head;
		while(currentNode != null)
		{
			if(currentNode.key().compareTo(aKey) == 0)
			{
				currentNode.setObject(newObject);
				return true;
			}
			currentNode = currentNode.next();
		}
		return false;
	}
	public void clear()
	{
		this._size = 0;
		this._head = null;
	}
}
