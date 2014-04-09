package parseurImpl;

import java.io.Reader;

public interface QuizReader {
	public String lireIntitule(Reader flux) throws Exception;

	public Type lireTypeQuestion(Reader flux) throws Exception;

	public Reponse lireReponse(Reader flux) throws Exception;
}
