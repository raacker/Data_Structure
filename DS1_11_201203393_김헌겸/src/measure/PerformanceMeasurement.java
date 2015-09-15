package measure;

public class PerformanceMeasurement {
	private InsertionSort _insertionSort;
	private QuickSort _quickSort;
	private SelectionSort _selectionSort;
	private BubbleSort _bubbleSort;
	
	
	public PerformanceMeasurement()
	{
		this._insertionSort = new InsertionSort();
		this._quickSort = new QuickSort();
		this._selectionSort = new SelectionSort();
		this._bubbleSort = new BubbleSort();
	}
	
	public double testInsertionSort(int[] data, int dataSize)
	{
		double insertTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._insertionSort.sort(data, dataSize);
		end = System.nanoTime();
		insertTime = (double)(end-start);
		return insertTime;
	}
	public double testQuickSort(int[] data, int dataSize)
	{
		double insertTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._quickSort.sort(data, dataSize);
		end = System.nanoTime();
		insertTime = (double)(end-start);
		return insertTime;
		
	}
	public double testSelectionSort(int[] data, int dataSize)
	{
		double insertTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._selectionSort.sort(data, dataSize);
		end = System.nanoTime();
		insertTime = (double)(end-start);
		return insertTime;
	}
	public double testBubbleSort(int[] data, int dataSize)
	{
		double insertTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._bubbleSort.sort(data, dataSize);
		end = System.nanoTime();
		insertTime = (double)(end-start);
		return insertTime;
	}
}
