package measure;

public class QuickSort {
	public QuickSort()
	{
		
	}
	public void sort(int[] _data, int size)
	{
		int maxPos = maxDataPosition(_data, 1, size-1);
		swap(_data, size-1, maxPos);
		
		quickSort(_data, 1, size-2);
	}
	
	private void quickSort(int[] arr, int left, int right)
	{
		int mid;
		if(left < right)
		{
			mid = pivotPartition(arr,left,right);

			quickSort(arr,left,mid-1);
			quickSort(arr,mid+1,right);
		}
	}
	private int pivotPartition(int[] arr, int left, int right)
	{
		int pivot = left;
		right++;
		do
		{
			while(arr[++left] < arr[pivot]);
			while(arr[--right] > arr[pivot]);
			if(left < right)
				swap(arr,left,right);
		}while(left<right);
		swap(arr,pivot,right);
		
		return pivot;
	}
	
	private void swap(int[] arr, int left, int right)
	{
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	private int maxDataPosition(int[] arr, int left, int right)
	{
		if(left == right)
			return right;
		int mid = (left+right)/2;
		
		int maxLeft = maxDataPosition(arr,left,mid);
		int maxRight = maxDataPosition(arr,mid+1,right);
		return ((arr[maxLeft]<arr[maxRight]) ? maxRight:maxLeft);
	}
	
}
