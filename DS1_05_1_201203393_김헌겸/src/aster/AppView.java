
package aster;

import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	public int inputInt()
	{
//		int	a = _scanner.nextInt();
//		_scanner.nextLine();
//		return a;
		return Integer.parseInt(this._scanner.nextLine());           //숫자가 아닌 값이 입력되었을때 그 값의 검출을 위함. 모든 값을 String으로 받기때문에
																	 // \n문자가 버퍼에 남은 상태로 지워지지 않는 오류를 해결 할 수 있다.
	}
	public String inputString()
	{
		String s = _scanner.nextLine();
		return s;
	}
	public void outputMessage(String aString)
	{
		System.out.print(aString);
	}
	public void outputStar(String aStarName, int aX, int aY)
	{
		System.out.println("X 좌표 : "+aX+"\nY 좌표 : "+aY+"\n별의 이름 : "+aStarName);
	}
	public void outputStarExistence(String aStarName, int aX, int aY)
	{
		if(aStarName == null)
			System.out.printf("(%d,%d) 위치에 별이 존재합니다.\n",aX,aY);
		else
			System.out.printf("%s 별이 존재합니다.\n",aStarName);
	}
	public void outputNumOfStars(int aStarCollectorSize)
	{
		System.out.println(aStarCollectorSize+"개의 별이 존재합니다.\n");
	}
}