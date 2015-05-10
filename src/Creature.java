import java.util.HashMap;
import java.util.Map;

/**
 * Classe abstraite 
 * 	-> Personnage
 * 	-> Adversaire
 * 
 * 	Contient des statistiques de bases et les implémentations des calculs de dégats et 
 * 	des test de chance/force/vitalité
 */

/**
 * @author Pascal
 *
 */
public class Creature {
	String m_nom;
	Map<String, Integer> stats;
	
	public Creature(){
		stats = new HashMap<String, Integer>();
		stats.put("HP", 100);
		stats.put("INT", 8);
		stats.put("FOR", 4);
	}
	
	public int getStat(String stat){
		if (stats.get(stat) != null){
			return stats.get(stat);
		}
		return 0;
	}
	
	public boolean isAlive(){
		if (stats.get("HP") > 0){
			return true;
		}else{
			return false;
		}
	}
	
}
