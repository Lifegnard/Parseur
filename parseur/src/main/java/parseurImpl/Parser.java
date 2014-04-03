package parseurImpl;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	private Question question;
	private QuizReaderImpl pReader;
	
	public Question getQuestion() {
		return question;
	}

	public QuizReaderImpl getpReader() {
		return pReader;
	}

	public Parser() {
		this.pReader = new QuizReaderImpl();
		this.question = new Question();
	}

	public void parse(Reader reader) throws Exception { 
		List<Reponse> propositionsDeReponse = new ArrayList<Reponse>();
		Reponse reponseCourante = null;
		
		try {
			this.question.setIntituleQuestion(this.pReader.lireIntitule(reader));
			this.pReader.lireTypeQuestion(reader);
			while ((reponseCourante = this.pReader.lireReponse(reader)) != null) {
				propositionsDeReponse.add(reponseCourante);
			}
			this.question.setPropositionReponses(propositionsDeReponse);
		} catch (Exception e) {
			e.toString();
		}
	}
}
