package dictionary;

public class AppController implements VisitEventForTreeTraversal {
	private AppView _appView;
	private PMDictionary _pmDictionary;
	private static final int MaxTestSize = 500;
	private static final int FirstTestSize = 100;
	private static final int SizeIncrement = 100;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		this.showMessage(MessageID.Notice_StartProgram);
		this._pmDictionary = new PMDictionary(AppController.MaxTestSize);
		this._pmDictionary.generateData();
		this._appView.nextLine();
		this.testSortedArray();
		this._appView.nextLine();
		this.testSortedLinkedList();
		this._appView.nextLine();
		this.testBinarySearchTree();
		this._appView.nextLine();
		this.showMessage(MessageID.Notice_EndProgram);
		
		this.testTraverse();
	}
	private void testSortedArray()
	{
		this.showMessage(MessageID.Notice_ResultSortedArray);
		for(int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement)
		{
			TestResult testResult = this._pmDictionary.doSortedArray(testSize);
			this._appView.outputResult(testResult.testSize(), testResult.testInsertTime(),
					testResult.testSearchTime(), testResult.testRemoveTime());
		}
	}
	private void testSortedLinkedList()
	{
		this.showMessage(MessageID.Notice_ResultSortedLinkedList);
		for(int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement)
		{
			TestResult testResult = this._pmDictionary.doSortedLinkedList(testSize);
			this._appView.outputResult(testResult.testSize(), testResult.testInsertTime(),
					testResult.testSearchTime(), testResult.testRemoveTime());
		}
	}
	private void testBinarySearchTree()
	{
		this.showMessage(MessageID.Notice_ResultBinarySearchTree);
		for(int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement)
		{
			TestResult testResult = this._pmDictionary.doBinarySearchTree(testSize);
			this._appView.outputResult(testResult.testSize(), testResult.testInsertTime(),
					testResult.testSearchTime(), testResult.testRemoveTime());
		}
	}
	
	private void testTraverse()
	{
		BinarySearchTree<Integer,Character> binaryTree = 
				new BinarySearchTree<Integer,Character>();
		
		char value = 'A';
		int[] input = new int[]{50,30,70,10,40,60,80,0,20};
		for(int i = 0; i<input.length; i++)
			binaryTree.addKeyAndObject(input[i], value++);
		
		this._appView.nextLine();
		DrawDictionary<Integer,Character> d = binaryTree.showDictionary();
		d.drawDictionary();
		for(int i=0;i<d.getSize();i++)
			this._appView.outputDictionary(d.drawString()[i]);
		
		binaryTree.setCallerForVisitEvent(this);
		this._appView.nextLine();
		
		this.showMessage(MessageID.Notice_InorderTraverse);
		binaryTree.inOrder();
		this._appView.nextLine();
		
		this.showMessage(MessageID.Notice_PreorderTraverse);
		binaryTree.preOrder();
		this._appView.nextLine();
		
		this.showMessage(MessageID.Notice_PostorderTraverse);
		binaryTree.postOrder();
		this._appView.nextLine();
	}
	private void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_StartProgram:
			this._appView.outputMessage("<<사전 성능측정 프로그램을 시작합니다>> \n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("<<사전 성능측정 프로그램을 종료합니다>> \n");
			break;
		case Notice_ResultSortedArray:
			this._appView.outputMessage("<<SortedArray로 구현된 Dictionary의 성능측정 결과>> \n");
			break;
		case Notice_ResultSortedLinkedList:
			this._appView.outputMessage("<<SortedLinkedList로 구현된 Dictionary의 성능측정 결과>> \n");
			break;
		case Notice_ResultBinarySearchTree:
			this._appView.outputMessage("<<BinarySearchTree로 구현된 Dictionary의 성능측정 결과>> \n");
			break;
		case Notice_InorderTraverse:
			this._appView.outputMessage(">>INORDER TRAVERSE : ");
			break;
		case Notice_PreorderTraverse:
			this._appView.outputMessage(">>PREORDER TRAVERSE : ");
			break;
		case Notice_PostorderTraverse:
			this._appView.outputMessage(">>POSTORDER TRAVERSE : ");
			break;
		}
	}

	@Override
	public void processVisitByCallback(Object anObj) {
		this._appView.outputTraverse((char)anObj);
	}
}
