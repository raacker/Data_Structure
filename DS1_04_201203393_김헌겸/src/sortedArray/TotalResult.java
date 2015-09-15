package sortedArray;

/*
 * 각각의 크기에 대하여 실행결과를 종합하고 실행 횟수만큼 나누어서 평균수치를 구함 
 *
 */
public class TotalResult{ 
	private int _totalSize;
	private long _totalAddTime;
	private long _totalMaxTime;
	
	public TotalResult()
	{
		this._totalSize = 0;
		this._totalAddTime = 0;
		this._totalMaxTime = 0;
	}
	
	public void setData(int size, long addTime, long maxTime)
	{
		this._totalSize += size;
		this._totalAddTime += addTime;
		this._totalMaxTime += maxTime;
	}
	
	public int totalSize()
	{
		return this._totalSize;
	}
	public long totalAddTime()
	{
		return this._totalAddTime;
	}
	public long totalMaxTime()
	{
		return this._totalMaxTime;
	}
	
	public TestResult getData(int dividingNumber)
	{
		return new TestResult(this._totalSize/dividingNumber,this._totalAddTime/dividingNumber,this._totalMaxTime/dividingNumber);       
			//테스트를 실행한 만큼의 값을 매개변수로 전달하여 평균값을 만든뒤 TestResult 객체를 생성한다. 
	}
}
