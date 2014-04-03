import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parseurImpl.Parser;
import parseurImpl.Question;
import parseurImpl.QuizReaderImpl;
import parseurImpl.Reponse;

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
 
}
