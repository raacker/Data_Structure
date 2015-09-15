package priority;

import java.util.Random;

public class AppController {
	private AppView _appView;
	//SortedArrayPriorityQueue<Integer> _priorityQueue;
	//SortedLinkedPriorityQueue<Integer> _priorityQueue;
	HeapPriorityQueue<Integer> _priorityQueue;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		this.showMessage(MessageID.Notice_StartProgram);
		char input = 0;
		//this._priorityQueue = new SortedArrayPriorityQueue<Integer>();
		//this._priorityQueue = new SortedLinkedPriorityQueue<Integer>();
		this._priorityQueue = new HeapPriorityQueue<Integer>();
		do{
			try
			{	
				this.showMessage(MessageID.Notice_Menu);
				input = this._appView.inputCharacter();
				
				if(input == 'i')
					this.add();
				else if(input == 'r')
					this.randomAdd();
				else if(input == 'v')
					this.showAll();
				else if(input == 'd')
					this.remove();
				else if(input == 'm')
					this.showMax();
				else if(input == 'n')
					this.showElement();
				else if(input == 'x')
					this.removeAll();
				else if(input == 'q')
					break;
				else
				{
					this.showMessage(MessageID.Error_WrongMenu);
				}
			}
			catch(Exception e)
			{
				this._appView.outputMessage("ERROR : "+e.getMessage()+"\n");
				continue;
			}
		}while(true);
		
		this.showMessage(MessageID.Notice_EndProgram);
	}
	public void showElement()
	{
		this._appView.outputSize(this._priorityQueue.size());
	}
	public void showAll()
	{
		this.showMessage(MessageID.Notice_ShowStart);
		//Iterator<Integer> iterator = this._priorityQueue.priorityQueueIterator();
		HeapPriorityQueue<Integer>.PriorityQueueIterator iterator = this._priorityQueue.priorityQueueIterator();
		
		while(iterator.hasNext())
			this._appView.outputElement((int)iterator.next());
		this.showMessage(MessageID.Notice_ShowEnd);
	}
	public void showMax()
	{
		Integer maxElement = this._priorityQueue.max();
		if(maxElement != null)
			this._appView.outputMaxElement(maxElement);
		else
			this.showMessage(MessageID.Error_Empty);
	}
	public void add()
	{
		Integer newElement = this._appView.inputInteger();
		if(this._priorityQueue.add(newElement))
			this._appView.outputAddElement(newElement);
		else
			this.showMessage(MessageID.Error_InputFull);
	}
	public void randomAdd()
	{
		Random random = new Random();
		Integer newElement;
		int i;
		random.setSeed(System.nanoTime());
		for(i = 0; i < 10; i++)
		{
			newElement = random.nextInt(100);
			if(this._priorityQueue.add(newElement))
				this._appView.outputAddElement(newElement);
			else
			{
				this.showMessage(MessageID.Error_InputFull);
				break;
			}
		}
		this._appView.outputRandomAdd(i);
	}
	
	public void remove()
	{
		Integer removedElement = this._priorityQueue.removeMax();
		if(removedElement != null)
			this._appView.outputRemoveElement(removedElement);
		else
			this.showMessage(MessageID.Error_Empty);
	}
	public void removeAll()
	{
		if(this._priorityQueue.isEmpty())
			this.showMessage(MessageID.Error_Empty);
		
		Integer removedElement;
		this.showMessage(MessageID.Notice_StartRemoveAll);
		while(!this._priorityQueue.isEmpty())
		{
			removedElement = this._priorityQueue.removeMax();
			if(removedElement != null)
				this._appView.outputElement(removedElement);
			else
			{
				this.showMessage(MessageID.Error_Empty);
				break;
			}
		}
		this.showMessage(MessageID.Notice_EndRemoveAll);
	}
	public void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram : 
			this._appView.outputMessage("<우선순위 큐를 시작합니다>\n");
			break;
		case Notice_EndProgram :
			this._appView.outputMessage("<우선순위 큐를 종료합니다>\n");
			break;
		case Notice_Menu :
			this._appView.outputMessage("\n[다음 중 해야 할 일의 코드를 선택하시오]\n"+
					"i : 입력\n"+
					"m : 최대값 보기\n"+
					"d : 최대값 삭제\n"+
					"v : Priority Queue 내용 보기\n"+
					"x : 모든 원소 차례대로 삭제하여 출력\n"+
					"r : 난수를 생성하여 10개 입력 \n"+
					"n : 원소의 개수 보기\n"+
					"q : 프로그램 종료\n");
			break;
		case Notice_ShowStart:
			this._appView.outputMessage("= Priority Queue의 내용 =\n");
			break;
		case Notice_ShowEnd:
			this._appView.outputMessage("\n");
			break;
		case Notice_StartRemoveAll:
			this._appView.outputMessage("= 삭제된 원소들 =\n");
			break;
		case Notice_EndRemoveAll:
			this._appView.outputMessage("\n= 삭제 종료 - Priority Queue는 비었습니다.\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("Error : 잘못된 메뉴 입니다\n");
			break;
		case Error_InputFull:
			this._appView.outputMessage("Error : 입력에 실패하였습니다\n");
			break;
		case Error_Empty:
			this._appView.outputMessage("Error : 큐가 비어있습니다.\n");
			break;
		}
	}
}
