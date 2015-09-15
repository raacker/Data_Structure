package grade;

public class Ban {
	private static final int DEFAULT_MAX_SIZE = 100;
	
	private int _maxSize;
	private int _size;
	private Student[] _elements;
	
	public Ban()
	{
		this._maxSize = Ban.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._elements = new Student[this._maxSize];
	}
	public Ban(int givenMaxNumOfStudents)
	{
		this._maxSize = givenMaxNumOfStudents;
		this._size = 0;
		this._elements = new Student[this._maxSize];
	}
	public int maxSize()
	{
		return this._maxSize;
	}
	public int size()
	{
		return this._size;
	}
	public boolean isEmpty()
	{
		return (this._size == 0);
	}
	public boolean isFull()
	{
		return (this._size == this._maxSize);
	}
	
	public boolean add(Student aScore)
	{
		if(this.isFull())
			return false;
		else
		{
			this._elements[this._size++] = aScore;
			return true;
		}
	}
	public Student elementAt(int aPosition)
	{
		if((aPosition < 0) || (aPosition > this._size))                  
			return null;
		else
		{
			return this._elements[aPosition];
		}
	}
	public void sortStudentsByScore()
	{
		int size = this._size;
		
		if(size >= 2)
		{
			int minIndex = 0;
			for(int i=0; i<size; i++)
			{
				if(this._elements[i].score() < this._elements[minIndex].score())
					minIndex = i;
			}
			
			swap(minIndex, size - 1);   		
			//partition 함수에서 do-while문을 위해 right++ 구문이 삽입되어 있어 최소값을 찾아 따로 위치를 옮긴다.
			
			quickSortRecursively(0, size - 2);
		}
	}
	public int minScore()
	{
		return minScoreRecursively(0, this._size-1);
	}
	public int maxScore()
	{
		return maxScoreRecursively(0, this._size-1);
	}
	public float averageScore()
	{
		float sumOfScores = (float)sumOfScoresRecursively(0, this._size-1);
		float average = sumOfScores / (float)this._size;
		return average;
	}
	public int numberOfStudentsAboveAverage()
	{
		float average = averageScore();
		float score;
		int numberOfStudentsAboveAverage = 0;
		for(int i = 0;i<this._size;i++)
		{
			score = (float) this._elements[i].score();
			if(score >= average)
				numberOfStudentsAboveAverage++;
		}
		return numberOfStudentsAboveAverage;
	}
	public GradeCounter countGrades()
	{
		char currentGrade;
		GradeCounter gradeCounter = new GradeCounter();
		for(int i = 0; i<this._size; i++)
		{
			currentGrade = this.scoreToGrade(this._elements[i].score());
			gradeCounter.count(currentGrade);
		}
		return gradeCounter;
	}
	
	
	
	private void swap(int positionA, int positionB)
	{
		Student temp = this._elements[positionA];
		this._elements[positionA] = this._elements[positionB];
		this._elements[positionB] = temp;
	}
	private void quickSortRecursively(int left, int right)
	{
		int mid;
		
		if(left < right)
		{
			mid = partition(left, right);
			this.quickSortRecursively(left, mid-1);
			this.quickSortRecursively(mid+1, right);
		}
	}
	private int partition(int left, int right)     //실질적으로 QuickSorting을 구현하는 메소드
	{ //구간안의 아무 원소나 피봇으로 정해도 된다. 
		int pivot = left;
		int pivotScore = this._elements[pivot].score();
		right++;                             //do-while 문을 공통적인 규칙으로 구현하기 위해서 임의적으로 right 값을 조작한다.
		do
		{
			do
			{
				left++;
			}while(this._elements[left].score() > pivotScore);        //pivot으로 정한값보다 크면 left인덱스를 1증가시킨다
			do 
			{
				right--;
			}while(this._elements[right].score() < pivotScore);       //pivot으로 정한값보다 작으면 right인덱스를 1감소시킨다
			if(left < right)
				this.swap(left, right);
		}while(left<right);										//최종적으로 left가 right를 넘어서는 순간(모든값 탐색)까지 움직인다
		this.swap(pivot, right);  								//right는 현재 pivot이다
		return pivot;
	}
	private float sumOfScoresRecursively(int left, int right)
	{
		if(left > right)
			return 0;
		else
			return (this._elements[left].score() + sumOfScoresRecursively(left + 1, right));          
			// left의 값부터 시작해서 left가 right를 넘어가는순간의 데이터를 0으로 잡고 순차적으로 모두 더하여 최종 result를 반환한다.
	}
	private int maxScoreRecursively(int left, int right)       //크기를 n/2로 나누어서 만든다
	{
		int mid = (left+right) / 2;
		if(right == mid)
			return this._elements[left].score();	   //절반을 나눈 상태에서 right의 값과 mid값이 같으면 left의 값을 반환한다.
													   //(요소가 2개인 경우에서 mid가 0이 되므로 1개인 경우와 비교하기 위해선 right와 비교해야한다)
		
		int target1 = maxScoreRecursively(left, mid);  //요소를 left값과 mid값으로 재귀함수를 실행한다.
		int target2 = maxScoreRecursively(mid+1, right); // 요소를 mid+1값과 right 값으로 재귀함수를 실행한다.
		
		return (target1 >= target2 ? target1:target2); 	 //최종적으로 얻은 결과값중 크거나 같은 값을 반환한다. 
	}
	
	private int minScoreRecursively(int left, int right)       //맨 처음부터 알고리즘을 시작해서 끝부분부터 돌아온다
	{
		if(left == right)
			return this._elements[right].score();				//요소의 제일 마지막으로 와서 left와 right가 같으면 right의 끝값을 반환한다.
		else
		{
			int minValue = minScoreRecursively(left+1,right);	//최소값을 재귀함수로 설정한다.
			return (this._elements[left].score() < minValue ? this._elements[left].score():minValue);	//제일 마지막부터 시작해서 작은 값을 반환시킨다.
		}
	/*	
	 *  절반으로 나누어서 구현한 min값 구하기
	 *  
		int mid = (left+right) / 2;		
		if(right == mid)
			return this._elements[left].score();
		
		int target1 = minScoreRecursively(left, mid);
		int target2 = minScoreRecursively(mid+1, right);
		
		return (target1 < target2 ? target1:target2);   
	*	
	*	
	*/
	}
	
	private char scoreToGrade(int aScore)
	{
		if(aScore >= 90)
			return 'A';
		else if(aScore >= 80)
			return 'B';
		else if(aScore >= 70)
			return 'C';
		else if(aScore >= 60)
			return 'D';
		else
			return 'F';
	}
}
