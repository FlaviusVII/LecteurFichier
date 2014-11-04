package lecteur;

public class TextFilePalindrome extends MyFile {

	StringBuffer content;

	public TextFilePalindrome(String path) {
		super(path);
	}

	public void showContentFile() {
		String previousContent = super.content.substring(4);

		previousContent = previousContent.replaceAll(" ", "");
		previousContent = previousContent.replaceAll("\n", "");
		previousContent = previousContent.replaceAll("\r", "");
		previousContent = previousContent.replaceAll(",", "");
		previousContent = previousContent.replaceAll("\\.", "");
		//System.out.println(previousContent);
		this.content = new StringBuffer(previousContent);
this.makePalindrome(true);
		System.out.println(this.content);

	}

	private void makePalindrome(boolean sens) {

		int delta;
		int indexOfLastTag;
		int nbLigneSouhaite = 10;
		int iteration = 1;
		int reste ;
		int moitie;
		// besoin d'un nombre de segment pair pour bien obtenir les 5/8
		// ou les 2/3
		int segment;
		// la moitié de la chaine total 
		moitie = this.content.length() / 2;
		//je veux 6 segment de part Žgales
		segment = moitie / (nbLigneSouhaite + 1);
		// delta = 2/3 des segments
		delta = segment * ((nbLigneSouhaite / 2) + 1);
		reste = moitie - delta;
		indexOfLastTag = delta;
		if (sens) {
			for (int i = 1; i < this.content.length() / 2; i++) {

				if (i ==  indexOfLastTag && iteration <= (nbLigneSouhaite / 2)) {
					iteration++;
					// Je segmente le reste de la moitie de la chaine en 6 parts Žgales
					segment = reste / nbLigneSouhaite + 1;
					delta = segment * ((nbLigneSouhaite / 2) + iteration);
					indexOfLastTag = indexOfLastTag + delta;
					this.content.insert(i, "\n");
				}
			}
			this.makePalindrome(false);

		} else {
			iteration = 0;
			moitie = this.content.length() / 2;
			 
			//je veux 6 segment de part égales
			segment = moitie / (nbLigneSouhaite + 1);
			// delta = 2/3 des segments
			delta = segment * ((nbLigneSouhaite / 2) + 1);
			reste = moitie - delta;
			indexOfLastTag = this.content.length() - delta;
			
			for (int i = this.content.length(); i > this.content.length() / 2; i--) {

				if (i ==  indexOfLastTag && iteration <= (nbLigneSouhaite / 2)) {
					iteration++;
					// Je segmente le reste de la moitie de la chaine en 6 parts Žgales
					segment = reste / nbLigneSouhaite + 1;
					delta = segment * ((nbLigneSouhaite / 2) + iteration);
					indexOfLastTag = indexOfLastTag - delta;
					this.content.insert(i, "\n");
				}
			}

		}

	}
}
