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
		m_nom = nom;
		m_descriptif = description;
		this.stats.replace("HP", HP);
		maxHP = HP;
		this.defStats(INT, FOR, DEX, LCK);
		// TODO Assignement of the variable and random strategie of the enemy
	}
	
	public int[] afficherVie(){
		int[] retour = {(int)this.getStat("HP") ,maxHP};
		return retour;
	}
	
	public String nom(){
		return m_nom;
	}

}
