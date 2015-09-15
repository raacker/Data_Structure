package stack;

import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	public int inputInt()
	{
		return Integer.parseInt(this._scanner.nextLine());
	}
	public String inputString()
	{
		return this._scanner.next();        //입력의 오류 여부 가능성
	}
	public char inputCharacter()
	{
		return this._scanner.nextLine().charAt(0);
	}
	public void outputMessage(String aMessageString)
	{
		System.out.print(aMessageString);
	}
	
	
	public void outputAddedElement(char anElement)
	{
		this.outputMessage("삽입된 원소는 '"+anElement+"'입니다.\n");
	}
	public void outputStackFull(char anElement)
	{
		this.outputMessage("스택이 꽉 차서 원소 '"+anElement+"'는 삽입이 불가능합니다.\n");
	}
	public void outputStackElement(char anElement)
	{
		this.outputMessage(anElement+" ");
	}
	public void outputTopElement(char anElement)
	{
		this.outputMessage("Top 원소는 '"+anElement+"'입니다.\n");
	}
	public void outputStackSize(int aStackSize)
	{
		this.outputMessage("스택에는 현재 "+aStackSize+"개의 원소가 있습니다.\n");
	}
	public void outputRemove(char anElement)
	{
		this.outputMessage("삭제된 원소는 '"+anElement+"'입니다.\n");
	}
	public void outputRemoveN(int aNumOfCharsToBeRemoved)
	{
		this.outputMessage(aNumOfCharsToBeRemoved+"개의 원소를 삭제하려고 합니다.\n");
	}
	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars, int aNumOfAddedChars)
	{
		this.outputMessage("... . . 입력된 문자는 총 "+aNumOfInputChars+"개 입니다.\n"+
						   "... . . 정상 처리된 문자는 "+(aNumOfInputChars-aNumOfIgnoredChars)+"개 입니다.\n"+
						   "... . . 무시된 문자는 "+aNumOfIgnoredChars+"개 입니다.\n"+
						   "... . . 삽입된 문자는 "+aNumOfAddedChars+"개 입니다.\n\n");							
	}
	
}
