import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class PanelRoute extends JPanel implements ActionListener
{
	private Controleur   ctrl;

	private JPanel       panelVilles;
	private JPanel       panelNaturePrincipale;
	private JPanel       panelNatureSecondaire;
	private JPanel       panelBoutons;

	private JTextField   txtVille1;
	private JTextField   txtVille2;

	private JRadioButton rbPlaine;
	private JRadioButton rbMontagne;
	private JRadioButton rbForet;

	private JCheckBox    cbPlaine;
	private JCheckBox    cbMontagne;
	private JCheckBox    cbForet;

	private JLabel       lbMessageErreur;

	private JButton      btAjouter;
	private JButton      btVerifier;


	public PanelRoute ( Controleur ctrl )
	{

		this.ctrl = ctrl;

		this.setLayout ( new GridLayout( 5, 1 ) );


		/*-------------------------------*/
		/* création des composants       */
		/*-------------------------------*/
		this.panelVilles           = new JPanel();
		this.panelNaturePrincipale = new JPanel();
		this.panelNatureSecondaire = new JPanel();
		this.lbMessageErreur       = new JLabel();
		this.panelBoutons          = new JPanel();

		this.txtVille1 = new JTextField(15);
		this.txtVille2 = new JTextField(15);

		this.rbPlaine   = new JRadioButton( "Plaine"   );
		this.rbMontagne = new JRadioButton( "Montagne" );
		this.rbForet    = new JRadioButton( "Foret"    );

		this.cbPlaine   = new JCheckBox( "Plaine"   );
		this.cbMontagne = new JCheckBox( "Montagne" );
		this.cbForet    = new JCheckBox( "Foret"    );

		this.lbMessageErreur = new JLabel();

		this.btAjouter  = new JButton( "Ajouter"  );
		this.btVerifier = new JButton( "Vérifier" );


		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.add( this.panelVilles           );
		this.add( this.panelNaturePrincipale );
		this.add( this.panelNatureSecondaire );
		this.add( this.lbMessageErreur       );
		this.add( this.panelBoutons          );


		this.panelVilles.add( new JLabel( "ville1 : " ) );
		this.panelVilles.add( this.txtVille1            );
		this.panelVilles.add( new JLabel( "ville2 : " ) );
		this.panelVilles.add( this.txtVille2            );


		this.panelNaturePrincipale.add( new JLabel( "Nature Pricipale : " ) );
		this.panelNaturePrincipale.add( this.rbPlaine   );
		this.panelNaturePrincipale.add( this.rbMontagne );
		this.panelNaturePrincipale.add( this.rbForet    );


		this.panelNatureSecondaire.add( new JLabel( "Autre Nature : " ) );
		this.panelNatureSecondaire.add( this.cbPlaine   );
		this.panelNatureSecondaire.add( this.cbMontagne );
		this.panelNatureSecondaire.add( this.cbForet    );

		this.panelBoutons.add( this.btAjouter  );
		this.panelBoutons.add( this.btVerifier );


		/*-------------------------------*/
		/* activation des composants     */
		/*-------------------------------*/
		this.btAjouter .addActionListener(this);
		this.btVerifier.addActionListener(this);

	}


	public void actionPerformed ( ActionEvent e )
	{
		boolean saisieCorrect = true;

		String  ville1, ville2;
		char    naturePrincipale, autreNature1, autreNature2;


		if ( e.getSource() == this.btVerifier )
			this.ctrl.listeRouteConsole();

		if ( e.getSource() == this.btAjouter )
		{
			ville1 = this.txtVille1.getText();
			ville2 = this.txtVille2.getText();

			if ( !this.ctrl.nomVilleValide(ville1) || !this.ctrl.nomVilleValide(ville2) )
			{
				this.lbMessageErreur.setText( "Saisie incorrecte" );
				saisieCorrect = false;
			}

			// System.out.println( this.cbForet.get )
		}


		// if ( saisieCorrect ) { this.ctrl.ajouterRoute( ville1, ville2, naturePrincipale, autreNature1, autreNature2 ); }
	}
}