package postfix;

public class Calculate {
	private ArrayList<Character> _oStack;
	private ArrayList<Double> _vStack;
	private char[] _infix;
	private char[] _postfix;
	
	public Calculate()
	{
		this._oStack = null;
		this._vStack = null;
		this._infix = null;
		this._postfix = null;
	}
	public void setInfix(String anInfix)
	{
		this._infix = anInfix.toCharArray();
	}
	public String infix()
	{
		if(this._infix != null)
			return String.valueOf(this._infix);
		else
			return null;
	}
	public String postfix()
	{
		if(this._postfix != null)
			return String.valueOf(this._postfix);
		else
			return null;
	}
	public boolean infixToPostfix()
	{
		int i = 0;   //infix index counter;
		int p = 0;   //postfix index counter;
		char currentToken, poppedToken, topToken;
	
		this._oStack = new ArrayList<Character>(this._infix.length); //Generate Operator Stack in infix.length
		this._postfix = new char[this._infix.length];  //Generate Postfix Array in infix.length
		
		while(i < this._infix.length)  //For all Elements in infix
		{
			currentToken = this._infix[i++];  //Get each character from infix
			if(this.isDigit(currentToken))  //피연산자라면 
				this._postfix[p++] = currentToken;
			else
			{
				if(currentToken == ')')   //괄호의 끝이라면
				{
					if(!this._oStack.isEmpty())  //연산자 스택이 비어있지 않다면
						poppedToken = (char)this._oStack.pop();
					else
						return false;  //변환실패 (수식의 괄호안에 연산자가 존재하지 않는다 : ERROR)
					
					while(poppedToken != '(')   //괄호의 시작을 만날때까지
					{
						this._postfix[p++] = poppedToken;   //연산자를 postfix에 넣는다
						if(!this._oStack.isEmpty())	
							poppedToken = (char)this._oStack.pop(); //stack에서 다음 연산자를 꺼낸다
						else
							return false;  //변환실패 (수식의 괄호안에 연산자가 존재하지 않는다 : ERROR)
					}
					this.showOStackAll();   //stack이 모든연산자가 꺼내지고 나서 비어있어야함 
				}
				else     //일반적인 연산자
				{
					int inComingP = this.inComingPrecedence(currentToken);  //우선순위를 받아온다
					if(!this._oStack.isEmpty())   //스택이 비어있지 않다면
					{
						topToken = (char)this._oStack.peek();  //스택의 제일 상위 요소값을 얻는다
						while(this.inStackPrecedence(topToken) >= inComingP)  //스택 요소의 우선순위가 새로 들어온 것보다 높다면
						{
							poppedToken = (char)this._oStack.pop();  //스택에서 우선순위가 더 높은 연산자를 꺼낸다
							this._postfix[p++] = poppedToken;  //postfix에 저장
							if(!this._oStack.isEmpty())  //스택이 비어있지 않다면
								topToken = (char)this._oStack.peek();  //스택의 그 다음 연산자를 peek한다
							else
								break;  //더이상 스택에 연산자가 없으면 break
						}
					}
					this._oStack.push(currentToken);   //이제 새로운 연산자보다 높은우선순위는 없으므로 스택에 추가
					this.showOStackAll();
				}
			}
		}

		
		while(!this._oStack.isEmpty())
			this._postfix[p++] = this._oStack.pop();	
		
		// 이제 모든 값을 postfix에 넣었으므로 마지막으로 남은 연산자들을 모두 꺼내 넣으면 된다
		// ※ 맨 바깥 괄호를 넣지 않은 연산식일 경우 postfix에 남은 연산자를 넣지 않는다.
		
		//this._postfix[p++] = '$';
		
		return true;
	}
	public double evalPostfix() 
	{
		int p;
		char curToken;
		this._vStack = new ArrayList<Double>(this._infix.length);
		
		p = 0;
		
		while(p < this._postfix.length)
		{
			curToken = this._postfix[p++];
			if(isDigit(curToken))
			{
				this._vStack.push(Double.parseDouble(String.valueOf(curToken)));  //Token이 숫자면 double값으로 push
			}
			else	//Token이 연산자면 꺼내서 연산하고 다시 넣는다.
			{
				if(curToken == 0)
					break;
				
				double poppedData = this._vStack.pop();
				double poppedData2 = this._vStack.pop();
				this._vStack.push(this.calculateForTwoOperand(curToken, poppedData2, poppedData));
			}
			this.showVStackAll();
		}
		return this._vStack.pop();
	}
	public void showOStackAll()   //Observation for Operator Stack
	{
		System.out.print("OStack: ");   //AppView 사용안함
		for(int index = 0; index < this._oStack.size(); index++)
		{
			System.out.print(this._oStack.elementAt(index)+ " ");
		}
		System.out.println("");
	}
	public void showVStackAll()   //Observation for Value Stack
	{
		System.out.print("VStack: ");   //AppView 사용안함
		for(int index = 0; index < this._vStack.size(); index++)
		{
			System.out.print(this._vStack.elementAt(index)+ " ");
		}
		System.out.println("");
	}
	
	
	private boolean isDigit(char aToken)
	{
		if(aToken >= '0' && aToken <= '9')
			return true;
		else
			return false;
	}
	private int inComingPrecedence(char aToken)
	{
		if(aToken == '+')
			return 12;
		else if(aToken == '-')
			return 12;
		else if(aToken == '(')
			return 20;
		else if(aToken == ')')
			return 19;
		else if(aToken == '*')
			return 13;
		else if(aToken == '/')
			return 13;
		else if(aToken == '%')
			return 13;
		else if(aToken == '^')
			return 17;
		else if(aToken == '$')
			return 0;
		else
			return -1;
	}
	private int inStackPrecedence(char aToken)
	{
		if(aToken == '+')
			return 12;
		else if(aToken == '-')
			return 12;
		else if(aToken == '(')
			return 0;
		else if(aToken == ')')
			return 19;
		else if(aToken == '*')
			return 13;
		else if(aToken == '/')
			return 13;
		else if(aToken == '%')
			return 13;
		else if(aToken == '^')
			return 16;
		else if(aToken == '$')
			return 0;
		else
			return -1;
	}
	
	private double calculateForTwoOperand(char aToken ,double d1, double d2)
	{
		if(aToken == '+')
			return d1+d2;
		else if(aToken == '-')
			return d1-d2;
		else if(aToken == '*')
			return d1*d2;
		else if(aToken == '/')
			return d1/d2;
		else if(aToken == '%')
			return d1%d2;
		else if(aToken == '^')
			return Math.pow(d1,d2);
		else
			return 0;
	}
}
