package lecteur;

public class TextFileReverse extends MyFile {

	public TextFileReverse(String path) {
		super(path);
	}

	public void showContentFile() {
		String content = super.content.substring(4);
		String[] splitContent = content.split("\n");
		System.out.println(splitContent[2]);
		for (int i = splitContent.length -1 ; i > -1; i--)
			System.out.println(splitContent[i]);
	}
}
