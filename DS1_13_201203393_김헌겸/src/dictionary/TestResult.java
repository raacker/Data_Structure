package dictionary;

public class TestResult {
	private int _testSize;
	private double _testAddTime;
	private double _testSearchTime;
	private double _testRemoveTime;
	
	public TestResult()
	{
		//empty
	}
	public TestResult(int testSize, double insertTime, double searchTime, double removeTime)
	{
		this._testSize = testSize;
		this._testAddTime = insertTime;
		this._testSearchTime = searchTime;
		this._testRemoveTime = removeTime;
	}
	
	public int testSize()
	{
		return this._testSize;
	}
	public void setTestSize(int aTestSize)
	{
		this._testSize = aTestSize;
	}
	
	public double testInsertTime()
	{
		return this._testAddTime;
	}
	public void setTestInsertTime(double aTestInsertTime)
	{
		this._testAddTime = aTestInsertTime;
	}
	
	public double testSearchTime()
	{
		return this._testSearchTime;
	}
	public void setTestSearchTime(double aTestSearchTime)
	{
		this._testSearchTime = aTestSearchTime;
	}
	
	public double testRemoveTime()
	{
		return this._testRemoveTime;
	}
	public void setTestRemoveTime(double aTestRemoveTime)
	{
		this._testRemoveTime = aTestRemoveTime;
	}
}
