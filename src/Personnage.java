/**
 * 
 */

/**
 * @author pasca_000
 *
 */
public class Personnage extends Creature {
	String bioPersonnage;
	Inventaire inventairePersonnage = new Inventaire();
	
	/**
	 * 
	 */
	public Personnage(String nom) {
		this.m_nom = nom;
		bioPersonnage = " ";
		De dé = new De();
		this.defStats(dé.roll()+dé.roll(), (5+dé.roll()+dé.roll()), (5+dé.roll()+dé.roll()), dé.roll());
		inventairePersonnage.ajouter(new Objet("Couteau", "Une simple lame à l'efficatité redoutable (sur des patates)", "FOR", 0.5, "Main droite"));
	}//TODO : assignement des caractérisitiques (Tiona)
	
	
	
	public void fichePersonnage(){
		//TODO : affiche la fiche du personnage (résumé des caractéristiques, etc...)
		System.out.println("___________________________________________________\n"
						 + "|> "+m_nom+"\n"
						 + "|\n"
						 + "| "+bioPersonnage+
						 "\n| ");
						this.descriptif_DEBUG();
	}
	
	public void inventaire(){
		inventairePersonnage.afficher();
	}
	
	public void equipement(){
		inventairePersonnage.afficherObjetsEquipes();;
	}

}
