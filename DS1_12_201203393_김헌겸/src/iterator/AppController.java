package iterator;

public class AppController {
	private AppView _appView;
	@SuppressWarnings("rawtypes")
	//private SortedArrayList _sortedList;
	private SortedLinkedList _sortedList;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		//this._sortedList = new SortedArrayList<Integer>();
		this._sortedList = new SortedLinkedList<Integer>();
		char command = 0;
		int input;
		
		this.showMessage(MessageID.Notice_StartProgram);
		do
		{
			try
			{
				command = this._appView.inputCharacter();
				if(command == '%')
				{
					input = this._appView.inputNumber();
					this.add(input);
				}
				else if(command == '~')
					this.reset();
				else if(command == '-')
					this.removeMin();
				else if(command == '+')
					this.removeMax();
				else if(command == '#')
					this.showSize();
				else if(command == '?')
				{
					input = this._appView.inputNumber();
					this.removeFrom(input);
				}
				else if(command == '/')
					this.showAll();
				else if(command == '!')
					break;
				else
					this.showMessage(MessageID.Error_WrongMenu);
			}
			catch(Exception e)
			{
				this._appView.outputMessage("ERROR occured : "+e.getMessage()+"\n");
				continue;
			}
		}while(true);
		
		this.showMessage(MessageID.Notice_EndProgram);
	}
	public void showSize()
	{
		this._appView.outputSize(this._sortedList.size());
	}
	public void reset()
	{
		this.showMessage(MessageID.Notice_Reset);
		this._sortedList.clear();
	}
	public void showAll()
	{
		this.showMessage(MessageID.Notice_ShowStartList);
		@SuppressWarnings("unchecked")
		Iterator<Integer> iterator = this._sortedList.ListIterator();
		while(iterator.hasNext())
			this._appView.outputElement(iterator.next().intValue());
		this.showMessage(MessageID.Notice_ShowEndList);
	}
	@SuppressWarnings("unchecked")
	public void add(int inputValue)
	{
		Integer input = new Integer(inputValue);
		if(!this._sortedList.add(input))
			this.showMessage(MessageID.Error_InputFail);
		this._appView.outputAdd(inputValue);
	}
	
	public void removeMin()
	{
		this._appView.outputRemove((Integer)this._sortedList.removeMin());
	}
	public void removeMax()
	{
		this._appView.outputRemove((Integer)this._sortedList.removeMax());
	}
	public void removeFrom(int aPosition)
	{
		this._appView.outputRemove((Integer)this._sortedList.removeFrom(aPosition));
	}
	
	public void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("<리스트를 시작합니다>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("<리스트를 종료합니다>\n");
			break;
		case Notice_Reset:
			this._appView.outputMessage("- 리스트를 비웠습니다.\n");
			break;
		case Notice_ShowStartList:
			this._appView.outputMessage("[LIST] ");
			break;
		case Notice_ShowEndList:
			this._appView.outputMessage("\n");
			break;
		case Error_InputFail:
			this._appView.outputMessage("[ERROR] 입력에 실패하였습니다.\n");
			break;
		case Error_Empty:
			this._appView.outputMessage("[ERROR] 리스트가 비어있습니다.\n");
			break;
		case Error_InputFull:
			this._appView.outputMessage("[ERROR] 리스트가 가득 차있습니다.\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("[ERROR] 잘못된 메뉴 입니다.\n");
			break;
		}
	}
}
