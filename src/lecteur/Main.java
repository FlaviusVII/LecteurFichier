package lecteur;

public class Main {

	public static void main(String[] args) {
		String path = "doc/lorem.txt";

		TextFilePalindrome palindromeFile = new TextFilePalindrome(path);
		TextFileReverse reverseFile = new TextFileReverse(path);
		textFile file = new textFile(path);

		if (palindromeFile.openAndCheck()) {
			palindromeFile.readContentFile();
		}
		if (reverseFile.openAndCheck()) {
			reverseFile.readContentFile();
		}
		if (file.openAndCheck()) {
			file.readContentFile();
		}

		palindromeFile.showContentFile();
	}
}
