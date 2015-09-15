package sortedArray;

import java.util.Random;

public class PerformanceMeasurement {

	private static final int MaxTestSize = 10000;    // 난수로 생성하게 되는 최대 데이터 크기, 최대로 만들 배열요소의 길이    
	private static final int NumOfTests = 5;         // 테스트를 수행할 횟수
	private static final int FirstTestSize = 1000;   // 초기 배열의 크기
	private static final int SizeIncrement = 1000;   // 테스트할 배열의 크기 증가율
	
	private int _maxTestSize;
	private int _numOfTests;
	private int _firstTestSize;
	private int _sizeIncrement;
	
	private TestResult[] _testResult;
	private int[] _data;
	
//	private TotalResult[] _totalTestResult;				  // 결과값을 종합할 배열선언
	
	public PerformanceMeasurement()
	{
		this._maxTestSize = PerformanceMeasurement.MaxTestSize;
		this._numOfTests = PerformanceMeasurement.NumOfTests;
		this._firstTestSize = PerformanceMeasurement.FirstTestSize;
		this._sizeIncrement = PerformanceMeasurement.SizeIncrement;
		
		this._data = new int[this._maxTestSize];
		this._testResult = new TestResult[this._numOfTests];        
		
/*		this._totalTestResult = new TotalResult[this._numOfTests];   // 결과값 배열 인스턴스 생성

		for(int i = 0; i<this._numOfTests; i++)                 //테스트코드 전체 합산한 결과값을 넣기위한 각각 개별 크기 대상 Result인스턴스
		{
			this._totalTestResult[i] = new TotalResult();
		}
*/
	}
	public PerformanceMeasurement(int aMaxTestSize, int aNumOfTests, int aFirstTestSize, int aSizeIncrement)
	{
		this._maxTestSize = aMaxTestSize;
		this._numOfTests = aNumOfTests;
		this._firstTestSize = aFirstTestSize;
		this._sizeIncrement = aSizeIncrement;
	
		this._data = new int[this._maxTestSize];
		this._testResult = new TestResult[this._numOfTests];
		
/*		this._totalTestResult = new TotalResult[this._numOfTests];              //실험코드

		for(int i = 0; i<this._numOfTests; i++)                 //테스트코드 전체 합산한 결과값을 넣기위한 각각 개별 크기 대상 Result인스턴스
		{
			this._totalTestResult[i] = new TotalResult();
		}
*/
	}
	
	public int numOfTests()
	{
		 return this._numOfTests;
	}
	public void generateData()
	{
		int i = 0;
		Random random = new Random();
		while(i < this._maxTestSize)
		{
			this._data[i] = random.nextInt(this._maxTestSize);    //10000 이하의 데이터를 10000개만큼 생성 
			i++;
		}
	}
	public void testUnsortedArrayBag()
	{
		UnsortedArrayBag bag;
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;                      	// 테스트한 데이터 갯수
		int testCount = 0;                        // 테스트한 횟수
		
		testSize = this._firstTestSize;           // 초기 시작 테스트할 데이터 갯수 1000
		
		while(testCount < this._numOfTests)       // 테스트한 횟수 < 5번
		{
			bag = new UnsortedArrayBag();
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize)       // 테스트한 횟수 < 총 테스트할 데이터 갯수
			{
				Coin coin = new Coin(this._data[testDataCount]);

				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += stop - start;         //Add 시간을 계산함
			
				start = System.nanoTime();
				maxCoin = bag.maxCoin();
				stop = System.nanoTime();
				timeForMax += stop - start;		//Max 시간을 계산함
				
				testDataCount++;
			}

//			this._totalTestResult[testCount].setData(testSize, timeForAdd, timeForMax);     
//											//결과값을 총합 배열에 넣고 있다.
		
			this._testResult[testCount] = new TestResult(testSize,timeForAdd,timeForMax);
			testSize += this._sizeIncrement;        // 테스트할 데이터의 갯수를 += 1000
			testCount++;                            // 테스트한 횟수 증가
		}
	}
	
	public void testSortedArrayBag()
	{
		SortedArrayBag bag;
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;
		int testCount = 0;
		
		testSize = this._firstTestSize;
		
		while(testCount < this._numOfTests)
		{
			bag = new SortedArrayBag(testSize);
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize)
			{
				Coin coin = new Coin(this._data[testDataCount]);

				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += stop - start;
			
				start = System.nanoTime();
				maxCoin = bag.maxCoin();
				stop = System.nanoTime();
				timeForMax += stop - start;
				
				
				testDataCount++;
			}

//			this._totalTestResult[testCount].setData(testSize, timeForAdd, timeForMax);               //각각의 결과값을 넣고있다.
	
			this._testResult[testCount] = new TestResult(testSize,timeForAdd,timeForMax);
			testSize += this._sizeIncrement;
			testCount++;
		}
		
	}
	public void testUnsortedLinkedBag()
	{
		UnsortedLinkedBag bag;
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;                        // 테스트한 데이터 갯수
		int testCount = 0;                        // 테스트한 횟수
		
		testSize = this._firstTestSize;           // 초기 시작 테스트할 데이터 갯수 1000
		
		while(testCount < this._numOfTests)       // 테스트한 횟수 < 5번
		{
			bag = new UnsortedLinkedBag();
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize)       // 테스트한 횟수 < 총 테스트할 데이터 갯수
			{
				Coin coin = new Coin(this._data[testDataCount]);

				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += stop - start;
			
				start = System.nanoTime();
				maxCoin = bag.maxCoin();
				stop = System.nanoTime();
				timeForMax += stop - start;
				
				testDataCount++;
			}

//			this._totalTestResult[testCount].setData(testSize, timeForAdd, timeForMax);               //각각의 결과값을 넣고있다.
	
			this._testResult[testCount] = new TestResult(testSize,timeForAdd,timeForMax);
			testSize += this._sizeIncrement;        // 테스트할 데이터의 갯수를 += 1000
			testCount++;                            // 테스트한 횟수 증가
		}
		
	}
	public void testSortedLinkedBag()
	{
		SortedLinkedBag bag;
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;
		int testCount = 0;
		
		testSize = this._firstTestSize;
		
		while(testCount < this._numOfTests)
		{
			bag = new SortedLinkedBag();
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize)
			{
				Coin coin = new Coin(this._data[testDataCount]);

				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += stop - start;
			
				start = System.nanoTime();
				maxCoin = bag.maxCoin();
				stop = System.nanoTime();
				timeForMax += stop - start;
				
				testDataCount++;
			}

//			this._totalTestResult[testCount].setData(testSize, timeForAdd, timeForMax);               //각각의 결과값을 넣고있다.
			this._testResult[testCount] = new TestResult(testSize,timeForAdd,timeForMax);
			testSize += this._sizeIncrement;
			testCount++;
		}
		
	}
	
	public TestResult[] testResult()
	{
		return this._testResult;
	}
	
/*	public TotalResult[] getTotalResult()
	{
		return this._totalTestResult;
	}
*/
}
