package measure;

public class InsertionSort {
	
	public InsertionSort()
	{
		
	}
	public void sort(int[] _data, int size)
	{
		int left = 0, right = 0;
		
		for(int index = 1; index < size-1; index++)
		{
			left = index;
			right = index+1;
			
			while(_data[left] > _data[right])
			{
				swap(_data,left,right);
				left--;
				right--;
			}
		}
	}
	private void swap(int[] arr, int left, int right)
	{
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
