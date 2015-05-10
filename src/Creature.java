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
	String m_descriptif;
	Map<String, Integer> stats;
	Map<String, Integer> effectsOnStats;
	
	public Creature(){
		stats = new HashMap<String, Integer>();
		stats.put("HP", 100);
		effectsOnStats = new HashMap<String, Integer>();
		initStats();
	}
	
	public void initStats(){
		this.stats.put("INT", 0);
		this.effectsOnStats.put("INT", 1);
		this.stats.put("INT", 0);
		this.effectsOnStats.put("FOR", 1);
		this.stats.put("INT", 0);
		this.effectsOnStats.put("DEX", 1);
		this.stats.put("INT", 0);
		this.effectsOnStats.put("LCK", 1);
	}
	
	public void defStats(int INT, int FOR, int DEX, int LCK){
		this.stats.replace("INT", INT);
		this.stats.replace("FOR", FOR);
		this.stats.replace("DEX", DEX);
		this.stats.replace("LCK", LCK);
	}
	
	public int getHP(){
		return stats.get("HP");
	}
	
	public int getStat(String stat){
		if (stat == "HP") { return this.getHP(); }
		else if (stats.get(stat) != null){
			return this.stats.get(stat)*this.effectsOnStats.get(stat);
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
	
	public void descriptif_DEBUG(){
		String[] statsNames = {"HP", "STR", "INT", "DEX", "LCK"};
		for(String statName : statsNames){
			System.out.println(statName + " : " + this.getStat(statName));
		}
	}
	
	public int calculPuissance() {
		
		return 1;
	}
	
	public int infligerDegats(Creature cible){
		
		return cible.recevoirDegats(this.calculPuissance());
	}
	
	public int recevoirDegats(int nb_degats){
		
		return 0;
	}
}
