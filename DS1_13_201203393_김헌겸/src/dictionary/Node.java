package dictionary;

public class Node <Key extends Comparable<Key>, Obj>{
	private Element<Key, Obj> _element;
	private Node<Key, Obj> _next;
	
	public Node()
	{
		this(null, null);
	}
	public Node(Key aKey)
	{
		this(aKey, null);
	}
	public Node(Key aKey, Obj anObject)
	{
		this._element = new Element<Key,Obj>(aKey,anObject);
		this._next = null;
	}
	
	public Key key()
	{
		return this._element.key();
	}
	public void setKey(Key aKey)
	{
		this._element.setKey(aKey);
	}
	public Obj object()
	{
		return this._element.object();
	}
	public void setObject(Obj anObject)
	{
		this._element.setObject(anObject);
	}
	public Node<Key,Obj> next()
	{
		return this._next;
	}
	public void setNext(Node<Key,Obj> aNode)
	{
		this._next = aNode;
	}

}
