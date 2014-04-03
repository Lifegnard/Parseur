package parseurImpl;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	private QuizReaderImpl r;

	public Parser() {
		this.r = new QuizReaderImpl();
	}

	public void parse(Reader reader) throws Exception {
		Question nouvelleQuestion = new Question();
		List<Reponse> propositionsDeReponses = new ArrayList<Reponse>();
		Reponse reponseTmp = null;
		try {
			nouvelleQuestion.setIntituleQuestion(this.r.lireIntitule(reader));
			this.r.lireTypeQuestion(reader);
			while ((reponseTmp = this.r.lireReponse(reader)) != null) {
				propositionsDeReponses.add(reponseTmp);
			}
			nouvelleQuestion.setPropositionReponses(propositionsDeReponses);
		} catch (Exception e) {
			e.toString();
		}
	}
}
