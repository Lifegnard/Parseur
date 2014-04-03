import static org.junit.Assert.*;

import org.junit.Test;

import parseurImpl.Reponse;


public class TestReponse {

	@Test
	public void testGetReponse() {
		Reponse r=new Reponse("Test Réponse",true);
		assertEquals("Test Réponse",r.getReponse());
	}
	
	
	@Test
	
	public void testSetReponse(){
		Reponse r=new Reponse("Test Réponse",true);
		r.setReponse("set reponse");
		assertEquals("set reponse",r.getReponse());
	}
	
	@Test
	public void testIsCorrect(){
		Reponse rtrue=new Reponse("Test reponse",true);
		Reponse rfalse=new Reponse("Test 2 reponse",false);
		assertEquals(true,rtrue.isCorrect());
		assertEquals(false,rfalse.isCorrect());
	}
	
	@Test
	public void testSetCorrect(){
		Reponse r=new Reponse("Test",true);
		r.setCorrect(false);
		assertEquals(false,r.isCorrect());
		r.setCorrect(true);
		assertEquals(true,r.isCorrect());
		
	}
	@Test
	public void testConstructeurAvecParametre(){
		Reponse r=new Reponse("Test",true);
		assertEquals(r.getReponse(),"Test");
		assertEquals(r.isCorrect(),true);
	}
	
	@Test
	public void testConstructeurSansParametre(){
		Reponse r=new Reponse();
		assertEquals("",r.getReponse());
		assertEquals(false,r.isCorrect());
	}
	
	
}
