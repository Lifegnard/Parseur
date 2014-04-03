package parseurImpl;

import java.io.IOException;
import java.io.Reader;

public class QuizReaderImpl implements QuizReader {

	public String lireIntitule(Reader flux) throws Exception {
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
		throw new Exception(
				"Probleme de syntaxe dans la construction de la question.");
	}

	public String lireTypeQuestion(Reader flux) throws Exception {
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
		throw new Exception(
				"Probleme de syntaxe dans la construction de la question.");
	}

	public Reponse lireReponse(Reader flux) throws Exception {
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

}
