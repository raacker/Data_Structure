package measure;

import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}

	public void outputMessage(String aMessageString)
	{
		System.out.print(aMessageString);
	}
	public int inputInt()
	{
		return Integer.parseInt(this._scanner.next());
	}
	public int inputMaxDataSize()
	{
		this.outputMessage("Insert Max Data Size >> ");
		return this.inputInt();
	}
	public int inputDataTerm()
	{
		this.outputMessage("Insert Data Term >> ");
		return this.inputInt();
	}
	public int inputSortType()
	{
		return this.inputInt();
	}
	public void outputResult(int dataSize, double insertionSortDuration, double quickSortDuration,
			double selectionSortDuration, double bubbleSortDuration)
	{
		System.out.printf("%-13d%-13.0f%-13.0f%-13.0f%-13.0f\n",dataSize,insertionSortDuration,quickSortDuration,selectionSortDuration,bubbleSortDuration);	
	}
	
	
}
