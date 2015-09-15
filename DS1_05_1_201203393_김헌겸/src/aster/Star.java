package aster;

public class Star {
	private int _xCoordinate;
	private int _yCoordinate;
	private String _starName;
	
	public Star()
	{
		this._starName = null;
	}
	public Star(int aX, int aY)
	{
		this._xCoordinate = aX;
		this._yCoordinate = aY;
	}
	public Star(String aStarName)
	{
		this._starName = aStarName;
	}
	public Star(int aX,int aY, String aStarName)
	{
		this._xCoordinate = aX;
		this._yCoordinate = aY;
		this._starName = aStarName;
	}
	public int xCoordinate()
	{
		return this._xCoordinate;
	}
	public int yCoordinate()
	{
		return this._yCoordinate;
	}
	public String starName()
	{
		return this._starName;
	}
	public void setXCoordinate(int aX)
	{
		this._xCoordinate = aX;
	}
	public void setYCoordinate(int aY)
	{
		this._yCoordinate = aY;
	}
	public void setStarName(String aStarName)
	{
		this._starName = aStarName;
	}
	public boolean equals(Star aStar)
	{
		boolean check = false;
		if((this._xCoordinate == aStar.xCoordinate()) && (this._yCoordinate == aStar.yCoordinate()))
			check = true;
		else if((this._starName != null) && (this._starName.equals(aStar.starName())))
			check = true;
		return check;
	}
}
