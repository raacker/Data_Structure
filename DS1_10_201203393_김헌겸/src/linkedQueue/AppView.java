package linkedQueue;
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
		this.outputMessage("- 문자를 입력하세요 : ");
		return this.inputString().charAt(0);
	}
	public void outputMessage(String aMessageString)
	{
		System.out.print(aMessageString);
	}

	public void outputEachElement(char anElement)
	{
		this.outputMessage(anElement+" ");
	}
	public void outputFrontElement(char anElement)
	{
		this.outputMessage("[Front] 맨 앞 원소는 "+anElement+"입니다.\n");
	}
	public void outputQueueSize(int aQueueSize)
	{
		this.outputMessage("[Size] 큐에는 현재 "+aQueueSize+"개의 원소가 있습니다.\n");
	}	
	public void outputAddElement(char anElement)
	{
		this.outputMessage("[EnQueue] 삽입된 원소는 "+anElement+"입니다.\n");
	}
	public void outputRemoveElement(char anElement)
	{
		this.outputMessage("[DeQueue] 삭제된 원소는 "+anElement+"입니다.\n");
	}
	public void outputRemoveN(int aNumOfCharsToBeRemoved)
	{
		this.outputMessage("[RemoveN] "+aNumOfCharsToBeRemoved+"개의 원소를 삭제하려고 합니다.\n");
	}
	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars, int aNumOfAddedChars)
	{
		this.outputMessage("... . . 입력된 문자는 총 "+aNumOfInputChars+"개 입니다.\n"+
				   "... . . 정상 처리된 문자는 "+(aNumOfInputChars-aNumOfIgnoredChars)+"개 입니다.\n"+
				   "... . . 무시된 문자는 "+aNumOfIgnoredChars+"개 입니다.\n"+
				   "... . . 삽입된 문자는 "+aNumOfAddedChars+"개 입니다.\n\n");	
	}
}
