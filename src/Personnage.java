import java.util.Map;

/**
 * 
 */

/**
 * @author pasca_000
 *
 */
public class Personnage extends Creature {
	String bioPersonnage;
	Map<String, Integer> statsPersonnage;
	/**
	 * 
	 */
	public Personnage(String nom) {
		this.m_nom = nom;
		De d� = new De();
		this.defStats(d�.roll()+d�.roll(), (5+d�.roll()+d�.roll()), (5+d�.roll()+d�.roll()), d�.roll());
	}//TODO : assignement des caract�risitiques (Tiona)
	
	
	
	public void fichePersonnage(){
		//TODO : affiche la fiche du personnage (r�sum� des caract�ristiques, etc...)
	}

}
