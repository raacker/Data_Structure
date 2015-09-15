package sortedArray;

public class UnsortedLinkedBag {
	private int _size;
	private Node _head;
	
	public UnsortedLinkedBag()
	{
		this._size = 0;
		this._head = null;
	}
	public int size()
	{
		return this._size;
	}
	public boolean isEmpty()
	{
		return  ((this._head == null) || (this._size == 0));
	}
	public boolean doesContain(Coin anElement)
	{
		boolean found = false;
		
		Node searchNode = this._head;
		while(searchNode != null && !found)
		{
			if(searchNode.element().equals(anElement))
				found = true;
			searchNode = searchNode.next();
		}
		return found;
	}
	public int frequencyOf(Coin anElement)
	{
		Node searchNode = this._head;
		int frequencyCount = 0;
		
		while(searchNode != null)
		{
			if(searchNode.element().equals(anElement))
				frequencyCount++;
			searchNode = searchNode.next();
		}
		return frequencyCount;
	}
	public int maxElementValue()
	{
		Node searchNode = this._head;
		int maxValue = 0;
		while(searchNode != null)
		{
			if(searchNode.element().value() > maxValue)
				maxValue = searchNode.element().value();
			searchNode = searchNode.next();
		}
		return maxValue;
	}
	public Coin maxCoin()
	{
		Node searchNode = this._head;
		int maxValue = 0;
		Coin maxCoin = this._head.element();
		while(searchNode != null)
		{
			if(searchNode.element().value() > maxValue)
			{
				maxValue = searchNode.element().value();
				maxCoin = searchNode.element();
			}
			searchNode = searchNode.next();
		}
		return maxCoin;
	}
	
	public int sumElementValues()
	{
		Node searchNode = this._head;
		int sumValues = 0;
		while(searchNode != null)
		{
			sumValues += searchNode.element().value();
			searchNode = searchNode.next();
		}
		return sumValues;
	}
	public void clear()
	{
		this._size = 0;
		this._head = null;
	}
	
	public boolean add(Coin anElement)
	{
		Node newNode = new Node(anElement);
		newNode.setNext(this._head);
		this._head = newNode;
		this._size++;
		return true;
	}
	public boolean remove(Coin anElement)
	{
		if(this.isEmpty())
		{
			return false;
		}
		else
		{
			Node previousNode = null;
			Node currentNode = this._head;
			boolean found = false;
			
			while(currentNode != null && !found)
			{
				if(currentNode.element().equals(anElement))
				{
					found = true;
				}
				else
				{
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			if(!found)
			{
				return false;
			}
			else
			{
				if(currentNode == this._head)
					this._head = this._head.next();
				else
				{
					previousNode.setNext(currentNode.next());
				}
				this._size--;
				return true;
			}
		}
	}
	public Coin removeAny()
	{
		if(this.isEmpty())
			return null;
		else
		{
			Coin removedElement = this._head.element();
			this._head = this._head.next();
			this._size--;
			return removedElement;
		}
	}
}
