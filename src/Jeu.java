import java.io.*;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author pasca_000
 *
 */
public class Jeu {

	public static boolean sauvegarderJeu(String sauvegardeName, Page page_actuelle, Personnage heros){
		String sauvegardePath = "saves/"+sauvegardeName+".save";
		FileOutputStream save;
		try {
			save = new FileOutputStream(sauvegardePath);
			ObjectOutputStream oos = new ObjectOutputStream(save);
			//oos.writeObject(page_actuelle);
//			oos.writeObject(heros);
			oos.close();
			save.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean chargerJeu(String sauvegardeName, Page page_actuelle, Personnage heros){
		String sauvegardePath = "saves/"+sauvegardeName+".save";
		FileInputStream save;
		try {
			save = new FileInputStream(sauvegardePath);
			ObjectInputStream ois = new ObjectInputStream(save);
			//page_actuelle = (Page)ois.readObject();
//			heros = (Personnage)ois.readObject();
			ois.close();
			save.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int page_suivante=1, entreeEntiere=0;
		Scanner sc = new Scanner(System.in);
		Page page_actuelle;
		Personnage notreHeros = new Personnage("Notre Heros");
		String fichier="testing.xml", entree="";
		Lecteur livre = new Lecteur(fichier);
		do {
			page_actuelle = new Page(livre.ouvrirALaPage(page_suivante), notreHeros);
			page_actuelle.afficherPage();
			if (page_actuelle.listerChoix() > 0){
				do{
					System.out.print("Quel est votre choix ? ");
					entree = sc.next();
					if (entree.charAt(0)== '/'){
						switch (entree.toLowerCase()){
							case "/status":
							case "/stat":
							case "/s":
								//TODO : statut du personnage (hp, effet, att/def )
								break;
								
							case "/me":
								//TODO : Descriptif du perso (nom, bio et stat)
								break;
								
							case "/pause":
								System.out.println("Prenez une pause, je vous attends...");
								System.out.print("==PAUSE==");
								try {
									System.in.read();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
								
							case "/save":
								System.out.print("Entrez le nom de votre sauvegarde : ");
								if(sauvegarderJeu(sc.next(), page_actuelle, notreHeros)){
									System.out.println("Sauvegarde réussie !");
								}
								else {
									System.out.println("Echec de la sauvegarde !");
								}
								break;
								
							case "/load":
								System.out.print("Entrez le nom de votre sauvegarde : ");
								if(chargerJeu(sc.next(), page_actuelle, notreHeros)){
									System.out.println("Chargement réussi !");
								}
								else{
									System.out.println("Chargement échoué");
								}
								break;
						//TODO : Commandes
						}
						entreeEntiere = -666;
					} else {
						entreeEntiere = Integer.parseInt(entree.split(" ")[0]);	
					}
				}while((page_suivante=page_actuelle.choisirSuite(entreeEntiere)) <= 0);
			}
			else {
				//On suppose que l'on est à la fin du jeu s'il n'y a plus de choix
				page_suivante = -1;//TODO : Savoir ou aller dans ce cas
			}
		}while (page_suivante >= 0);
		
		sc.close();
	}

}
