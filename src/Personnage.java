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
		De d� = new De();
		this.defStats(d�.roll()+d�.roll(), (5+d�.roll()+d�.roll()), (5+d�.roll()+d�.roll()), d�.roll());
		inventairePersonnage.ajouter(new Objet("Couteau", "Une simple lame � l'efficatit� redoutable (sur des patates)", "FOR", 0.5, "Main droite"));
	}//TODO : assignement des caract�risitiques (Tiona)
	
	
	
	public void fichePersonnage(){
		//TODO : affiche la fiche du personnage (r�sum� des caract�ristiques, etc...)
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
