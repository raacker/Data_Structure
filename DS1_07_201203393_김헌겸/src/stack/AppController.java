package stack;

public class AppController {
	private AppView _appView;
	@SuppressWarnings("rawtypes")
	private ArrayList _arrayStack;
	private int _inputChars;
	private int _ignoredChars;
	private int _addedChars;
	
	public AppController()
	{
		this._appView = new AppView();
		this._inputChars = 0;
		this._ignoredChars = 0;
		this._addedChars = 0;
	}
	
	public void run()
	{
		this._arrayStack = new ArrayList<Character>();
		
		char input = '0';
		
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		
		do{
			try{	
				this.showMessage(MessageID.Notice_Input);
				input = this._appView.inputCharacter();
				
				if((input >= 'A' && input <= 'Z') || (input >= 'a' && input <= 'z'))
					this.addToStack(input);
				else if(input >= '0' && input <= '9')
					this.removeN(input - '0');
				else if(input == '-')
					this.removeOne();
				else if(input == '#')
					this.showStackSize();
				else if(input == '/')
					this.showAllFromBottom();
				else if(input == '\\')
					this.showAllFromTop();
				else if(input == '^')
					this.showTopElement();
				else if(input == '!')     //바로 종료
					break;
				else
				{
					this.showMessage(MessageID.Error_WrongMenu);
					this.countIgnored();
				}
				this.countInputChar();	//!는 count에 포함하지 않는다.
			}
			catch(Exception e)
			{
				this._appView.outputMessage("[Error] : "+e.getMessage()+"\n");
				continue;
			}
		}while(input != '!');      //true로 작성해도 가능
		

		this.showMessage(MessageID.Notice_EndMenu);
		this.conclusion();
		this.showMessage(MessageID.Notice_EndProgram);
	}
	private void showAllFromBottom()
	{
		this.showMessage(MessageID.Show_StarBottom);
		for(int index = 0; index < this._arrayStack.size(); index++)
			this._appView.outputStackElement((char)this._arrayStack.elementAt(index));
		this.showMessage(MessageID.Show_EndTop);
	}
	private void showAllFromTop()
	{
		this.showMessage(MessageID.Show_StartTop);
		for(int index = this._arrayStack.size()-1; index > -1; index--)
			this._appView.outputStackElement((char)this._arrayStack.elementAt(index));
		this.showMessage(MessageID.Show_EndBottom);
	}
	private void showTopElement()
	{
		this.showMessage(MessageID.Notice_ShowTop);
		this._appView.outputTopElement((char)this._arrayStack.peek());
	}
	private void showStackSize()
	{
		this._appView.outputStackSize(this._arrayStack.size());
	}
	private void countAdded()
	{
		this._addedChars++;
	}
	private void countIgnored()
	{
		this._ignoredChars++;
	}
	private void countInputChar()
	{
		this._inputChars++;
	}
	
	@SuppressWarnings("unchecked")
	private void addToStack(char inputChar)
	{
		if(this._arrayStack.push(new Character(inputChar)))
		{
			this.showMessage(MessageID.Notice_InputStack);
			this._appView.outputAddedElement(inputChar);
			this.countAdded();
		}
		else
		{
			this.showMessage(MessageID.Error_InputFull);
			this._appView.outputStackFull(inputChar);
		}
	}
	private void removeOne()
	{
		if(this._arrayStack.isEmpty())
			this.showMessage(MessageID.Error_RemoveEmpty);
		else
		{
			this.showMessage(MessageID.Notice_DelStack);
			this._appView.outputRemove((char)this._arrayStack.pop());
		}
	}
	private void removeN(int numOfCharsToBeRemoved)
	{
		if(this._arrayStack.isEmpty())
			this.showMessage(MessageID.Error_RemoveEmpty);
		else
		{
			this.showMessage(MessageID.Notice_DelStacks);
			this._appView.outputRemoveN(numOfCharsToBeRemoved);
			for(int index = 0; index<numOfCharsToBeRemoved; index++)
			{
				Object removed = this._arrayStack.pop();
				if(removed == null)
				{
					this.showMessage(MessageID.Error_DuringRemoveEmpty);
					return;
				}
				else	
				{
					this.showMessage(MessageID.Notice_DelStacks);
					this._appView.outputRemove((char)removed);
				}
			}
		}
	}
	private void conclusion()
	{
		for(int i = this._arrayStack.size(); i>0; i--)
		{
			this.showMessage(MessageID.Notice_EndStack);
			this._appView.outputRemove((char)this._arrayStack.pop());
		}
		this._appView.outputResult(this._inputChars,this._ignoredChars,this._addedChars);
	}
	
	private void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("> 프로그램을 시작합니다.\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("> 프로그램을 종료합니다.\n");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage("[스택 사용을 시작합니다]\n");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("[스택 사용을 종료합니다]\n");
			break;
		case Notice_Input:
			this._appView.outputMessage("- 문자를 입력하시오: ");
			break;
		case Notice_InputStack:
			this._appView.outputMessage("[Push] ");
			break;
		case Notice_ShowStack:
			this._appView.outputMessage("[Size] ");                       
			break;
		case Notice_ShowTop:
			this._appView.outputMessage("[Top] ");
			break;
		case Notice_DelStack:
			this._appView.outputMessage("[Pop] ");
			break;
		case Notice_DelStacks:
			this._appView.outputMessage("[Pops] ");
			break;
		case Notice_EndStack:
			this._appView.outputMessage("[End] ");
			break;
		case Show_EndBottom:
			this._appView.outputMessage(" <Bottom>\n");                              
			break;
		case Show_EndTop:
			this._appView.outputMessage(" <Top>\n");
			break;
		case Show_StarBottom:
			this._appView.outputMessage("[Stack] <Bottom> ");
			break;
		case Show_StartTop:
			this._appView.outputMessage("[Stack] <Top> ");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("[Error] 의미 없는 문자가 입력되었습니다.\n");
			break;
		case Error_InputFull:
			this._appView.outputMessage("[Full] ");
			break;
		case Error_RemoveEmpty:
			this._appView.outputMessage("[Empty] 스택에 삭제할 원소가 없습니다.\n");
			break;
		case Error_DuringRemoveEmpty:
			this._appView.outputMessage("[Empty] 스택에 더 이상 삭제할 원소가 없습니다.\n");
			break;
		}
	}
}
