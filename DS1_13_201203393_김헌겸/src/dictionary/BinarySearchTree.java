package dictionary;

public class BinarySearchTree<Key extends Comparable<Key>, Obj>{
	private BinaryNode<Key,Obj> _root;
	private int _size;
	private VisitEventForTreeTraversal _callerForVisitEvent;
	
	public BinarySearchTree()
	{
		this._root = null;
		this._size = 0;
	}
	
	public boolean keyDoesExist(Key aKey)
	{
		return this.keyDoesExistInTree(this._root, aKey);
	}
	public boolean addKeyAndObject(Key aKey, Obj anObject)
	{
		if(this._root == null)
		{
			this._root = new BinaryNode<Key,Obj>(new Element<Key,Obj>(aKey, anObject));
			this._size++;
		}
		else
			addKeyAndObjectToSubtree(this._root, aKey, anObject);
		return true;
	}
	public Obj removeObjectForKey(Key aKey)
	{
		Obj removedObject = null;
		if(this._root == null)
			return null;
		else if(this._root.element().key().compareTo(aKey) == 0)
		{
			if((this._root.left() == null) && (this._root.right() == null))
				this._root = null;
			else if(this._root.left() == null)
				this._root = this._root.right();
			else if(this._root.right() == null)
				this._root = this._root.left();
			else
			{
				BinaryNode<Key, Obj> newRoot = removeRightMostOfLeftTree(this._root);
				newRoot.setLeft(this._root.left());
				newRoot.setRight(this._root.right());
				this._root = newRoot;
			}
			this._size--;
			return removedObject;
		}
		else
			return this.removeObjectForKeyFromSubtree(this._root, aKey);
	}
	public Obj objectForKey(Key aKey)
	{
		BinaryNode<Key, Obj> currentRoot = this._root;
		boolean found = false;
		
		while(!found && (currentRoot != null))
		{
			if(currentRoot.element().key().compareTo(aKey) == 0)
				found = true;
			else if(currentRoot.element().key().compareTo(aKey) > 0)
				currentRoot = currentRoot.left();
			else
				currentRoot = currentRoot.right();
		}
		
		if(found)
			return currentRoot.element().object();
		else
			return null;
	}
	public boolean replaceObjectForKey(Obj newObject, Key aKey)
	{
		BinaryNode<Key, Obj> currentRoot = this._root;
		
		if(currentRoot == null)
			return false;
		
		while(currentRoot != null)
		{
			if(currentRoot.element().key().compareTo(aKey) == 0)
			{
				currentRoot.element().setObject(newObject);
				return true;
			}
			else if (currentRoot.element().key().compareTo(aKey) > 0)
				currentRoot = currentRoot.left();
			else
				currentRoot = currentRoot.right();
		}
		return false;	//못찾아서 비교 불가
	}
	
	
	public void setCallerForVisitEvent(VisitEventForTreeTraversal aCaller)
	{
		this._callerForVisitEvent = aCaller;
	}
	public void visit(Obj anObj)
	{
		this._callerForVisitEvent.processVisitByCallback(anObj);
	}
	public void inOrder()
	{
		this.inOrderTraversal(this._root);
	}
	public void preOrder()
	{
		this.preOrderTraversal(this._root);
	}
	public void postOrder()
	{
		this.postOrderTraversal(this._root);
	}
	
	
	// dictionary 그리기
	
	public DrawDictionary<Key,Obj> showDictionary()
	{
		return this.dictionaryCreate();
	}
	private DrawDictionary<Key,Obj> dictionaryCreate()
	{
		return new DrawDictionary<Key,Obj>()
		{
			String[] drawString = new String[BinarySearchTree.this._size];
			int countIndex = BinarySearchTree.this._size-1;
			
			public void drawDictionary()
			{
				this.inOrderTraversalStringBuilder(BinarySearchTree.this._root, 0);
			}
			@Override
			public void getString(String producedString) {
				drawString[countIndex--] = producedString;
			}

			@Override
			public String getDataInDesire(Key aKey, Obj anObject) {
				return "("+aKey+", "+anObject+")\n";
			}

			@Override
			public void inOrderTraversalStringBuilder(BinaryNode<Key,Obj> currentRoot, int traversalCount) 
			{
				if(currentRoot == null)
					return;
				StringBuffer buffer = new StringBuffer();
				
				for(int i = 0; i < traversalCount; i++)
					buffer.append("\t");
				
				inOrderTraversalStringBuilder(currentRoot.left(),traversalCount+1);
				this.getString(buffer.append(this.getDataInDesire(currentRoot.element().key(), currentRoot.element().object())).toString());
				inOrderTraversalStringBuilder(currentRoot.right(),traversalCount+1);
			}
			@Override
			public int getSize() {
				return drawString.length;
			}
			public String[] drawString()
			{
				return this.drawString;
			}

		};
	}
	
	// dictionary 그리기
	
	// Traversal
	
	private void inOrderTraversal(BinaryNode<Key,Obj> currentRoot)
	{

		if(currentRoot == null)
			return;
		
		inOrderTraversal(currentRoot.left());
		this.visit(currentRoot.element().object());
		inOrderTraversal(currentRoot.right());
	}
	private void preOrderTraversal(BinaryNode<Key,Obj> currentRoot)
	{

		if(currentRoot == null)
			return;

		this.visit(currentRoot.element().object());
		inOrderTraversal(currentRoot.left());
		inOrderTraversal(currentRoot.right());
	}
	private void postOrderTraversal(BinaryNode<Key,Obj> currentRoot)
	{

		if(currentRoot == null)
			return;
		
		inOrderTraversal(currentRoot.left());
		inOrderTraversal(currentRoot.right());
		this.visit(currentRoot.element().object());
	}
	
	// Traversal
	
	
	private boolean keyDoesExistInTree(BinaryNode<Key,Obj> currentRoot, Key aKey)
	{
		if(this._root == null)
			return false;
		if(currentRoot.element().key().compareTo(aKey) == 0)
			return true;
		else if (currentRoot.element().key().compareTo(aKey) > 0)
			return keyDoesExistInTree(currentRoot.left(), aKey);
		else
			return keyDoesExistInTree(currentRoot.right(), aKey);
	}
	private boolean addKeyAndObjectToSubtree(BinaryNode<Key,Obj> currentRoot, Key aKey, Obj anObject)
	{
		if(currentRoot.element().key().compareTo(aKey) == 0)
			return false;
		else if (currentRoot.element().key().compareTo(aKey) > 0)
		{
			if(currentRoot.left() == null)
				currentRoot.setLeft(new BinaryNode<Key,Obj>(new Element<Key,Obj>(aKey, anObject)));
			else
				return addKeyAndObjectToSubtree(currentRoot.left(), aKey, anObject);
			this._size++;
			return true;
		}
		else
		{
			if(currentRoot.right() == null)
				currentRoot.setRight(new BinaryNode<Key,Obj>(new Element<Key,Obj>(aKey, anObject)));
			else
				return addKeyAndObjectToSubtree(currentRoot.right(), aKey, anObject);
			this._size++;
			return true;
		}
	}
	private BinaryNode<Key,Obj> removeRightMostOfLeftTree(BinaryNode<Key,Obj> currentRoot)
	{
		BinaryNode<Key,Obj> leftOfCurrentRoot = currentRoot.left();
		if(leftOfCurrentRoot == null)	//자식이 있는지 확인
			return null;
		if(leftOfCurrentRoot.right() == null)
		{
			currentRoot.setLeft(leftOfCurrentRoot.left());
			this._size--;
			return leftOfCurrentRoot;
		}
		else
		{
			BinaryNode<Key,Obj> parentOfRightMost = leftOfCurrentRoot;
			BinaryNode<Key,Obj> rightMost = leftOfCurrentRoot.right();
			while(rightMost.right() != null)	//오른쪽 제일 아래의 있는 노드를 찾는다.
			{
				parentOfRightMost = rightMost;
				rightMost = rightMost.right();
			}
			parentOfRightMost.setRight(rightMost.left());
			rightMost.setLeft(null);
			this._size--;
			return rightMost;
		}
	}
	private Obj removeObjectForKeyFromSubtree(BinaryNode<Key,Obj> currentRoot, Key aKey)
	{
		if(currentRoot.element().key().compareTo(aKey) > 0)  // 탐색할 곳은 왼쪽 subtree
		{
			BinaryNode<Key,Obj> child = currentRoot.left();
			if(child == null)
				return null;
			else
			{
				if(child.element().key().compareTo(aKey) == 0)	//삭제할 object 찾음
				{
					Obj removedObject = child.element().object();
					
					if((child.left() == null) && (child.right() == null))  //child 가 leaf상태
						currentRoot.setLeft(null);
					else if(child.left() == null)	//child의 왼쪽이 없으므로 오른쪽을 subtree
						currentRoot.setLeft(child.right());
					else if(child.right() == null)	//child의 오른쪽이 없으므로 왼쪽을 subtree
						currentRoot.setLeft(child.left());
					else	//둘다 존재하므로 제일 큰 값을 찾아서 치환
					{
						BinaryNode<Key,Obj> newChild = removeRightMostOfLeftTree(child);
						newChild.setLeft(child.left());
						newChild.setRight(child.right());
						currentRoot.setLeft(newChild);
					}
					this._size--;
					return removedObject;
				}
				else
					return removeObjectForKeyFromSubtree(child, aKey);
			}
		}
		else	//compareTo가 0인것은 이미 비교한 상태이므로 else로 처리
		{
			BinaryNode<Key,Obj> child = currentRoot.right();	//right일뿐 left에서 삭제하는것과 다를바없다.
			if(child == null)
				return null;
			else
			{
				if(child.element().key().compareTo(aKey) == 0)	//삭제할 object 찾음
				{
					Obj removedObject = child.element().object();
					
					if((child.left() == null) && (child.right() == null))  //child 가 leaf상태
						currentRoot.setRight(null);
					else if(child.left() == null)	//child의 왼쪽이 없으므로 오른쪽을 subtree
						currentRoot.setRight(child.right());
					else if(child.right() == null)	//child의 오른쪽이 없으므로 왼쪽을 subtree
						currentRoot.setRight(child.left());
					else	//둘다 존재하므로 제일 큰 값을 찾아서 치환
					{
						BinaryNode<Key,Obj> newChild = removeRightMostOfLeftTree(child);
						newChild.setLeft(child.left());
						newChild.setRight(child.right());
						currentRoot.setRight(newChild);
					}
					this._size--;
					return removedObject;
				}
				else
					return removeObjectForKeyFromSubtree(child, aKey);
			}
		}
	}
}
