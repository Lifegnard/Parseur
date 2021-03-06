package parseurImpl;

import java.util.List;

public class Question {
	private String intituleQuestion;
	private List<Reponse> propositionReponses;
	
	public Question(String intituleQuestion, List<Reponse> propositionReponses) {
		this.intituleQuestion = intituleQuestion;
		this.propositionReponses = propositionReponses;
	}

	public Question() {
		this.intituleQuestion = "";
		this.propositionReponses = null;
	} 

	public String getIntituleQuestion() {
		return intituleQuestion;
	}

	public void setIntituleQuestion(String intituleQuestion) {
		this.intituleQuestion = intituleQuestion;
	}

	public List<Reponse> getPropositionReponses() {
		return propositionReponses;
	}

	public void setPropositionReponses(List<Reponse> propositionReponses) {
		this.propositionReponses = propositionReponses;
	}

	public String toString() {
		return "Intitul� de la question : " + this.intituleQuestion
				+ "\nPropositions de reponses :\n" + propositionReponses;
	}

}
