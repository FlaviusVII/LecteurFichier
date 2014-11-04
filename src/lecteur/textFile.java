package lecteur;

public class textFile extends MyFile{

	public textFile(String path){
		super(path);
	}
	public void showContentFile(){
		String content = super.content.substring(4);
		System.out.println(content);
	}
	
}
