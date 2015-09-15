package dictionary;

public interface DrawDictionary<Key extends Comparable<Key>,Obj> {
	public void drawDictionary();
	public abstract int getSize();
	public abstract String[] drawString();
	public abstract void getString(String producedString);
	public abstract String getDataInDesire(Key aKey, Obj anObject);
	public void inOrderTraversalStringBuilder(BinaryNode<Key,Obj> currentRoot, int traversalCount);
}
