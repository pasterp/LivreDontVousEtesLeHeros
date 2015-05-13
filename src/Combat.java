import java.util.Scanner;

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
	Scanner sc = new java.util.Scanner(System.in);
	/**
	 * 
	 */
	public Combat(Personnage heros, Adversaire mechant) {
		// TODO Auto-generated constructor stub
		user = heros;
		IA = mechant;
	}
	
	public int debutCombat(){
		while (user.isAlive() && IA.isAlive()){
			
		}
		return 1; //1 -> Win -1 -> Loose 0-> Fuite
	}

	
	public int askUser(){
		
		return 1;
		}
	
	public int thinkingIA(){
		
		return 1;
	}
	
}
