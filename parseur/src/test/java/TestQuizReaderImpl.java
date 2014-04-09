import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import parseurImpl.Parser;
import parseurImpl.QuizReaderImpl;
import parseurImpl.Reponse;

public class TestQuizReaderImpl {

	private QuizReaderImpl pReader;
	
	@Before
	public void setUp() throws Exception {
		pReader = new QuizReaderImpl();
	}
	
	// Test lorsqu'on rédige un intitulé non conforme aux règles
	// Déclenche en conséquence une exception
	@Test
	public void testExceptionIntituleReaderNonConforme() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("d");
		  try {
			  pReader.lireIntitule(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	// Test lorsqu'on rédige un intitulé sans l'accolade d'ouverte
	// Doit déclencher l'exception
	@Test
	public void testExceptionIntituleReaderNonConformeAbsenceAccolade() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("d|");
		  try {
			  pReader.lireIntitule(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	// Test lorsqu'on rédige un intitulé sans le Pipe fermant
	// Doit déclencher l'exception
	@Test
	public void testExceptionIntituleReaderNonConformeAbsencePipe() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("{d");
		  try {
			  pReader.lireIntitule(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	// Test lorsqu'on rédige un intitulé vide
	// Doit déclencher l'exception
	@Test
	public void testExceptionIntituleReaderVide() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("");
		  try {
			  pReader.lireIntitule(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	// Test lorsqu'on rédige un intitulé correcte
	// Doit renvoyer une chaine de caractère correspondant à l'intitulé
	@Test
	public void testExceptionIntituleReaderValide() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("{Intitule|");
		String result = "";
		  try {
			  result = pReader.lireIntitule(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals("Intitule",result);
	}
	

	// Test lorsqu'on rédige un type de question non conforme
	// Doit déclencher l'exception
	@Test
	public void testExceptionTypeQuestionReaderNonConforme() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("d");
		  try {
			  pReader.lireTypeQuestion(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	// Test lorsqu'on rédige un type de question sans guillemets ouvrante
	// Doit déclencher l'exception
	@Test
	public void testExceptionTypeQuestionReaderNonConformeAbsenceFirstGuillemet() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("d\"");
		  try {
			  pReader.lireTypeQuestion(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	// Test lorsqu'on rédige un type de question sans guillemets fermantes
	// Doit déclencher l'exception
	@Test
	public void testExceptionTypeQuestionReaderNonConformeAbsenceSecondGuillemet() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("\"d");
		  try {
			  pReader.lireTypeQuestion(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	// Test lorsqu'on rédige un type de question vide
	// Doit déclencher l'exception
	@Test
	public void testExceptionTypeQuestionReaderVide() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("");
		  try {
			  pReader.lireTypeQuestion(reader);
			  fail("Une exception aurait du être levé");
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertTrue(error);
	}
	
	
	// Test lorsqu'on rédige un type de question valide
	// Doit renvoyer la chaine de caractère correspondant aux type de question
	@Test
	public void testExceptionTypeQuestionReaderValide() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("\"()\"");
		String result = "";
		  try {
			  result = pReader.lireTypeQuestion(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals("()",result);
	}
	
	// Test lorsqu'on rédige une reponse fausse
	// Doit renvoyer une Reponse non correct 
	@Test
	public void testReponseFausseReaderValide() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("-faux.");
		Reponse rep = new Reponse();
		  try {
			  rep = pReader.lireReponse(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals("faux",rep.getReponse());
		  assertFalse(rep.isCorrect());
	}
	
	// Test lorsqu'on rédige une reponse valide
	// Doit renvoyer une Reponse  correct 
	@Test
	public void testReponseVraiReaderValide() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("+vrai.");
		Reponse rep = new Reponse();
		  try {
			  rep = pReader.lireReponse(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals("vrai",rep.getReponse());
		  assertTrue(rep.isCorrect());
	}
	
	// Test lorsqu'on rédige une reponse mal rédigé, avec une absence de point
	// Doit renvoyer null
	@Test
	public void testReponseReaderAbsencePoint() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("+vrai");
		Reponse rep = new Reponse();
		  try {
			  rep = pReader.lireReponse(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals(null,rep);
	}
	
	// Test lorsqu'on rédige une reponse mal rédigé, avec une absence de signe
	// Doit renvoyer null
	@Test
	public void testReponseReaderAbsenceSigne() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("vrai.");
		Reponse rep = new Reponse();
		  try {
			  rep = pReader.lireReponse(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals(null,rep);
	}
	
	// Test lorsqu'on rédige une reponse avec une chaine vide
	// Doit renvoyer null
	@Test
	public void testReponseReaderChaineVide() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("");
		Reponse rep = new Reponse();
		  try {
			  rep = pReader.lireReponse(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals(null,rep);
	}
	
	// Test lorsqu'on rédige une reponse avec un saut de ligne
	// Doit renvoyer une réponse correcte
	@Test
	public void testReponseReaderSautDeLigne() throws Exception{
		boolean error = false;
		Reader reader = new StringReader("+vrai\nsaut.");
		Reponse rep = new Reponse();
		  try {
			  rep = pReader.lireReponse(reader);
		  } catch (Exception ex) {	
			  error = true;
		  }
		  assertFalse(error);
		  assertEquals("vraisaut",rep.getReponse());
		  assertTrue(rep.isCorrect());
	}

}
