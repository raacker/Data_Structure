package dictionary;

public class BinaryNode <Key extends Comparable<Key>, Obj>{
	private Element<Key,Obj> _element;
	private BinaryNode<Key,Obj> _left;
	private BinaryNode<Key,Obj> _right;
	
	public BinaryNode()
	{
		this(null,null,null);
	}
	public BinaryNode(Element<Key,Obj> anElement)
	{
		this(anElement,null,null);
	}
	public BinaryNode(BinaryNode<Key,Obj> aLeft, BinaryNode<Key,Obj> aRight)
	{
		this(null,aLeft,aRight);
	}
	public BinaryNode(Element<Key,Obj> anElement, BinaryNode<Key,Obj> aLeft, BinaryNode<Key,Obj> aRight)
	{
		this._element = anElement;
		this._left = aLeft;
		this._right = aRight;
	}
	
	public Element<Key,Obj> element()
	{
		return this._element;
	}
	public void setElement(Element<Key,Obj> anElement)
	{
		this._element = anElement;
	}
	public BinaryNode<Key,Obj> left()
	{
		return this._left;
	}
	public void setLeft(BinaryNode<Key,Obj> aLeft)
	{
		this._left = aLeft;
	}
	public BinaryNode<Key,Obj> right()
	{
		return this._right;
	}
	public void setRight(BinaryNode<Key,Obj> aRight)
	{
		this._right = aRight;
	}
}
