package aster;

public class AppController {
	private AppView _appView;
	private ArraySet _starCollector;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	public void run()
	{
		this._starCollector = new ArraySet();
		
		this.showMessage(MessageID.Notice_StartProgram);
		int command = 0;
		while(command != 9)
		{
			try
			{
				this.showMessage(MessageID.Notice_Menu);
				command = this._appView.inputInt();
				switch(command)
				{
				case 1:
					this.input();
					break;
				case 2:
					this.remove();
					break;
				case 3:
					this.removeAny();
					break;
				case 4:
					this.showMessage(MessageID.Notice_Show);
					this._appView.outputNumOfStars(this._starCollector.size());
					break;
				case 5:
					this.searchByName();
					break;
				case 6:
					this.searchByCoordinate();
					break;
				case 9:
					this.showMessage(MessageID.Notice_EndMenu);
					this._appView.outputNumOfStars(this._starCollector.size());
					break;
				default:
					this.showMessage(MessageID.Error_WrongMenu);
					command = 0;
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Error Message : "+e.getMessage());
//				this._appView.inputString();
				continue;
			}
		}
		this.showMessage(MessageID.Notice_EndProgram);
	}
	
	private void input()
	{
		this.showMessage(MessageID.Notice_InputStar);
		this.showMessage(MessageID.Notice_InputStarXCoordinate);
		int xCoordinate = this._appView.inputInt();
		this.showMessage(MessageID.Notice_InputStarYCoordinate);
		int yCoordinate = this._appView.inputInt();
		this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		if(!this._starCollector.add(new Star(xCoordinate,yCoordinate,starName)))
			this.showMessage(MessageID.Error_Input);
	}
	
	private void remove()
	{
		Star removedStar = null;
		this.showMessage(MessageID.Notice_RemoveStar);this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		if((removedStar = this._starCollector.remove(new Star(0,0,starName))) == null) //이름으로만 검색함을 표현하기 위해 좌표에 0삽입
			this.showMessage(MessageID.Error_Remove);
		else
			this._appView.outputStar(removedStar.starName(), removedStar.xCoordinate(), removedStar.yCoordinate());
	}
	
	private void removeAny()
	{
		Star removedStar = null;
		this.showMessage(MessageID.Notice_RemoveRandomStar);
		if((removedStar = this._starCollector.removeAny()) == null)
			this.showMessage(MessageID.Error_Remove);
		else
			this._appView.outputStar(removedStar.starName(), removedStar.xCoordinate(), removedStar.yCoordinate());
	}
	
	private void searchByName()
	{
		this.showMessage(MessageID.Notice_SearchByName);
		this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		
		if(this._starCollector.doesContain(new Star(0,0,starName)))
				this._appView.outputStarExistence(starName, 0, 0);
		else
			this.showMessage(MessageID.Error_Search);
	}
	
	private void searchByCoordinate()
	{
		this.showMessage(MessageID.Notice_SearchByCoordinate);
		this.showMessage(MessageID.Notice_InputStarXCoordinate);
		int xCoordinate = this._appView.inputInt();
		this.showMessage(MessageID.Notice_InputStarYCoordinate);
		int yCoordinate = this._appView.inputInt();

		if(this._starCollector.doesContain(new Star(xCoordinate,yCoordinate,null)))
				this._appView.outputStarExistence(null, xCoordinate, yCoordinate);
		else
			this.showMessage(MessageID.Error_Search);
	}
	
	private void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("< 별의 집합을 시작합니다 >\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("< 별의 집합을 종료합니다 >\n");
			break;
		case Notice_Menu:
			this._appView.outputMessage("\n1:입력 \t2:주어진 별 삭제 \t3:임의의 별 삭제\n"
					+ "4:출력 \t5:이름으로 검색 \t6:좌표로 검색 \t9:종료\n"
					+ "원하는 메뉴를 입력하세요 : ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("메뉴를 종료합니다\n");
		case Notice_InputStar:
			this._appView.outputMessage("- [입력] - \n");
			break;
		case Notice_InputStarName:
			this._appView.outputMessage("- 별의 이름을 입력하시오 : ");
			break;
		case Notice_InputStarXCoordinate:
			this._appView.outputMessage("- x좌표를 입력하시오 : ");
			break;
		case Notice_InputStarYCoordinate:
			this._appView.outputMessage("- y좌표를 입럭하시오 : ");
			break;
		case Notice_RemoveStar:
			this._appView.outputMessage("- [주어진 별 삭제] -\n");
			break;
		case Notice_RemoveRandomStar:
			this._appView.outputMessage("- [임의의 별 삭제] -\n");
			break;
		case Notice_Show:
			this._appView.outputMessage("- [출력] -\n");
			break;
		case Notice_SearchByName:
			this._appView.outputMessage("- [이름으로 검색] -\n");
			break;
		case Notice_SearchByCoordinate:
			this._appView.outputMessage("- [좌표로 검색] -\n");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("ERROR : 존재하지 않는 메뉴입니다.\n");
			break;
		case Error_Input:
			this._appView.outputMessage("ERROR : 잘못된 입력입니다.\n");
			break;
		case Error_Remove:
			this._appView.outputMessage("ERROR : 삭제에 실패하였습니다.\n");
			break;
		case Error_Search:
			this._appView.outputMessage("ERROR : 별을 찾지 못하였습니다.\n");
			break;
		default:
			break;
		}
	}
}
