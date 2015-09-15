package measure;

import java.util.Random;

public class DataGenerator {
	private int[] _dataArray;
	private int _dataSize;
	
	public DataGenerator()
	{
		this._dataArray = null;
		this._dataSize = 0;
	}
	public void generateSequentialData(int size)
	{
		this._dataArray = new int[size];
		this._dataArray[0] = -1;
		this._dataSize = size;
		
		for(int index = 1; index < size; index++)
			this._dataArray[index] = index;
	}
	public void generateReverseData(int size)
	{
		this._dataArray = new int[size];
		this._dataArray[0] = -1;
		this._dataSize = size;
		int backCount = size;
		
		for(int index = 1; index < size; index++)
			this._dataArray[index] = backCount--;
	}
	public void generateRandomData(int size)
	{
		this._dataArray = new int[size];
		this._dataArray[0] = -1;
		this._dataSize = size;
		Random random = new Random();
		
		for(int index = 1; index < size; index++)
			this._dataArray[index] = random.nextInt(this._dataSize);
	}
	public int[] getData(int size)
	{
		int[] copyArray = new int[size];
		System.arraycopy(_dataArray, 0, copyArray, 0, size);
		return copyArray;
	}
}
