var choixAvant = 1;


function choixMenu ( event, apres )
{
	var ancienChoix = document.getElementById( 'comp' + choixAvant );
	ancienChoix.style.display = 'none';

	var choixCompetence = document.getElementById( 'comp' + apres );
	choixCompetence.style.display = 'block';

	var choixAvantMenu = document.getElementById( 'choixComp' + choixAvant );
	choixAvantMenu.style.color = 'rgba( 106,103,49, 0.5 )';

	var choixApresMenu = document.getElementById( 'choixComp' + apres );
	choixApresMenu.style.color = 'black';

	var styleAvantMenu = document.getElementById( 'choixMenuComp' + choixAvant );
	styleAvantMenu.style.display = 'none';

	var styleApresMenu = document.getElementById( 'choixMenuComp' + apres );
	styleApresMenu.style.width  = choixApresMenu.offsetWidth;
	styleApresMenu.style.height = choixApresMenu.offsetHeight;


	choixAvant = apres;
}