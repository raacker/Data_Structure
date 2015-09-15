package postfix;

public class AppController {
	private AppView _appView;
	private Calculate _calculate;
	
	public AppController()
	{
		this._appView = new AppView();
		this._calculate = new Calculate();
	}
	public void run()
	{
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		String input = "0";
		do{
			try{
				input = this._appView.inputExpression();
				if(input.charAt(0) == '!')
					break;
				this._calculate.setInfix(input);
				this.evalExpression();
			}
			catch(Exception e)
			{
				this._appView.outputMessage("[Error] : "+e.getMessage()+"\n");
				continue;
			}
		}while(true);      //true로 작성해도 가능

		this.showMessage(MessageID.Notice_EndMenu);
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	public void evalExpression()
	{
		double finalValue;
		this.showMessage(MessageID.Notice_InfixToPostfix);
		if(this._calculate.infixToPostfix())
		{
			this._appView.outputPostfix(this._calculate.postfix());
			finalValue = this._calculate.evalPostfix();
			this._appView.outputResult(finalValue);
		}
		else
			this.showMessage(MessageID.Error_Input);
	}
	
	public void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage(":: 프로그램을 시작합니다 ::\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage(":: 프로그램을 종료합니다 ::\n");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage("[수식 입력을 시작합니다]\n");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("[수식 입력을 종료합니다]\n");
			break;
		case Notice_InfixToPostfix:
			this._appView.outputMessage("[Infix를 Postfix로]\n");
			break;
		case Error_Input:
			this._appView.outputMessage("입력 오류 입니다.\n");
			break;
		default:
			break;
		}
	}
}
