package iterator;

public class Node <T extends Comparable<T>> implements Comparable<T>{ 
	private T _element;
	private Node<T> _next;
	
	public Node()
	{
		this(null,null);
	}
	public Node(T anElement)
	{
		this(anElement,null);
	}
	public Node(T anElement, Node<T> aNode)
	{
		this._element = anElement;
		this._next = aNode;
	}
	
	public T element()
	{
		return this._element;
	}
	public void setElement(T anElement)
	{
		this._element = anElement;
	}
	public Node<T> next()
	{
		return this._next;
	}
	public void setNext(Node<T> aNode)
	{
		this._next = aNode;
	}
	@Override
	public int compareTo(T o) {
		return this._element.compareTo(o);
	}
}

