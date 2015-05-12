/**
 * gestion des combats
 */

/**
 * @author Pascal
 *
 */
public class Combat {
	Personnage user;
	Adversaire IA;
	/**
	 * 
	 */
	public Combat(Personnage heros, Adversaire mechant) {
		// TODO Auto-generated constructor stub
		user = heros;
		IA = mechant;
	}
	
	public int debutCombat(){
		
		return 1; //1 -> Win -1 -> Loose 0-> Fuite
	}

	
}
