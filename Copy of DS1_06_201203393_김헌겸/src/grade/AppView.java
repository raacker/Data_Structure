package grade;

import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	public int inputInt()
	{
		this._scanner.nextLine();
		return Integer.parseInt(this._scanner.nextLine());      //Wrapper클래스의 parseInt메소드를 이용하여 정수가 아닌 잘못된 값이 전달되었을떄
		                                                        //오류검출 및 정확한 값 입력을 위함
	}
	public String inputString()
	{
		//String a = this._scanner.nextLine();
		String a = this._scanner.nextLine();						//입력시 단일 엔터를 입력했을 경우 아무값도 없는 String으로 처리되므로 각각의 값에 대해 입력받음
		return a;
	}
	public void outputMessage(String aMessageString)
	{
		System.out.print(aMessageString);
	}
	public Boolean inputDoesContinueToInputNextStudent()
	{
		char answer;
		String input;
		System.out.print("성적을 입력하려면 'Y'를, 종료하려면 다른 아무 키나 치시오 : ");
		input = this.inputString();
		if(input.length() == 0 || input == null)
			return false;
		else
			answer = input.charAt(0);
		
		if(answer == 'Y' || answer == 'y')
			return true;
		else
			return false;
	}
	public int inputScore()
	{
		int score;
		System.out.print("- 점수를 입력하시오 : ");
		score = this.inputInt();
		return score;
	}
	public void outputAverageScore(float anAverageScore)
	{
		System.out.printf("평균 점수는 %.1f입니다.\n",anAverageScore);
	}
	public void outputNumberOfStudentsAboveAverage(int aNumber)
	{
		this.outputMessage("평균 이상인 학생은 모두 "+aNumber+"명 입니다.\n");
	}
	public void outputMaxScore(int aMaxScore)
	{
		this.outputMessage("최고점은 "+aMaxScore+"점 입니다.\n");
	}
	public void outputMinScore(int aMinScore)
	{
		this.outputMessage("최저점은 "+aMinScore+"점 입니다.\n");
	}
	public void outputGradeCountFor(char aGrade, int aCount)
	{
		this.outputMessage(aGrade+"학점은 모두 "+aCount+"명 입니다.\n");
	}
	public void outputStudentInfo(int aScore)
	{
		this.outputMessage("점수 : "+aScore+"\n");
	}
}
	
