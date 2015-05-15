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
	double esquive1 = 0;
	double esquive2 = 0;
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
			if (user.getStat("DEX") >= IA.getStat("DEX")){
				askUser();
				thinkingIA();
			}
			else {
				thinkingIA();
				askUser();
			}
		}
		if (user.isAlive()){
			System.out.println(IA.nom() + " meurt devant vous, vous avez gagné !");
			return 1; //1 -> Win -1 -> Loose 0-> Fuite 
		}
		else {
			System.out.println("Vous êtes mort (peut être prématurément)...");
			return -1;
		}
	}

	
	public int askUser(){
		user.afficher();
		IA.afficher();
		int rep;
		esquive1=0;
		do{
			System.out.println("Voulez vous attaquer(1)/esquiver(2)/vous soigner(3) ?");
			rep = sc.nextInt();
		} while (rep != 1 && rep != 2 && rep !=3);
		switch (rep){
			case 1:
				System.out.println("Vous attaquez "+IA.nom());
				if (user.getStat("DEX")+(new De().roll()) > esquive2){
					System.out.println("Vous infligez "+user.infligerDegats(IA)+" dégats");
				}else{
					System.out.println(IA.nom()+" esquive votre attaque !");
				}
				
				break;
				
			case 2:
				System.out.println("Vous vous préparez à esquiver la prochaine attaque...");
				esquive1 = user.getStat("DEX")/2+(new De().roll());
				break;
				
			case 3:
				int soins= (int) (user.getHPmax()*user.getStat("INT")/150.0*(double)(new De().roll()));
				System.out.println("Vous vous soignez de : "+soins);
				user.addHP(soins);
				break;
		}
		return 1;
		}
	
	public int thinkingIA(){
		esquive2 = 0;
		int rep=0;
		do{
			rep = new De().roll();
		} while ( (rep==6 && IA.getHP() == IA.getHPmax()));
		
		switch (rep){
		case 1:
		case 3:
		case 4:
		case 5:
			System.out.println(IA.nom() + " vous attaque!");
			if (IA.getStat("DEX")+(new De().roll()) > esquive1){
				System.out.println(IA.nom() + " vous inflige "+IA.infligerDegats(user)+" dégats !");
			}else{
				System.out.println("Vous esquivez l'attaque !");
			}
			break;
			
		case 2:
			System.out.println(IA.nom() + "semble attendre que vous attaquiez...");
			esquive2 = IA.getStat("DEX")/2+(new De().roll());
			break;
			
		case 6:
			int soins= (int) (IA.getHPmax()*IA.getStat("INT")/150.0*(double)(new De().roll()));
			System.out.println(IA.nom() + "se soigne de : "+soins);
			IA.addHP(soins);
			break;
	}
		
		return 1;
	}
	
}
