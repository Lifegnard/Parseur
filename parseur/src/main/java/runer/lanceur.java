package runer;

import java.io.Reader;
import java.io.StringReader;

import parseurImpl.Parser;
import parseurImpl.Question;

public class lanceur {

	public static void main(String[] args) {
		Parser p = new Parser();
		Question q = null;

		Reader r = new StringReader("truc");
		try {
			p.parse(r);
			q = p.getQuestion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(q);
	}

}
