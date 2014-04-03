package parseurImpl;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	QuizReaderImpl r = new QuizReaderImpl();

	public void parse(Reader reader) throws Exception {
		Question nouvelleQuestion = new Question();
		List<Reponse> propositionsDeReponses = new ArrayList<Reponse>();
		Reponse reponseTmp = null;
		try {
			nouvelleQuestion.setIntituleQuestion(r.lireIntitule(reader));
			r.lireTypeQuestion(reader);
			while ((reponseTmp = r.lireReponse(reader)) != null) {
				propositionsDeReponses.add(reponseTmp);
			}
			nouvelleQuestion.setPropositionReponses(propositionsDeReponses);
		} catch (Exception e) {
			e.toString();
		}

	}
}
