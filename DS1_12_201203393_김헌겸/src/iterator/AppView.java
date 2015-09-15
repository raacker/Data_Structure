package iterator;

import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	public String inputString()
	{
		return this._scanner.next();
	}
	public char inputCharacter()
	{
		this.outputMessage("> 문자를 입력하시오 : ");
		return this.inputString().charAt(0);
	}
	public int inputNumber()
	{
		this.outputMessage(">>> 숫자를 입력하시오 : ");
		return Integer.parseInt(this.inputString());
	}
	
	public void outputSize(int size)
	{
		this.outputMessage("[Length] 리스트애는 현재 "+size+"개가 있습니다.\n");
	}
	public void outputAdd(int anElement)
	{
		this.outputMessage("[Insert] 삽입된 원소는 "+anElement+"입니다.\n");
	}
	public void outputRemove(int anElement)
	{
		this.outputMessage("[Delete] 삭제된 원소는 "+anElement+"입니다.\n");
	}
	public void outputElement(int anElement)
	{
		this.outputMessage(anElement+" ");
	}
	
	public void outputMessage(String aMessageString)
	{
		System.out.print(aMessageString);
	}
}
