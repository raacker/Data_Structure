package aster;

public class LinkedSet {
//	private static final int DEFAULT_MAX_SIZE = 100;
//	private int _maxSize;
	
	private int _size;
	private Node _head;
	
	public LinkedSet()
	{
//		this._maxSize = LinkedSet.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._head = null;
	}
/*	
  	public LinkedSet(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._head = null;
	}
*/
	public int size()
	{
		return this._size;
	}
	public boolean isEmpty()
	{
		return (this._size == 0);
	}
	
/*	
    public boolean isFull()
	{
		return (this._size == this._maxSize);
	}
*/
	public boolean doesContain(Star anElement)
	{
		boolean found = false;
		Node currentNode = this._head;
		
		if(isEmpty())
			return false;
		
		while((currentNode != null) && !found)
		{
			if(currentNode.element().equals(anElement))
				found = true;
			currentNode = currentNode.next();
		}
		return found;
	}
	public boolean add(Star anElement)
	{
		if(this.doesContain(anElement))
			return false;
		else
		{
			Node newNode = new Node(anElement);
			newNode.setNext(this._head);
			this._head = newNode;
			this._size++;
			return true;
		}
	}
	public Star remove(Star anElement)
	{
		Node currentNode = this._head;
		Node previousNode = this._head;
		Star removedStar = null;
		boolean found = false;
		
		if(isEmpty())
			return null;
		else
		{
			while((currentNode != null) && !found)
			{
				if(currentNode.element().equals(anElement))
				{
					found = true;
					removedStar = currentNode.element();
				}
				else
				{
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
		}
		if(!found)
		{
			return null;
		}
		else	
		{
			if(currentNode == this._head)
				this._head = this._head.next();
			else
				previousNode.setNext(currentNode.next());
			this._size--;
		}
		return removedStar;
	}
	public Star removeAny()
	{
		Star removedStar = null;
		
		if(isEmpty())
			return null;
		else
		{
			removedStar = this._head.element();
			this._head = this._head.next();
			this._size--;
		}
		return removedStar;
	}
	public void clear()
	{
		while(this.removeAny() != null);
		this._size = 0;
	}
}
