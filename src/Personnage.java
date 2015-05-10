import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author pasca_000
 *
 */
public class Personnage {
	String nomPersonnage;
	String bioPersonnage;
	Map<String, Integer> statsPersonnage;
	/**
	 * 
	 */
	public Personnage(String nom) {
		nomPersonnage = nom;
		statsPersonnage = new HashMap<String, Integer>();
		statsPersonnage.put("HP", 100);
		statsPersonnage.put("INT", 8);
		statsPersonnage.put("FOR", 4);
	}//TODO : assignement des caractérisitiques (Tiona)
	
	public int getStat(String stat){
		if (statsPersonnage.get(stat) != null){
			return statsPersonnage.get(stat);
		}
		return 0;
	}
	
	public boolean isAlive(){
		if (statsPersonnage.get("HP") > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void fichePersonnage(){
		//TODO : affiche la fiche du personnage (résumé des caractéristiques, etc...)
	}

}
