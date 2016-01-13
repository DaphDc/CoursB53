package projet_echecs;

public class Fou extends Piece 
{
	/**
	* constructeur pour un Fou
	* @param nom de la piece
	* @param couleur de la piece
	*/
	public Fou(String nom, String couleur)
	{
		super(nom,couleur);
	}

	@Override
	// se déplace en diagonale d'un nombre X de cases.
	public boolean estValide(Position depart, Position arrivee) 
	{
		//on vérifie que la colonne et la ligne se situe sur l'échéquier.
		if(depart.estCoordonnesValide() == false || arrivee.estCoordonnesValide() == false)
		{
			return false;
		}
		//un déplacement nul est un déplacement valide.
		else if(depart.getColonne() == arrivee.getColonne() && depart.getLigne() == arrivee.getLigne())
		{
			return true;
		}
		//on vérifie que le delta x est égal au delta y. Ce qui est le cas dans une diagonale.
		else if (Math.abs(depart.getLigne() - arrivee.getLigne()) == Math.abs(depart.getColonne() - arrivee.getColonne()))
		{
			return true;
		}
		else
			return false;
	}
}
