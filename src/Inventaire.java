import java.util.*;

public class Inventaire {
	List<Objet> mesObjets = new ArrayList<Objet>();
	static Map<String, Objet> ObjetPerso =  new HashMap<String, Objet>();
	
	public void ajouter(Objet n)
	{
		mesObjets.add(n);
	}
	public void equiper(Objet n)
	{
			ObjetPerso.replace(n.getEmplacement(), n);
	}
	public void afficher()
	{
		System.out.println("Voici vos objets :");
		for(ListIterator<Objet> it=mesObjets.listIterator(); it.hasNext();)
		{
			Objet i = it.next();
			i.decrire();
		}
	}
	public void afficherObjetsEquipes()
	{
		System.out.println("Voici vos objets équipés :");
		int n = 1;
		for(String key: ObjetPerso.keySet())
		{
			  System.out.println(n+ " " + key + " : ");
			  ObjetPerso.get(key).decrire();
			  n++;
		}
	}
}