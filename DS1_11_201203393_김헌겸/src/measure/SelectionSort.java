package measure;

public class SelectionSort {
	public SelectionSort()
	{
		
	}

	public void sort(int[] _data, int size)	
	{
		selectionSort(_data,size-1,size-1);
	}
	private void selectionSort(int[] arr, int left, int right)
	{
		int minIndex;
		
		if(left == 0)
			return;
		
		selectionSort(arr,left-1,right);
		minIndex = minDataPosition(arr, left, right);
		swap(arr,left,minIndex);
	}

	private void swap(int[] arr, int left, int right)
	{
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	private int minDataPosition(int[] arr, int left, int right)
	{
		if(left == right)
			return right;
		int mid = (left+right)/2;
		
		int minLeft = minDataPosition(arr,left,mid);
		int minRight = minDataPosition(arr,mid+1,right);
		return ((arr[minLeft]>arr[minRight]) ? minRight:minLeft);
	}
}
