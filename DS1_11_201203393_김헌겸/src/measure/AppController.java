package measure;

public class AppController {
	private AppView _appView;
	private int[] _data;
	private DataGenerator _dataGenerator;
	private PerformanceMeasurement _pmMeasurement;
	private double _insertionSortDuration;
	private double _quickSortDuration;
	private double _selectionSortDuration;
	private double _bubbleSortDuration;
	private int _sortType;
	
	private int _maxDataSize;
	private int _dataTerm;
	
	public AppController()
	{
		this._appView = new AppView();
		this._dataGenerator = new DataGenerator();
		this._pmMeasurement = new PerformanceMeasurement();
	}
	public void run()
	{
		this.showMessage(MessageID.Notice_StartProgram);
		this._sortType = 0;
		
		this._maxDataSize = this._appView.inputMaxDataSize();
		this._dataTerm = this._appView.inputDataTerm();
		
		do
		{
			try
			{
				this.showMessage(MessageID.Notice_Menu);
				this._sortType = this._appView.inputSortType();
				
				if(this._sortType == 1)
				{
					this._dataGenerator.generateSequentialData(this._maxDataSize);
					this.showMessage(MessageID.Notice_SequentialData);
				}
				else if(this._sortType == 2)
				{
					this._dataGenerator.generateReverseData(this._maxDataSize);
					this.showMessage(MessageID.Notice_ReverseData);
				}
				else if(this._sortType == 3)
				{
					this._dataGenerator.generateRandomData(this._maxDataSize);
					this.showMessage(MessageID.Notice_RandomData);
				}
				else if(this._sortType == 4)
					break;
				else
				{
					this.showMessage(MessageID.Error_WrongMenu);
					continue;
				}
				
				this.showMessage(MessageID.Notice_ShowTitle);
				
				this.doTest(this._dataTerm);	//DEMO test
				
				for(int dataSize = this._dataTerm; dataSize <= this._maxDataSize; dataSize += this._dataTerm)	//Actual Test
				{
					this.doTest(dataSize);
					this._appView.outputResult(dataSize, this._insertionSortDuration, this._quickSortDuration, this._selectionSortDuration, this._bubbleSortDuration);
				}
			}
			catch(Exception e)
			{
				this._appView.outputMessage("ERROR occured : "+e.getMessage());
				e.printStackTrace();
				continue;
			}
		}while(true);
		
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	private void doTest(int dataSize)
	{
		this._insertionSortDuration = 0;		//insertionSort 계산
		for(int index = 0; index < this._maxDataSize; index++)
		{
			this._data = this._dataGenerator.getData(dataSize);
			this._insertionSortDuration += this._pmMeasurement.testInsertionSort(this._data, dataSize);
		}
		this._insertionSortDuration = this._insertionSortDuration/this._maxDataSize;
		
		
		this._quickSortDuration = 0;		//quickSort 계산
		for(int index = 0; index < this._maxDataSize; index++)
		{
			this._data = this._dataGenerator.getData(dataSize);
			this._quickSortDuration += this._pmMeasurement.testQuickSort(this._data, dataSize);
		}
		this._quickSortDuration = this._quickSortDuration/this._maxDataSize;
		
		
		this._selectionSortDuration = 0;		//selectionSort 계산
		for(int index = 0; index < this._maxDataSize; index++)
		{
			this._data = this._dataGenerator.getData(dataSize);
			this._selectionSortDuration += this._pmMeasurement.testSelectionSort(this._data, dataSize);
		}
		this._selectionSortDuration = this._selectionSortDuration/this._maxDataSize;
		
		
		this._bubbleSortDuration = 0;		//bubbleSort 계산
		for(int index = 0; index < this._maxDataSize; index++)
		{
			this._data = this._dataGenerator.getData(dataSize);
			this._bubbleSortDuration += this._pmMeasurement.testBubbleSort(this._data, dataSize);
		}
		this._bubbleSortDuration = this._bubbleSortDuration/this._maxDataSize;
		
	}
	public void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("< 정렬에 따른 실행 성능 차이 알아보기 >\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("< 성능 측정을 종료합니다 > \n");
			break;
		case Notice_Menu:
			this._appView.outputMessage("[1] Sequential Data\n[2] Reverse Data\n[3] Random Data\n[4] End\nSelect a Sort >> ");
			break;
		case Notice_SequentialData:
			this._appView.outputMessage("=== SEQUENTIAL DATA ===\n");
			break;
		case Notice_ReverseData:
			this._appView.outputMessage("=== REVERSE DATA ===\n");
			break;
		case Notice_RandomData:
			this._appView.outputMessage("=== RANDOM DATA ===\n");
			break;
		case Notice_ShowTitle:
			this._appView.outputMessage("DataSize     Insertion    Quick        Selection    Bubble\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("잘못된 입력입니다.\n");
			break;
		}
	}
}
