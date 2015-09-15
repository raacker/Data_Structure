package linkedChain;

public class AppController {
	private AppView _appView;
	private LinkedBag _coinCollector;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		int input = 0;
		int order = 0;
		
		this.showMessage(MessageID.Notice_StartProgram);
		this._coinCollector = new LinkedBag();
		
		while(order != 9)
		{
			this.showMessage(MessageID.Notice_Menu);
			order = this._appView.inputInt();
			if(order == 1)
			{
				this.showMessage(MessageID.Notice_InputCoin);
				input = this._appView.inputInt();
				if(input < 0)
					this.showMessage(MessageID.Error_AddFail);
				else
				{	Coin givenCoin = new Coin(input);
					this._coinCollector.add(givenCoin);
				}
			}
			else if(order == 2)
			{
				this.showMessage(MessageID.Notice_InputCoin);
				input = this._appView.inputInt();
				Coin givenCoin = new Coin(input);
				if(!this._coinCollector.remove(givenCoin))
					this.showMessage(MessageID.Error_RemoveFail);
			
			}
			else if(order == 3)
			{
				this._appView.outputResult(this._coinCollector.size(),
						this._coinCollector.maxElementValue(), this._coinCollector.sumElementValues());
			}
			else if(order == 4)
			{
				this.showMessage(MessageID.Notice_InputCoin);
				input = this._appView.inputInt();
				Coin givenCoin = new Coin(input);
				this._appView.outputSearch(input,this._coinCollector.frequencyOf(givenCoin));
			}
			else if(order == 5)
			{
				Coin removedCoin = this._coinCollector.removeAny();
				if(removedCoin == null)
					this.showMessage(MessageID.Error_RemoveFail);
				else
					this._appView.outputRemove(removedCoin.value());
			}
			else if(order == 9)
			{
				this.showMessage(MessageID.Notice_EndMenu);
				if(!this._coinCollector.isEmpty())
					this._appView.outputResult(this._coinCollector.size(), this._coinCollector.maxElementValue(), this._coinCollector.sumElementValues());
				this.showMessage(MessageID.Notice_EndProgram);
			}
			else
				this.showMessage(MessageID.Error_WrongMenu);

		}
	}
	
	private void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("<<동전 가방 프로그램을 시작합니다>>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("<<동전 가방 프로그램을 종료합니다>>\n");
			break;
		case Notice_Menu:
			this._appView.outputMessage("수행하려고 하는 메뉴를 선택하세요\n"+
					"(add:1, remove: 2, print: 3, search:4, removeAny: 5, exit: 9): ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("9가 입력되어 종료합니다.\n");
			break;
		case Notice_InputCoin:
			this._appView.outputMessage("코인의 액수를 입력하세요: ");
			break;
		case Error_AddFail:
			this._appView.outputMessage("<<ERROR: 추가에 실패하였습니다.>>\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("<<ERROR: 잘못된 메뉴입니다.>>\n");
			break;
		case Error_RemoveFail:
			this._appView.outputMessage("<<ERROR: 삭제에 실패하였습니다.>>\n");
			break;
		default:
			break;
		}
	}
}
