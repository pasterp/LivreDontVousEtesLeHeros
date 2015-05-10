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
	

	/**
	 * @Page : L'élement Page extrait du xml qui contient les infos de la page actuelle
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
	}
	
	public void afficherPage(){
		System.out.println("Page "+ numeroPage + " : " + titrePage);
		System.out.println(descriptionPage);
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
		// TODO : retourner le numéro de la page suivante/-1 sinon
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
			if (choix.getChild("condition") != null && heros.getStat(choix.getChild("condition").getAttributeValue("attribut")) >= choix.getChild("condition").getAttribute("niveau").getIntValue()){
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
