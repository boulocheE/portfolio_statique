function pageSuivante ( event, pageActuelle, pageSuivante )
{
	var pageSuivante = document.getElementById( 'page' + pageSuivante );
	pageSuivante.style.display = 'block';

	var pageAvant = document.getElementById( 'page' + pageActuelle );
	pageAvant.style.display = 'none';

	pageActuelle = 'page' + pageSuivante;
}