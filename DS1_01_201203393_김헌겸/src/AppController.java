
public class AppController {
	private AppView _appView;
	private Board _board;
	private MagicSquare _magicSquare;
	
	public AppController()
	{
		this._appView = new AppView();
		this._board = null;
		this._magicSquare = new MagicSquare();
	}
	
	public void run()
	{
		this.showMessage(MessageID.Notice_BeginMagicSquare);
		OrderValidity currentOrderValidity;
		
		int order = this._appView.inputOrder();
		while(order > 0)
		{
			currentOrderValidity = this._magicSquare.checkOrderValidity(order);
			if(currentOrderValidity == OrderValidity.Valid)
			{
				this._appView.outputTitleWithOrder(order);
				this._board = this._magicSquare.solve(order);
				this.showBoard(this._board);
			}
			else
			{
				this.showOrderValidityErrorMessage(currentOrderValidity);
			}
			order = this._appView.inputOrder();
		}
		this.showMessage(MessageID.Notice_EndMagicSquare);	
	}
	
	private void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_BeginMagicSquare:
			this._appView.outputMessage("<<<마방진 풀이를 시작합니다>>>\n");
			break;
		case Notice_EndMagicSquare:
			this._appView.outputMessage("<마방진 풀이를 종료합니다>\n");
			break;
		case Error_OrderIsTooSmall:
			this._appView.outputMessage("오류: 차수가 너무 작습니다. 3보다 크거나 같아야 합니다.");
			break;
		case Error_OrderIsTooLarge:
			this._appView.outputMessage("오류: 차수가 너무 큽니다. 99보다 작거나 같아야 합니다.");
			break;
		case Error_OrderIsNotOddNumber:
			this._appView.outputMessage("차수가 짝수입니다. 홀수이어야 합니다.");
			break;
		default:
			break;
		}
	}
	private void showOrderValidityErrorMessage(OrderValidity anOrderValidity)
	{
		switch(anOrderValidity)
		{
		case TooSmall:
			this.showMessage(MessageID.Error_OrderIsTooSmall);
			break;
		case TooLarge:
			this.showMessage(MessageID.Error_OrderIsTooLarge);
			break;
		case NotOddNumber:
			this.showMessage(MessageID.Error_OrderIsNotOddNumber);
			break;
		default:
			break;
		}
	}
	private void showBoard(Board aBoard)
	{
		CellLocation currentLoc;
		
		System.out.print("     ");
		for(int i=0;i<aBoard.order();i++)
		{
			this._appView.outputRowNumber(i);
		}
		this._appView.outputNextLine();
		
		for(int i=0;i<aBoard.order();i++)
		{
			this._appView.outputRowNumber(i);
			for(int j = 0; j < aBoard.order();j++)
			{
				currentLoc = new CellLocation();
				currentLoc.setRow(i);
				currentLoc.setCol(j);
				this._appView.outputCell(aBoard.cell(currentLoc));
			}
			this._appView.outputNextLine();
		}
	}
}
