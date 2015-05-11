/**
 * 
 */

/**
 * @author Pascal
 *
 */
public class Adversaire extends Creature{

	/**
	 * 
	 */
	public Adversaire(String nom, String description, int HP, int FOR, int LCK, int DEX, int INT) {
		this.stats.replace("HP", HP);
		this.defStats(INT, FOR, DEX, LCK);
		// TODO Assignement of the variable and random strategie of the enemy
	}

}
