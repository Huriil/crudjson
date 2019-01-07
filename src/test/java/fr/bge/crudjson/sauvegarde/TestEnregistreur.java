package fr.bge.crudjson.sauvegarde;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import fr.bge.crudjson.entites.Chaussure;
import fr.bge.crudjson.entites.Fabricant;
import fr.bge.crudjson.entites.Vetement;

public class TestEnregistreur {
	
	@Test
	public void testFonctionnementClassique() throws Exception {
		
		Enregistreur enregistreur = new Enregistreur();
		
		
		
		// On charge la liste actuelle des v�tements
		List <Vetement> dressing1 = enregistreur.lireTous();
		
		
		// On instancie un nouveau v�tement
		
		Chaussure chaussure = new Chaussure();
		chaussure.setTaille("37");		
		chaussure.setCouleur("Rouge");
		chaussure.setLongueurLacet("25");
		
		
		Fabricant fabricant = new Fabricant();
		fabricant.setNom("Prada");
		chaussure.setFabricant(fabricant);
		
		// On sauvegarde ce v�tement
		
		enregistreur.enregistrer(chaussure);
		
		// On v�rifie que la liste a pris en compte ce vetement
		List< Vetement > dressing2 = enregistreur.lireTous();
		Assert.assertEquals("Le nouveau dressing a un �l�ment de plus", dressing1.size() +1, dressing2.size());
		
		// On modifie ce v�tement et on le sauvegarde
			chaussure.setTaille("34");
			enregistreur.enregistrer(chaussure);
		// On v�rifie que la liste a pris en compte cette sauvegarde
		
		// On supprime le v�tement 
			enregistreur.supprimer(chaussure);
			List < Vetement > dressing3 = enregistreur.lireTous(); 
			Assert.assertEquals("Les deux dressings doivent avoir le m�me nombre d'items", dressing1.size(),  dressing3.size());
		
		// On v�rifie que la liste a pris en compte cette suppression
		
		
	}
}
