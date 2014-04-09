package parseurImpl;

import java.io.Reader;

public class QuizReaderImpl implements QuizReader {

	public String lireIntitule(Reader flux) throws Exception {
		char characterCourant;
		boolean debutIntitule = false;
		boolean finIntitule = false;
		String intitule = "";
		characterCourant = (char) flux.read();
		while (characterCourant!= 65535 && characterCourant!= -1) {
			if (characterCourant == '{' && !debutIntitule) {
				debutIntitule = true;
			} else if (characterCourant == '|' && !finIntitule && debutIntitule) {
				finIntitule = true;
				return intitule;
			} else if (debutIntitule && !finIntitule) {
				intitule += characterCourant;
			}
			characterCourant = (char) flux.read();
		}
		throw new Exception(
				"Probleme de syntaxe dans la construction de la question.");
	}

	public String lireTypeQuestion(Reader flux) throws Exception {
		char characterCourant;
		boolean debutTypeQuestion = false;
		boolean finTypeQuestion = false;
		String type = "";
		characterCourant = (char) flux.read();
		
		while (characterCourant != 65535 && characterCourant != -1) {
			if (characterCourant == '"' && !debutTypeQuestion) {
				debutTypeQuestion = true;
			} else if (characterCourant == '"' && !finTypeQuestion && debutTypeQuestion) {
				finTypeQuestion = true;
				return type;
			} else if (debutTypeQuestion && !finTypeQuestion) {
				type += characterCourant;
			}
			characterCourant = (char) flux.read();
		}
		throw new Exception(
				"Probleme de syntaxe dans la construction de la question.");
	}

	public Reponse lireReponse(Reader flux) throws Exception {
		char characterCourant;
		boolean debutReponse = false;
		boolean finReponse = false;
		String intituleReponse = "";
		Reponse reponse = new Reponse();
		characterCourant = (char) flux.read();
		while (characterCourant != 65535 && characterCourant != -1) {
			if (characterCourant == '-' && !debutReponse) {
				debutReponse = true;
				reponse.setCorrect(false);
			} else if (characterCourant == '+' && !debutReponse) {
				debutReponse = true;
				reponse.setCorrect(true);
			} else if (characterCourant == '.' && !finReponse && debutReponse) {
				finReponse = true;
				reponse.setReponse(intituleReponse);
				return reponse;
			} else if (debutReponse && !finReponse && characterCourant != '\n') {
				intituleReponse += characterCourant;
			}
			characterCourant = (char) flux.read();
		}
		return null;
	}

}
