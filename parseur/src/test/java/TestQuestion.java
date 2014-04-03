import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import parseurImpl.Question;
import parseurImpl.Reponse;

public class TestQuestion {

	private List<Reponse> listReponse;
	private List<Reponse> nouvelleListeReponse;
	private Question questionTest;

	public void setup() {
		this.listReponse = new ArrayList<Reponse>();
		this.nouvelleListeReponse = new ArrayList<Reponse>();
	}

	@Test
	public void testGetIntitule() {
		this.questionTest = new Question("Intitule de la question de test", this.listReponse);
		
		assertEquals("Intitule de la question de test", this.questionTest.getIntituleQuestion());
	}

	@Test
	public void testSetIntitule() {
		this.questionTest = new Question("Intitule de la question de test", this.listReponse);
		this.questionTest.setIntituleQuestion("Nouvel intitule");
		
		assertEquals("Nouvel intitule", this.questionTest.getIntituleQuestion());
	}

	@Test
	public void testgetPropositionReponses() {
		this.listReponse.add(new Reponse("reponse 1 test", true));
		this.questionTest = new Question("Intitule de la question de test", this.listReponse);
		
		assertEquals(this.listReponse, this.questionTest.getPropositionReponses());
	}

	@Test
	public void testsetPropositionReponses() {
		this.listReponse.add(new Reponse("reponse 1 test", true));
		this.nouvelleListeReponse.add(new Reponse("reponse 2 test", false));
		this.questionTest = new Question("Intitule de la question de test", this.listReponse);
		this.questionTest.setPropositionReponses(this.nouvelleListeReponse);
		
		assertEquals(this.nouvelleListeReponse, this.questionTest.getPropositionReponses());
	}

	@Test
	public void testConstructeurAvecParametre() {
		this.listReponse.add(new Reponse("reponse 1 test", true));
		this.questionTest = new Question("Intitule de la question de test", this.listReponse);

		assertEquals(this.listReponse, this.questionTest.getPropositionReponses());
		assertEquals("Intitule de la question de test", this.questionTest.getIntituleQuestion());
	}

	@Test
	public void testConstructeurSansParametre() {
		this.questionTest = new Question();
		
		assertEquals("", this.questionTest.getIntituleQuestion());
		assertEquals(null, this.questionTest.getPropositionReponses());
	}

}
