package sortedArray;

public class UnsortedArrayBag {
	private static final int DEFAULT_MAX_SIZE = 1000;
	private int _maxSize;
	private int _size;
	private Coin _elements[];
	
	public UnsortedArrayBag()
	{
		this._maxSize = UnsortedArrayBag.DEFAULT_MAX_SIZE;
		this._elements = new Coin[_maxSize];
		this._size = 0;
	}
	public UnsortedArrayBag(int givenMaxSize)
	{
		this._maxSize = givenMaxSize;
		this._elements = new Coin[_maxSize];
		this._size = 0;
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
	public boolean doesContain(Coin anElement)
	{
		boolean found = false;
		for(int i = 0; i<this._size && !found; i++)
		{
			if(this._elements[i].equals(anElement))
					found = true;
		}
		return found;
	}
	public int frequencyOf(Coin anElement)
	{
		int frequencyCount = 0;
		for(int i = 0; i<this._size; i++)
		{
			if(this._elements[i].equals(anElement))
				frequencyCount++;
		}
		return frequencyCount;
	}
	public int maxElementValue()
	{
		int maxValue = this._elements[0].value();
		for(int i=1; i<this._size; i++)
		{
			if(maxValue < this._elements[i].value())
				maxValue = this._elements[i].value();
		}
		return maxValue;
	}
	public Coin maxCoin()
	{
		Coin maxCoin = this._elements[0];
		int maxValue = this._elements[0].value();
		for(int i=1; i<this._size; i++)
		{
			if(maxValue < this._elements[i].value())
			{
				maxValue = this._elements[i].value();
				maxCoin = this._elements[i];
			}
		}
		return maxCoin;
	}
	public int sumElementValues()
	{
		int sumValue = 0;
		for(int i=0; i<this._size; i++)
		{
			sumValue += this._elements[i].value();
		}
		return sumValue;
	}
	public boolean add(Coin anElement)
	{
		if(anElement.value() < 0 || anElement.value() > UnsortedArrayBag.DEFAULT_MAX_SIZE)
			return false;
		if(this.isFull())
			return false;
		else
		{
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
	}
	public boolean remove(Coin anElement)
	{
		boolean found = false;
		int foundIndex=-1;
		if(this.isEmpty())
			return false;
		else
		{
			for(int i = 0; i<this._size && !found; i++)             //foundIndex가 for문을 빠져나갈때 증가후 빠짐.
			{
				if(this._elements[i].equals(anElement)) 
				{
					found = true;
					foundIndex = i;
				}
			}
			if(!found)
				return false;
			else
			{
				for(int i = foundIndex; i<this._size-1; i++)
				{
					this._elements[i] = this._elements[i+1];
				}
				this._elements[this._size-1] = null;
				this._size--;
				return true;
			}
				
		}
	}
	public void clear()
	{
		for(int i = 0; i<this._size; i++)
		{
			this._elements[i] = null;
		}
		this._size = 0;
	}
}
