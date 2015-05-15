import java.util.*;

public class Objet {
String emplacement, nom, description, statEffet;
double effet;

public Objet(String nom, String description, String stat, double value, String emplacement){
	this.nom = nom;
	this.description = description;
	statEffet = stat;
	effet = value;
	this.emplacement = emplacement;
}

public void decrire(){
	System.out.println("Nom : "+nom);
	System.out.println("Description : "+description);
	System.out.println("Ajoute +" + effet*100 + "% à "+ statEffet);
}

public void equiper(Map<String, Objet> perso){
	perso.put(emplacement, this);
}

public String getEmplacement()
{
	return (emplacement);
}
}