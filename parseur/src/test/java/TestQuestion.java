import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import parseurImpl.Question;
import parseurImpl.Reponse;


public class TestQuestion {

	@Test
	public void testGetIntitule() {
		ArrayList<Reponse> listeReponse=new ArrayList<Reponse>();
		Question questionTest=new Question("Intitule de la question de test",listeReponse);
		assertEquals("Intitule de la question de test",questionTest.getIntituleQuestion());
	}
	
	@Test
	public void testSetIntitule() {
		ArrayList<Reponse> listeReponse=new ArrayList<Reponse>();
		Question questionTest=new Question("Intitule de la question de test",listeReponse);
		questionTest.setIntituleQuestion("Nouvel intitule");
		assertEquals("Nouvel intitule",questionTest.getIntituleQuestion());
	}
	
	@Test
	public void testgetPropositionReponses() {
		ArrayList<Reponse> listeReponse=new ArrayList<Reponse>();
		listeReponse.add(new Reponse("reponse 1 test",true));
		Question questionTest=new Question("Intitule de la question de test",listeReponse);
		assertEquals(listeReponse,questionTest.getPropositionReponses());
	}
	
	@Test
	public void testsetPropositionReponses() {
		ArrayList<Reponse> listeReponse=new ArrayList<Reponse>();
		listeReponse.add(new Reponse("reponse 1 test",true));
		ArrayList<Reponse> nouvelleListeReponse=new ArrayList<Reponse>();
		nouvelleListeReponse.add(new Reponse("reponse 2 test",false));
		
		Question questionTest=new Question("Intitule de la question de test",listeReponse);
		questionTest.setPropositionReponses(nouvelleListeReponse);
		assertEquals(nouvelleListeReponse,questionTest.getPropositionReponses());
	}
	
	@Test
	public void testConstructeurAvecParametre() {
		ArrayList<Reponse> listeReponse=new ArrayList<Reponse>();
		listeReponse.add(new Reponse("reponse 1 test",true));
		Question questionTest=new Question("Intitule de la question de test",listeReponse);
		
		assertEquals(listeReponse,questionTest.getPropositionReponses());
		assertEquals("Intitule de la question de test",questionTest.getIntituleQuestion());
	}
	
	@Test
	public void testConstructeurSansParametre() {
		Question questionTest=new Question();
		
		assertEquals("",questionTest.getIntituleQuestion());
		assertEquals(null,questionTest.getPropositionReponses());
	}

}
