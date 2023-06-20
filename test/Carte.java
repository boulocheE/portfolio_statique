import java.util.List;
import java.util.ArrayList;

public class Carte
{
	private List<Ville> ensVille;
	private List<Route> ensRoute;

	public Carte()
	{
		this.ensVille = new ArrayList<Ville>();
		this.ensRoute = new ArrayList<Route>();

		this.chargerVille();
		this.chargerRoute();
	}

	public int     getNbVille     ()            { return this.ensVille.size();      }
	public Ville   getVille       (int indice ) { return this.ensVille.get(indice); }

	public int     getNbRoute     ()            { return this.ensRoute.size();      }
	public Route   getRoute       (int indice ) { return this.ensRoute.get(indice); }

	public boolean nomVilleValide ( String nom ){ return this.rechercherVille ( nom ) != null; }
	

	public void ajouterVille ( String nom, int posX, int posY )
	{
		this.ensVille.add ( new Ville ( nom, posX, posY ) );
	}

	public boolean ajouterRoute ( String nomVille1, String nomVille2, char naturePrincipale, char autreNature1, char autreNature2 )
	{
		Ville v1, v2;

		if  (  ( Route.ensNature.containsKey( naturePrincipale )                    ) &&
		       ( autreNature1 == ' ' || Route.ensNature.containsKey( autreNature1 ) ) &&
		       ( autreNature2 == ' ' || Route.ensNature.containsKey( autreNature2 ) )     )
		{

			v1 = this.rechercherVille ( nomVille1 );
			if ( v1 == null ) return false;

			v2 = this.rechercherVille ( nomVille2 );
			if ( v2 == null ) return false;

			this.ensRoute.add ( new Route ( v1, v2, naturePrincipale, autreNature1, autreNature2 ) );
			
			return true;
		}
		else
		{
			return false;
		}

	}

	private Ville rechercherVille ( String nomVille )
	{
		for ( Ville v : this.ensVille )
			if ( v.getNom().equals ( nomVille ) )
				return v;

		return null;
	}

	
	private void chargerVille()
	{
		this.ajouterVille( "Bree",           471,297 );		//  0
		this.ajouterVille( "Dol Amroth",     676,809 );		//  1
		this.ajouterVille( "Dunharrow",      703,676 );		//  2
		this.ajouterVille( "Edhellond",      693,782 );		//  3
		this.ajouterVille( "Edoras",         705,655 );		//  4
		this.ajouterVille( "Etech",          689,712 );		//  5
		this.ajouterVille( "Fondcombe",      702,260 );		//  6
		this.ajouterVille( "Fornost",        458,205 );		//  7
		this.ajouterVille( "Gouffre de Helm",650,620 );		//  8
		this.ajouterVille( "Khazad-dûm",     669,432 );		//  9
		this.ajouterVille( "Linhir",         778,818 );		// 10
		this.ajouterVille( "Minas Tirith",   885,752 );		// 11
		this.ajouterVille( "Pelagir",        858,830 );		// 12
		this.ajouterVille( "Tharbad",        532,417 );		// 13

		/*
		this.ajouterVille( "Mithlond",       247,285 ) );		// 14
		this.ajouterVille( "Esgaroth",       927,213 ) );		// 15
		*/
	}


	private void chargerRoute()
	{
		this.ajouterRoute ( "Fornost",         "Bree",            'P', ' ', ' ' );
		this.ajouterRoute ( "Bree",            "Fondcombe",       'P', 'M', ' ' );
		this.ajouterRoute ( "Bree",            "Tharbad",         'P', ' ', ' ' );
		this.ajouterRoute ( "Fondcombe",       "Khazad-dûm",      'M', ' ', ' ' );
		this.ajouterRoute ( "Tharbad",         "Gouffre de Helm", 'P', ' ', ' ' );
		this.ajouterRoute ( "Khazad-dûm",      "Gouffre de Helm", 'M', 'P', ' ' );
		this.ajouterRoute ( "Gouffre de Helm", "Edoras",          'P', ' ', ' ' );
		this.ajouterRoute ( "Edoras",          "Dunharrow",       'M', ' ', ' ' );
		this.ajouterRoute ( "Edoras",          "Minas Tirith",    'P', ' ', ' ' );
		this.ajouterRoute ( "Dunharrow",       "Etech",           'M', ' ', ' ' );
		this.ajouterRoute ( "Etech",           "Linhir",          'P', ' ', ' ' );
		this.ajouterRoute ( "Minas Tirith",    "Pelagir",         'P', ' ', ' ' );
		this.ajouterRoute ( "Pelagir",         "Linhir",          'P', ' ', ' ' );
		this.ajouterRoute ( "Linhir",          "Dol Amroth",      'P', ' ', ' ' );
		this.ajouterRoute ( "Dol Amroth",      "Edhellond",       'P', ' ', ' ' );

		/*
		this.ajouterRoute ( "Fondcombe",       "Esgaroth",        'F', 'P', 'M' );
		this.ajouterRoute ( "Mithlond",        "Bree",            'P', ' ', ' ' );
		*/
	}
	
}