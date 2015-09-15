package linkedQueue;
public class AppController {
	private AppView _appView;
	private LinkedQueue<Character> _linkedQueue;
	private int _inputChars;
	private int _ignoredChars;
	private int _addedChars;
	
	public AppController()
	{
		this._appView = new AppView();
		this.initCharCounts();
	}
	public void initCharCounts()
	{
		this._addedChars = 0;
		this._ignoredChars = 0;
		this._inputChars = 0;
	}
	public void run()
	{
		this._linkedQueue = new LinkedQueue<Character>();
		char input=0;
		
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		
		do
		{
			try
			{
				input = this._appView.inputCharacter();
				
				if((input >= 'A' && input <= 'Z') || (input >= 'a' && input <= 'z'))
					this.add(input);
				else if(input >= '0' && input <= '9')
					this.removeN(Integer.parseInt(String.valueOf(input)));
				else if(input == '-')
					this.removeOne();
				else if(input == '#')
					this.showQueueSize();
				else if(input == '/')
					this.showAll();
				else if(input == '^')
					this.showFrontElement();
				else if(input == '!')
					break;
				else
				{
					this.showMessage(MessageID.Error_WrongMenu);
					this.countIgnored();
				}

				this.countInputChar();  // !는 count하지 않는다
			}
			catch(Exception e)
			{
				this._appView.outputMessage("ERROR : "+e.getMessage()+"\n");
				continue;
			}
		}while(true);	//!입력시 종료된다는 조건하에 무한하게 반복함.
		
		this.showMessage(MessageID.Notice_EndMenu);
		this.conclusion();
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	public void showFrontElement()
	{
		char frontElement = (char)this._linkedQueue.frontElement();
		if(frontElement != 0)
			this._appView.outputFrontElement(frontElement);
		else
			this.showMessage(MessageID.Error_Empty);
	}
	public void showQueueSize()
	{
		int queueSize = this._linkedQueue.size();
		if(queueSize != 0)
			this._appView.outputQueueSize(queueSize);
		else
			this.showMessage(MessageID.Error_Empty);
	}
	public void showAll()
	{
		this.showMessage(MessageID.Show_QueueStart);
		
		for(int i = 0; i < this._linkedQueue.size(); i++)
			this._appView.outputEachElement((char)this._linkedQueue.elementAt(i));
		
		this.showMessage(MessageID.Show_QueueEnd);
	}
	public void countAdded()
	{
		this._addedChars++;
	}
	public void countIgnored()
	{
		this._ignoredChars++;
	}
	public void countInputChar()
	{
		this._inputChars++;
	}
	public void add(char c)
	{
		if(this._linkedQueue.enQueue(new Character(c)))
		{
			this._appView.outputAddElement(c);
			this.countAdded();
		}
		else
			this.showMessage(MessageID.Error_InputError);
	}
	public void removeOne()
	{
		if(this._linkedQueue.isEmpty())
			this.showMessage(MessageID.Error_DuringRemoveEmpty);
		else
		{
			this._appView.outputRemoveElement((char)this._linkedQueue.deQueue());
		}
	}
	public void removeN(int numOfCharsToBeDeleted)
	{
		this._appView.outputRemoveN(numOfCharsToBeDeleted);
		for(int i = 0; i < numOfCharsToBeDeleted; i++)
			this.removeOne();
	}
	
	public void conclusion()
	{
		for(int i = this._linkedQueue.size(); i>0; i--)
		{
			this._appView.outputRemoveElement((char)this._linkedQueue.deQueue());
		}
		this._appView.outputResult(this._inputChars,this._ignoredChars,this._addedChars);
	}
	public void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("> 프로그램을 시작합니다. \n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("> 프로그램을 종료합니다. \n");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage(" [큐 입력을 시작합니다] \n");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage(" [큐 입력을 종료합니다] \n");
			break;
		case Show_QueueStart:
			this._appView.outputMessage("[Queue] <Front> ");
			break;
		case Show_QueueEnd:
			this._appView.outputMessage(" <Rear>\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("ERROR : 의미없는 문자가 입력 되었습니다.\n");
			break;
		case Error_Empty:
			this._appView.outputMessage("[Empty] 큐에 원소가 없습니다.\n");
			break;
		case Error_InputError:
			this._appView.outputMessage("ERROR : 삽입에 실패하였습니다.\n");
			break;
		case Error_DuringRemoveEmpty:
			this._appView.outputMessage("ERROR : 큐에 삭제할 원소가 없습니다. \n");
		}
	}
}

