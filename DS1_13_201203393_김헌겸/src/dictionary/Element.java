package dictionary;

public class Element<Key extends Comparable<Key>, Obj> implements Comparable<Key>{
	private Key _key;
	private Obj _object;
	
	public Element()
	{
		this(null,null);
	}
	public Element(Key aKey)
	{
		this(aKey,null);
	}	
	public Element(Key aKey, Obj anObject)
	{
		this._key = aKey;
		this._object = anObject;
	}

	public Key key()
	{
		return this._key;
	}
	public void setKey(Key aKey)
	{
		this._key = aKey;
	}
	public Obj object()
	{
		return this._object;
	}
	public void setObject(Obj anObject)
	{
		this._object = anObject;
	}
	
	public int compareTo(Key arg0) {
		return this._key.compareTo(arg0);
	}
}
