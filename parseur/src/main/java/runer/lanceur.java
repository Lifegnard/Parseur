package runer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import parseurImpl.Parser;
import parseurImpl.Question;

public class lanceur {

	public static void main(String[] args) {
		Parser p = new Parser();
		Question q = null;

		File fTest = new File("test.txt");
		Reader r;
		try {
			r = new FileReader(fTest);
			p.parse(r);
			q = p.getQuestion();
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found !");
			e1.printStackTrace();
		} catch (Exception e1) {
			System.out.println("Erreur de parsing !");
			e1.printStackTrace();
		}

		System.out.println(q);
	}

}