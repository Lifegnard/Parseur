import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parseurImpl.Question;
import parseurImpl.Reponse;


public class TestQuestion {

	ArrayList<Reponse> listeReponse;
	Question questionTest;
	ArrayList<Reponse> nouvelleListeReponse;
	Question questionTest2;
	
	@Before
	public void setUp() throws Exception {
		listeReponse=new ArrayList<Reponse>();
		questionTest=new Question("Intitule de la question de test",listeReponse);	
		nouvelleListeReponse=new ArrayList<Reponse>();
		questionTest2=new Question();
	}
	
	@After
	public void tearDown() throws Exception {
		listeReponse = null;
		questionTest = null;
		nouvelleListeReponse = null;
		questionTest2 = null;
	}
	
	@Test
	public void testGetIntitule() {
		assertEquals("Intitule de la question de test",questionTest.getIntituleQuestion());
	}
	
	@Test
	public void testSetIntitule() {
		questionTest.setIntituleQuestion("Nouvel intitule");
		assertEquals("Nouvel intitule",questionTest.getIntituleQuestion());
	}
	
	@Test
	public void testgetPropositionReponses() {
		listeReponse.add(new Reponse("reponse 1 test",true));
		assertEquals(listeReponse,questionTest.getPropositionReponses());
	}
	
	@Test
	public void testsetPropositionReponses() {
		listeReponse.add(new Reponse("reponse 1 test",true));
		nouvelleListeReponse.add(new Reponse("reponse 2 test",false));
		questionTest.setPropositionReponses(nouvelleListeReponse);
		assertEquals(nouvelleListeReponse,questionTest.getPropositionReponses());
	}
	
	@Test
	public void testConstructeurAvecParametre() {
		listeReponse.add(new Reponse("reponse 1 test",true));
		assertEquals(listeReponse,questionTest.getPropositionReponses());
		assertEquals("Intitule de la question de test",questionTest.getIntituleQuestion());
	}
	
	@Test
	public void testConstructeurSansParametre() {
		assertEquals("",questionTest2.getIntituleQuestion());
		assertEquals(null,questionTest2.getPropositionReponses());
	}

}
