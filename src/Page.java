/**
 * 
 */
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
/**
 * @author pasca_000
 *
 */
public class Page {
	int numeroPage;
	String titrePage;
	String descriptionPage;
	List<Element> choixPage;
	Personnage heros;
	List<Integer> liste_choix = new ArrayList<Integer>();
	List<Element> eventsPage;

	/**
	 * @Page : L'�lement Page extrait du xml qui contient les infos de la page actuelle
	 * @Heros : Objet contenant les informations de notre personnage, son inventaire et ses stats.
	 */
	public Page(Element page, Personnage heros) {
		// TODO Auto-generated constructor stub
		this.heros = heros;
		
		try {
			numeroPage = page.getAttribute("numero_page").getIntValue();
			titrePage = page.getChild("titre").getText();
			descriptionPage = page.getChild("description_page").getText();
		} catch (DataConversionException e) {e.printStackTrace();}
		choixPage = page.getChildren("choix");
		eventsPage = page.getChildren("event");
	}
	
	public void afficherPage(){
		System.out.println("Page "+ numeroPage + " : " + titrePage);
		System.out.println(descriptionPage);
	}
	
	public void readEvents(){
		//TODO : parcourir les events (ajouter/enlever un objet, lancer un combat etc...)_
		for(Element event : eventsPage){
			System.out.println(event.getText());
			switch(event.getAttribute("type").getValue()){
				case "combat":
					System.out.println("D�but d'un combat !");
					Element adv = event.getChild("adversaire");
					String[] statsNames = {"HP", "FOR", "INT", "DEX", "LCK"};
					for(String stat : statsNames){
						//TODO : REIHTJIHOJZRHOETJHOTEDKHGOE
					}
					Adversaire adversaire = new Adversaire(adv.getAttributeValue("nom"), adv.getText(), Integer.valueOf(adv.getAttributeValue("hp")), 5, 5, 5, 5);
					adversaire.descriptif_DEBUG();
					break;
			}
		}
	}
	
	public int listerChoix() {
		//On parcourt tous les choix et on liste leur ids, on les affiche.	
		for(Element choix : choixPage){
			System.out.println(""+choix.getAttributeValue("id_choix")+" - "+choix.getChildText("description_choix"));
			try { liste_choix.add(choix.getAttribute("id_choix").getIntValue());} 
			catch (DataConversionException e) {}
		}	
		return choixPage.size();
	}
	
	public int choisirSuite(int choix){
		// TODO : retourner le num�ro de la page suivante/-1 sinon
		for (Element choix_tmp : choixPage){
			try {
				if (choix_tmp.getAttribute("id_choix").getIntValue()  == choix){
					Element suite;
					if ((suite = testerConditionSuite(choix_tmp.getChild("page_suivante"))).getAttributeValue("texte_reussite") != null){
						System.out.println(suite.getAttributeValue("texte_reussite"));
					}
					return Integer.parseInt(suite.getText());
				}
			} catch (DataConversionException e) {e.printStackTrace();}
		}
		return -1;
	}
	
	public Element testerConditionSuite(Element choix){
		try {
			if (choix.getChild("condition") != null && (int)heros.getStat(choix.getChild("condition").getAttributeValue("attribut")) >= choix.getChild("condition").getAttribute("niveau").getIntValue()){
				return testerConditionSuite(choix.getChild("condition"));
			}
			else {
				return choix;
			}
		}catch (DataConversionException e){
			return choix;
		}
	}

}
