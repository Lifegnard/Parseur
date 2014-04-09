import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import parseurImpl.Parser;

public class TestParser {

	Parser parser;
	
	@Before
	public void setUp() throws Exception {
		parser = new Parser();
	}
	
	@Test
	public void testGetQuestion() {
		assertEquals("",parser.getQuestion().getIntituleQuestion());
		assertEquals(null,parser.getQuestion().getPropositionReponses());
	}
	
	@Test
	public void testGetQuizReaderImpl() {
		assertFalse(parser.getpReader().equals(null));
	}
	
	
	@Test
	public void testConstructeur() {
		assertEquals("",parser.getQuestion().getIntituleQuestion());
		assertEquals(null,parser.getQuestion().getPropositionReponses());
		assertFalse(parser.getpReader().equals(null));
	}
	
	@Test
	public void testParserValide() {
		boolean t = false;
		  try {
			Reader reader = new StringReader(" {La Suisse est membre de l'Union Européenne.|type=\"()\"}- Vrai.+ Faux.");
			parser.parse(reader);;
		  } catch (Exception ex) {
		    t=true;
		  }
		  assertFalse(t);
		  assertEquals("La Suisse est membre de l'Union Européenne.",parser.getQuestion().getIntituleQuestion());
		  assertEquals(" Vrai",parser.getQuestion().getPropositionReponses().get(0).getReponse());
		  assertEquals(" Faux",parser.getQuestion().getPropositionReponses().get(1).getReponse());
		  assertTrue(parser.getQuestion().getPropositionReponses().get(1).isCorrect());
		  assertFalse(parser.getQuestion().getPropositionReponses().get(0).isCorrect());
	}
	
	@Test
	public void testParserIntituleInvalide() {
		boolean t = false;
		  try {
			Reader reader = new StringReader(" {La Suisse est membre de l'Union Européenne.type=\"()\"}- Vrai.+ Faux.");
			parser.parse(reader);
			fail ("Parser invalide");
		  } catch (Exception ex) {
			  t=true;
		  }
		  assertTrue(t);
	}
	
	@Test
	public void testParserTypeInvalide() {
		boolean t = false;
		  try {
			Reader reader = new StringReader(" {La Suisse est membre de l'Union Européenne.|type=\"d\"}- Vrai.+ Faux.");
			parser.parse(reader);
			fail ("Parser invalide");
		  } catch (Exception ex) {
			  t=true;
		  }
		  assertTrue(t);
	}
	
	@Test
	public void testParserReponseInvalide() {
		boolean t = false;
		  try {
			Reader reader = new StringReader(" {La Suisse est membre de l'Union Européenne.|type=\"()\"}- Vrai");
			parser.parse(reader);
		  } catch (Exception ex) {
			  t=true;
		  }
		  assertEquals(0,parser.getQuestion().getPropositionReponses().size());
	}
	
 
}
