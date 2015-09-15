package linkedChain;

import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	public int inputInt()
	{
		int _value = _scanner.nextInt();
		_scanner.nextLine();
		return _value;
	}
	
	public void outputRemove(int removedCoin)
	{
		System.out.println("삭제된 코인: "+removedCoin);
	}

	public void outputResult(int aTotalCoinSize, int aMaxCoinValue, int aSumOfCoinValue)
	{
		System.out.println("총 코인: "+aTotalCoinSize);
		System.out.println("가장 큰 코인: "+aMaxCoinValue);
		System.out.println("코인의 합: "+aSumOfCoinValue);
	}
	public void outputSearch(int aSearchValue, int aSearchedSize)
	{
		System.out.printf("%d코인은 %d개 존재합니다.\n",aSearchValue,aSearchedSize);
	}
	public void outputMessage(String aMessageString)
	{
		System.out.print(aMessageString);
	}
}

