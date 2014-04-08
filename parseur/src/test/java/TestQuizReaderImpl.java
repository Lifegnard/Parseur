import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import parseurImpl.Parser;
import parseurImpl.QuizReaderImpl;

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
	


}
