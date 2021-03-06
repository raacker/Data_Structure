package grade;

public class GradeCounter {
	private int _numberOfA;
	private int _numberOfB;
	private int _numberOfC;
	private int _numberOfD;
	private int _numberOfF;
	
	public GradeCounter()
	{
		this._numberOfA = 0;
		this._numberOfB = 0;
		this._numberOfC = 0;
		this._numberOfD = 0;
		this._numberOfF = 0;
	}
	public void count(char aGrade)
	{
		switch(aGrade)
		{
		case 'A':
			this._numberOfA++;
			break;
		case 'B':
			this._numberOfB++;
			break;
		case 'C':
			this._numberOfC++;
			break;
		case 'D':
			this._numberOfD++;
			break;
		default:
			this._numberOfF++;
		}
	}
	public int numberOfA()
	{
		return this._numberOfA;
	}
	public int numberOfB()
	{
		return this._numberOfB;
	}
	public int numberOfC()
	{
		return this._numberOfC;
	}
	public int numberOfD()
	{
		return this._numberOfD;
	}
	public int numberOfF()
	{
		return this._numberOfF;
	}
	
}
