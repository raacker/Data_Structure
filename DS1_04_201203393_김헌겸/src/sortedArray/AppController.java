package sortedArray;

public class AppController {
	private AppView _appView;
	private PerformanceMeasurement _pml;

	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		
		this._pml = new PerformanceMeasurement();
		this.showMessage(MessageID.Notice_StartProgram);
		this._pml.generateData();

		this.showMessage(MessageID.Notice_SortedArrayStart);
		this._pml.testSortedArrayBag();
		this.showAllOfTestResult();
		
	/*	this.showMessage(MessageID.Notice_UnsortedArrayStart);
		this._pml.testUnsortedArrayBag();
		this.showAllOfTestResult();
		
		this.showMessage(MessageID.Notice_UnsortedLinkedStart);
		this._pml.testUnsortedLinkedBag();
		this.showAllOfTestResult();
		
		this.showMessage(MessageID.Notice_SortedLinkedStart);
		this._pml.testSortedLinkedBag();
		this.showAllOfTestResult();
		*/
		this.showMessage(MessageID.Notice_EndProgram);
	}

	private void showAllOfTestResult()
	{
		TestResult[] testResult = this._pml.testResult();
		for(int index = 0; index < this._pml.numOfTests();index++)
		{
			this._appView.outputResult(testResult[index].testSize(),testResult[index].testInsertTime(),testResult[index].testFindMaxTime());
		}
	}
	
	
/*	
	private void showAllOfTotalResult()            // 평균치를 구하기 위하여 추가된 total메소드 총합데이터를 얻어서 평균값을 출력한다
	{
		TotalResult[] totalResult = this._pml.getTotalResult();
		TestResult[] testResult = new TestResult[this._pml.numOfTests()];
		for(int index=0;index<this._pml.numOfTests();index++)
		{
			testResult[index] = totalResult[index].getData(this._pml.numOfTests());
			this._appView.outputResult(testResult[index].testSize(),testResult[index].testInsertTime(),testResult[index].testFindMaxTime());
		}
	}
*/
	
	
	private void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("<< List의 구현에 따른 실행 성능 차이 알아보기 >>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("<< 성능 측정을 종료합니다 >>\n");
			break;
		case Notice_UnsortedArrayStart:
			this._appView.outputMessage("[Unsorted Array]\n");
			break;
		case Notice_SortedArrayStart:
			this._appView.outputMessage("[Sorted Array]\n");
			break;
		case Notice_UnsortedLinkedStart:
			this._appView.outputMessage("[Unsorted Linked List]\n");
			break;
		case Notice_SortedLinkedStart:
			this._appView.outputMessage("[Sorted Linked List]\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("<<ERROR: 잘못된 메뉴입니다.>>\n");
			break;
		
		default:
			break;
		}
	}
}
