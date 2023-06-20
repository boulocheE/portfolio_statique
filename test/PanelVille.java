import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class PanelVille extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private JPanel     panelSaisie;
	private JPanel     panelBoutons;

	private JTextField txtNom;
	private JTextField txtPositionX;
	private JTextField txtPositionY;

	private JLabel     lbVerifNom;
	private JLabel     lbVerifPositionX;
	private JLabel     lbVerifPositionY;

	private JButton    btAjouter;
	private JButton    btVerifier;


	public PanelVille ( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.setLayout ( new GridLayout( 2, 1 ) );


		/*-------------------------------*/
		/* création des composants       */
		/*-------------------------------*/
		this.panelSaisie  = new JPanel();
		this.panelBoutons = new JPanel();

		this.txtNom       = new JTextField(15);
		this.txtPositionX = new JTextField(15);
		this.txtPositionY = new JTextField(15);

		this.lbVerifNom       = new JLabel( "..." );
		this.lbVerifPositionX = new JLabel( "..." );
		this.lbVerifPositionY = new JLabel( "..." );

		this.btAjouter  = new JButton( "Ajouter"  );
		this.btVerifier = new JButton( "Verifier" );


		this.panelSaisie .setLayout ( new GridLayout(3, 3) );


		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.add( this.panelSaisie  );
		this.add( this.panelBoutons );


		this.panelSaisie.add( new JLabel( "nom : " ), JLabel.LEFT );
		this.panelSaisie.add( this.txtNom            );
		this.panelSaisie.add( this.lbVerifNom        );

		this.panelSaisie.add( new JLabel( "position x : " ) );
		this.panelSaisie.add( this.txtPositionX             );
		this.panelSaisie.add( this.lbVerifPositionX         );

		this.panelSaisie.add( new JLabel( "position y : " ) );
		this.panelSaisie.add( this.txtPositionY             );
		this.panelSaisie.add( this.lbVerifPositionY         );


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
		String  nomVille;
		int     posX, posY;

		posX = posY = 0;

		if ( e.getSource() == this.btVerifier )
			this.ctrl.listeVilleConsole();

		if ( e.getSource() == this.btAjouter )
		{
			nomVille = this.txtNom.getText();

			if ( nomVille.length() < 1 )
			{
				this.lbVerifNom.setText( "saisie incorrecte" );
				saisieCorrect = false;
			}
			else
			{
				this.lbVerifNom.setText( "..." );
			}


			try
			{
				posX = Integer.parseInt( this.txtPositionX.getText() );
				this.lbVerifPositionX.setText( "..." );
			}
			catch ( Exception exp )
			{
				this.lbVerifPositionX.setText( "saisie incorrecte" );
				saisieCorrect = false;
			}


			try
			{
				posX = Integer.parseInt( this.txtPositionY.getText() );
				this.lbVerifPositionY.setText( "..." );
			}
			catch ( Exception exp )
			{
				this.lbVerifPositionY.setText( "saisie incorrecte" );
				saisieCorrect = false;
			}


			if ( saisieCorrect ) { this.ctrl.ajouterVille( nomVille, posX, posY ); }
		}
	}

}