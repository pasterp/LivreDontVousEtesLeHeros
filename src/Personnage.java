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
		De dé = new De();
		this.defStats(dé.roll()+dé.roll(), (5+dé.roll()+dé.roll()), (5+dé.roll()+dé.roll()), dé.roll());
	}//TODO : assignement des caractérisitiques (Tiona)
	
	
	
	public void fichePersonnage(){
		//TODO : affiche la fiche du personnage (résumé des caractéristiques, etc...)
	}

}
