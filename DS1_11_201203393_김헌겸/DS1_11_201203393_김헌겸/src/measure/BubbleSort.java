package measure;

public class BubbleSort {
	public BubbleSort()
	{
		
	}
	public void sort(int[] _data, int size)
	{
		for(int i=1; i < size; i++)
		{
			for(int j=1; j < (size-i); j++)
			{
				if(_data[j] > _data[j+1])
					swap(_data,j,j+1);
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
