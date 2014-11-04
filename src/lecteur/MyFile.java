package lecteur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class MyFile implements fileInterface {

	protected File file;
	protected String content;
	
	public MyFile(String path) {
		this.file = new File(path);
	}

	public boolean openAndCheck() {

		return (this.file.isFile() && this.file.exists() && this.file.canRead());
	}

	public void readContentFile() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(this.file);
			
			byte[] buf = new byte[1];
			@SuppressWarnings("unused")
			int n = 0;
			while ((n = fis.read(buf)) >= 0) {
	            for (byte bit : buf) {
	            char character = (char) bit;	
	               this.content += (String.valueOf(character));
	            }
	            buf = new byte[1];
	         }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void showContentFile() {
	}

	public String getAbsolutePath() {
		return this.file.getAbsolutePath();
	}
	public String getCanonicalPath() {
		return this.file.getPath();
	}
	public String getContentFile(){
		return this.content;
	}
}
