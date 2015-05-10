import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 * 
 */

/**
 * @author pasca_000
 *
 */
public class Lecteur {
	Document histoire;
	SAXBuilder lecteurXML = new SAXBuilder();
	List<Element> aventure;
	Element univers;
	
	/**
	 * 
	 */
	public Lecteur(String histoire) {
		File fichierXML = new File(histoire);
		if (fichierXML.exists()){
			try {
				this.histoire = (Document)lecteurXML.build(fichierXML);
				univers = this.histoire.getRootElement().getChild("univers");
				aventure = this.histoire.getRootElement().getChildren("page");
				
				
			} catch (JDOMException | IOException e) {
				e.printStackTrace();
				System.out.println("Impossible d'ouvrir l'histoire");}	
		}else{
			System.out.println("Impossible d'ouvrir l'histoire");
		}
		
	}
	
	public Univers loadUnivers(){
		//Fonction qui doit charger les classes, les noms des éléments du monde et d'autres trucs 
		//dépendant de l'histoire en cours
		if (univers != null){
			Univers univers = new Univers();
			
			
			return univers;
		}
		else {
			System.out.println("Un banal univers s'offre à vous.");
			return new Univers();
		}
	}
	
	public Element ouvrirALaPage(int n){
		for (Element page : aventure){
			try {
				if (page.getAttribute("numero_page").getIntValue() == n){
					return page;
				}
			} catch (DataConversionException e) {e.printStackTrace();}
		}
		//Si on ne trouve rien, on renvoie la première page et on informe du problème.
		System.out.println("La page demandé n'existe pas ou est mal écrite.");
		return histoire.getRootElement().getChild("page");
	}
	
	

}
