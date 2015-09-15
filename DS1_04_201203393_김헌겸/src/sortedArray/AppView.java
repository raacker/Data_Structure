package sortedArray;


public class AppView {
	public AppView()
	{
		// 입력이 없기 때문에 Scanner 불필요
	}
	
	public void outputResult(int aTestSize, long aTestInsertTime, long aTestFindMaxTime)
	{
		System.out.printf("크기 : %10d \t삽입하기 : %10d \t최대값찾기 : %10d \n",aTestSize,aTestInsertTime,aTestFindMaxTime);
	}
	public void outputMessage(String aString)
	{
		System.out.println(aString);
	}
	
}
