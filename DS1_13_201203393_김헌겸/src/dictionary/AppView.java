package dictionary;

import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	public char inputTree()
	{
		return this.inputCharacter();
	}
	public char inputCharacter()
	{
		return this._scanner.nextLine().charAt(0);
	}
	
	public void outputResult(int aTestSize, double aTestInsertTime, double aTestSearchTime, double aTestRemoveTime)
	{
		System.out.printf("크기: %-5d 삽입: %-13.1f 검색: %-13.1f 삭제: %-13.1f\n",aTestSize,aTestInsertTime,aTestSearchTime,aTestRemoveTime);
	}
	public void outputMessage(String aMessageString)
	{
		System.out.print(aMessageString);
	}
	public void nextLine()
	{
		System.out.println("");
	}
	
	public void outputDictionary(String producedString)
	{
		this.outputMessage(producedString);
	}
	public void outputTraverse(char anObj)
	{
		this.outputMessage(anObj+"-");
	}
}
