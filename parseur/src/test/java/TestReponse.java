import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parseurImpl.Reponse;

public class TestReponse {
	private Reponse r;

	@Before
	public void setUp() throws Exception {
		this.r = new Reponse("Test", true);
	}

	@Test
	public void testGetReponse() {
		assertEquals("Test", this.r.getReponse());
	}

	@Test
	public void testSetReponse() {
		this.r.setReponse("set reponse");
		assertEquals("set reponse", this.r.getReponse());
	}

	@Test
	public void testIsCorrect() {
		Reponse rtrue = new Reponse("Test reponse correct", true);
		Reponse rfalse = new Reponse("Test reponse non correct", false);
		assertEquals(true, rtrue.isCorrect());
		assertEquals(false, rfalse.isCorrect());
	}

	@Test
	public void testSetCorrect() {
		this.r.setCorrect(false);
		assertEquals(false, this.r.isCorrect());

		this.r.setCorrect(true);
		assertEquals(true, this.r.isCorrect());
	}

	@Test
	public void testConstructeurAvecParametre() {
		assertEquals(this.r.getReponse(), "Test");
		assertEquals(this.r.isCorrect(), true);
	}

	@Test
	public void testConstructeurSansParametre() {
		this.r = new Reponse();
		assertEquals("", this.r.getReponse());
		assertEquals(false, this.r.isCorrect());
	}

}
