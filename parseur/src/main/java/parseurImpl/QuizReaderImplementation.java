package parseurImpl;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.tsaap.questions.QuizContentHandler;
import org.tsaap.questions.QuizReader;
import org.tsaap.questions.QuizReaderException;

public class QuizReaderImplementation implements QuizReader {
	private QuizContentHandler contentHandler;

	public void parse(Reader reader) throws IOException, QuizReaderException {
		Question nouvelleQuestion = new Question();
		List<Reponse> propositionsDeReponses = new ArrayList<Reponse>();
		Reponse reponseTmp = null;
		try {
			nouvelleQuestion.setIntituleQuestion(lireIntitule(reader));
			lireTypeQuestion(reader);
			while ((reponseTmp = lireReponse(reader)) != null) {
				propositionsDeReponses.add(reponseTmp);
			}
			nouvelleQuestion.setPropositionReponses(propositionsDeReponses);
		} catch (Exception e) {
			e.toString();
		}

	}

	private String lireIntitule(Reader flux) throws IOException,
	QuizReaderException {
		int characterCourant;
		boolean debutIntitule = false;
		boolean finIntitule = false;
		String intitule = "";

		while ((characterCourant = flux.read()) != -1) {
			if (characterCourant == '{' && !debutIntitule) {
				debutIntitule = true;
			} else if (characterCourant == '|' && !finIntitule) {
				finIntitule = true;
				return intitule;
			} else if (debutIntitule && !finIntitule) {
				intitule += characterCourant;
			}
		}
		throw new QuizReaderException(
				"Probleme de syntaxe dans la construction de la question.");
	}

	private String lireTypeQuestion(Reader flux) throws IOException,
	QuizReaderException {
		int characterCourant;
		boolean debutTypeQuestion = false;
		boolean finTypeQuestion = false;
		String type = "";

		while ((characterCourant = flux.read()) != -1) {
			if (characterCourant == '"' && !debutTypeQuestion) {
				debutTypeQuestion = true;
			} else if (characterCourant == '"' && !finTypeQuestion) {
				finTypeQuestion = true;
				return type;
			} else if (debutTypeQuestion && !finTypeQuestion) {
				type += characterCourant;
			}
		}
		throw new QuizReaderException(
				"Probleme de syntaxe dans la construction de la question.");
	}

	private Reponse lireReponse(Reader flux) throws IOException {
		int characterCourant;
		boolean debutReponse = false;
		boolean finReponse = false;
		String intituleReponse = "";
		Reponse reponse = new Reponse();

		while ((characterCourant = flux.read()) != -1) {
			if (characterCourant == '-' && !debutReponse) {
				debutReponse = true;
				reponse.setCorrect(false);
			} else if (characterCourant == '+' && !debutReponse) {
				debutReponse = true;
				reponse.setCorrect(true);
			} else if (characterCourant == '\n' && !finReponse) {
				finReponse = true;
				reponse.setReponse(intituleReponse);
				return reponse;
			} else if (debutReponse && !finReponse) {
				intituleReponse += characterCourant;
			}
		}
		return null;
	}

	public QuizContentHandler getQuizContentHandler() {
		return contentHandler;
	}
}
