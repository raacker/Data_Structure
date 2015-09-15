package postfix;

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
	public void outputMessage(String aMessage)
	{
		System.out.print(aMessage);
	}
	public String inputExpression()
	{
		this.outputMessage("\n> 수식을 입력하시오 : ");
		return this.inputString();
	}
	public void outputResult(double aValue)
	{
		this.outputMessage("\n[최종값] "+aValue+"\n");
	}
	public void outputPostfix(String aPostfix)
	{
		this.outputMessage("\n[Postfix] "+aPostfix+"\n");
	}

}
