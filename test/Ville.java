public class Ville
{
	private String nom;
	private int    posX;                          // position de X en pixel;
	private int    posY;                          // position de Y en pixel;
	


	public Ville ( String nom, int posX, int posY )
	{
		this.nom  = nom;
		this.posX = posX;
		this.posY = posY;
	}

	public int     getPosX() { return this.posX; }
	public int     getPosY() { return this.posY; }
	public String  getNom () { return this.nom;  }

	public String toString ()
	{
		return String.format ( "%-20s", this.nom ) + 
		       "(" + this.posX + "," + this.posY + ")";
	}

}


