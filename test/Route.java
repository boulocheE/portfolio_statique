import java.util.HashMap;

public class Route
{
	private static final double ECHELLE = 2.1;       // 1 pixel = 2,1 km
	public  static final HashMap<Character, String> ensNature = new HashMap<Character,String>();

	private Ville ville1;
	private Ville ville2;
	private char  naturePrincipale;
	private char  autreNature1;
	private char  autreNature2;

	static
	{
		Route.ensNature.put ( 'P', "Plaine  "  );
		Route.ensNature.put ( 'F', "Forêt   "  );
		Route.ensNature.put ( 'M', "Montagne"  );
	}

	public Route ( Ville v1, Ville v2, char naturePrincipale, char autreNature1, char autreNature2 )
	{
		this.ville1           = v1;
		this.ville2           = v2;
		this.naturePrincipale = naturePrincipale;

		this.autreNature1     = autreNature1;
		this.autreNature2     = autreNature2;
	}

	private double distance()
	{
		double deltaX = Math.abs ( this.ville1.getPosX() - this.ville2.getPosX() );
		double deltaY = Math.abs ( this.ville1.getPosY() - this.ville2.getPosY() );

		double distance = Math.sqrt ( deltaX*deltaX + deltaY*deltaY );

		return distance * Route.ECHELLE;

	}

	public String toString()
	{
		String sRet = String.format ("%-17s", this.ville1.getNom() )                           + " / "    + 
		              String.format ("%-17s", this.ville2.getNom() )                           + "   "    +
		              String.format ("%,8.2f",this.distance() ).replace ( (char) 8239 , ' ' )  + " km   " +
		              Route.ensNature.get ( this.naturePrincipale).toUpperCase() + "  ";

		if ( this.autreNature1 != ' ' ) sRet += Route.ensNature.get ( this.autreNature1) + "  ";
		if ( this.autreNature2 != ' ' ) sRet += Route.ensNature.get ( this.autreNature2) + "  ";

		return sRet;
		
	}

}