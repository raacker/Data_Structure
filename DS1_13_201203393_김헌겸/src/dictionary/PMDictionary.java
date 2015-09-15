package dictionary;

import java.util.Random;

public class PMDictionary {
	private int _maxTestSize;
	private Element<Integer,Integer>[] _element;
	
	@SuppressWarnings("unchecked")
	public PMDictionary(int aMaxSize)
	{
		this._maxTestSize = aMaxSize;
		this._element = new Element[this._maxTestSize];
	}
	
	public void generateData()
	{
		Random random = new Random();
		int currentSize = 0;
		
		while(currentSize < this._maxTestSize)
		{
			int newData = random.nextInt(this._maxTestSize);
			if(!this.givenDataDoesExist(newData, currentSize))
			{
				Element<Integer, Integer> newElement = new Element<Integer, Integer>(newData, currentSize);
				this._element[currentSize] = newElement;
				currentSize++;
			}
		}
	}
	
	private boolean givenDataDoesExist(int newData, int currentDataSize)
	{
		for(int index = 0; index < currentDataSize; index++)
		{
			if(this._element[index].key().compareTo(newData) == 0)
				return true;
		}
		return false;
	}
	
	public TestResult doSortedArray(int testSize)
	{
		SortedArrayDictionary<Integer, Integer> dic =
				new SortedArrayDictionary<Integer, Integer>(this._maxTestSize);
		
		double timeForAdd, timeForSearch, timeForRemove;
		double start,stop;
		
		timeForAdd = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			start = System.nanoTime();
			dic.addKeyAndObject(this._element[testCount].key(), this._element[testCount].object());
			stop = System.nanoTime();
			timeForAdd += (stop - start);
		}
		
		timeForSearch = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			//Integer searchObject;
			start = System.nanoTime();
			//searchObject = 
			dic.objectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForSearch += (stop - start);
		}
		
		timeForRemove = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			//Integer removeObject;
			start = System.nanoTime();
			//removeObject = 
			dic.removeObjectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForRemove += (stop - start);
		}
		
		return new TestResult(testSize, timeForAdd, timeForSearch, timeForRemove);
	}
	
	public TestResult doSortedLinkedList(int testSize)
	{
		SortedLinkedListDictionary<Integer, Integer> dic =
				new SortedLinkedListDictionary<Integer, Integer>(this._maxTestSize);
		
		double timeForAdd, timeForSearch, timeForRemove;
		double start,stop;
		
		timeForAdd = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			start = System.nanoTime();
			dic.addKeyAndObject(this._element[testCount].key(), this._element[testCount].object());
			stop = System.nanoTime();
			timeForAdd += (stop - start);
		}
		
		timeForSearch = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			//Integer searchObject;
			start = System.nanoTime();
			//searchObject = 
			dic.objectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForSearch += (stop - start);
		}
		
		timeForRemove = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			//Integer removeObject;
			start = System.nanoTime();
			//removeObject = 
			dic.removeObjectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForRemove += (stop - start);
		}
		
		return new TestResult(testSize, timeForAdd, timeForSearch, timeForRemove);
	}
	
	public TestResult doBinarySearchTree(int testSize)
	{
		BinarySearchTree<Integer, Integer> dic =
				new BinarySearchTree<Integer, Integer>();
		
		double timeForAdd, timeForSearch, timeForRemove;
		double start,stop;
		
		timeForAdd = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			start = System.nanoTime();
			dic.addKeyAndObject(this._element[testCount].key(), this._element[testCount].object());
			stop = System.nanoTime();
			timeForAdd += (stop - start);
		}
		
		timeForSearch = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			//Integer searchObject;
			start = System.nanoTime();
			//searchObject = 
			dic.objectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForSearch += (stop - start);
		}
		
		timeForRemove = 0;
		for(int testCount = 0; testCount < testSize; testCount++)
		{
			//Integer removeObject;
			start = System.nanoTime();
			//removeObject = 
			dic.removeObjectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForRemove += (stop - start);
		}
		
		return new TestResult(testSize, timeForAdd, timeForSearch, timeForRemove);
	}
}
