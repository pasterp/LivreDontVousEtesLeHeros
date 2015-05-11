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
	Map<String, Double> effectsOnStats;
	
	public Creature(){
		stats = new HashMap<String, Integer>();
		stats.put("HP", 100);
		effectsOnStats = new HashMap<String, Double>();
		initStats();
	}
	
	public void initStats(){
		this.stats.put("INT", 0);
		this.effectsOnStats.put("INT", 1.0);
		this.stats.put("FOR", 0);
		this.effectsOnStats.put("FOR", 1.0);
		this.stats.put("DEX", 0);
		this.effectsOnStats.put("DEX", 1.0);
		this.stats.put("LCK", 0);
		this.effectsOnStats.put("LCK", 1.0);
		this.stats.put("RES", 1); 		//RES is for defence, a modifier for received damage
		this.effectsOnStats.put("RES", 1.0);
	}
	
	public void defStats(int INT, int FOR, int DEX, int LCK){
		System.out.println(""+INT+" "+FOR+" "+DEX+" "+LCK);
		this.stats.replace("INT", INT); // Magical Damage and magical resistance / solving in-game puzzle
		this.stats.replace("FOR", FOR); // Physical damage / Brutal method to progress in the story (at the cost of hp)
		this.stats.replace("DEX", DEX); // First round in combat, miss rate and critical bonus damage
		this.stats.replace("LCK", LCK); // Helpful in story and critical rate
	}
	
	public int getHP(){
		return stats.get("HP");
	}
	
	public boolean addHP(int hp){
		this.stats.replace("HP", this.getHP()+hp);
		if (this.isAlive()){
			return true;
		}else {
			return false;
		}
	}
	
	public double getStat(String stat){
		if (stat == "HP") { return this.getHP(); }
		else if (stats.get(stat) != null){
			return (double)this.stats.get(stat) * this.effectsOnStats.get(stat);
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
		String[] statsNames = {"HP", "FOR", "INT", "DEX", "LCK"};
		for(String statName : statsNames){
			System.out.println(statName + " : " + this.getStat(statName));
		}
	}
	
	public int calculPuissance() {
		//Use FOR DEX LUCK
		return 1;
	}
	
	public int infligerDegats(Creature cible){
		return cible.recevoirDegats(this.calculPuissance());
	}
	
	public int recevoirDegats(int nb_degats){
		nb_degats*= (1/(this.getStat("RES")));
		this.addHP(-nb_degats);
		return nb_degats;
	}
}
