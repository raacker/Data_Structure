import java.util.Scanner;


public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	public int inputOrder()
	{
		System.out.print("마방진 차수를 입력하시오(음수를 입력하면 종료합니다): ");
		int order = _scanner.nextInt();
		return order;
	}
	public void outputTitleWithOrder(int anOrder) 
	{
		System.out.printf("Magic Square Board: Order %d\n",anOrder);
	}
	public void outputRowNumber(int aRowNumber)
	{
		System.out.printf("[%3d]", aRowNumber);
	}
	public void outputCell(int anElement)
	{
		System.out.printf("  %3d", anElement);
	}
	public void outputNextLine()
	{
		System.out.println("");
	}
	public void outputMessage(String aMessageString)
	{
		System.out.println(aMessageString);
	}
}
