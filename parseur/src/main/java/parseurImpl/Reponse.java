package parseurImpl;

public class Reponse {
	private String reponse;
	private boolean isCorrect;

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Reponse(String reponse, boolean isCorrect) {
		this.reponse = reponse;
		this.isCorrect = isCorrect;
	}

	public Reponse() {
		this.reponse = "";
		this.isCorrect = false;
	}

	public String toString() {
		return this.reponse + " - correcte : " + this.isCorrect;
	}

}
