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
