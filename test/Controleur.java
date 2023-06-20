/**
 * Controleur : Permettant de faire le lien entre la partie Metier et votre Partie IHM
 * @author Philippe Le Pivert
 */
public class Controleur
{
	private Carte        metier;
	private FrameAnneau  ihm;


	public Controleur ()
	{
		this.metier = new Carte();
		this.ihm    = new FrameAnneau ( this );
	}


	public void ajouterVille ( String nom, int posX, int posY )
	{
		this.metier.ajouterVille(nom, posX, posY);
	}

	public boolean ajouterRoute ( String nomVille1, String nomVille2, char naturePrincipale, char autreNature1, char autreNature2 )
	{
		return this.metier.ajouterRoute ( nomVille1, nomVille2, naturePrincipale, autreNature1, autreNature2 );
	}

	public boolean nomVilleValide ( String nom ){ return this.metier.nomVilleValide( nom ); }


	// Affiche l'ensemble des Villes dans la Console
	public void listeVilleConsole()
	{
		int nbVille = this.metier.getNbVille();

		System.out.println ();
		System.out.println ( "------------------------------" );
		System.out.println ( "       Liste des Villes       " );
		System.out.println ( "------------------------------" );
		System.out.println ();

		for (int cpt = 0; cpt< nbVille; cpt++ )
			System.out.println ( this.metier.getVille(cpt).toString() );

		System.out.println ("\n" + nbVille + " villes\n" );
	}


	// Affiche l'ensemble des Routes dans la Console
	public void listeRouteConsole()
	{
		int nbRoute = this.metier.getNbRoute();

		System.out.println ();
		System.out.println ( "------------------------------" );
		System.out.println ( "       Liste des Routes       " );
		System.out.println ( "------------------------------" );
		System.out.println ();

		for (int cpt = 0; cpt< nbRoute; cpt++ )
			System.out.println ( this.metier.getRoute(cpt).toString() );

		System.out.println ("\n" + nbRoute + " routes\n" );
	}	

	public static void main(String[] a)
	{
		new Controleur();
	}


}