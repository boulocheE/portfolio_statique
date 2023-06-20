import javax.swing.*;

import java.awt.GridLayout;

public class FrameAnneau extends JFrame
{
	private Controleur  ctrl;

	private PanelVille panelVille;
	private PanelRoute panelRoute;


	public FrameAnneau ( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.setTitle ( "Définition de la Carte" );
		this.setSize  ( 1000, 180 );

		this.setLayout( new GridLayout(1, 2) );

		this.panelVille = new PanelVille( this.ctrl );
		this.panelRoute = new PanelRoute( this.ctrl );

		this.add ( this.panelVille );
		this.add ( this.panelRoute );

		this.setVisible(true);
	}

}