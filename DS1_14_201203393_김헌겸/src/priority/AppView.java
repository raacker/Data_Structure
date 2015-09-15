package priority;

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
		this.outputMessage("? 해야 할 일의 코드를 치시오 : ");
		return this.inputString().charAt(0);
	}
	public int inputInteger()
	{
		this.outputMessage(" - 삽입할 정수값을 입력하시오 : ");
		return Integer.parseInt(this.inputString());
	}
	
	public void outputSize(int aInteger)
	{
		this.outputMessage("- Priorty Queue에는 "+aInteger+"개의 원소가 들어 있습니다.\n");
	}
	public void outputElement(int aInteger)
	{
		this.outputMessage(aInteger+" ");
	}
	public void outputRandomAdd(int aInteger)
	{
		this.outputMessage("- 임의의 원소가 "+aInteger+"개 입력되었습니다.\n");
	}
	public void outputAddElement(int aInteger)
	{
		this.outputMessage(aInteger+"이 정상적으로 입력되었습니다.\n");
	}
	public void outputRemoveElement(int aInteger)
	{
		this.outputMessage("- 최대값 "+aInteger+"이 삭제되었습니다.\n");
	}
	public void outputMaxElement(int aInteger)
	{
		this.outputMessage("- Priority Queue의 최대값은 "+aInteger+"입니다.\n");
	}
	public void outputMessage(String aString)
	{
		System.out.print(aString);
	}
	
}
