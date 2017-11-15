import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class Teste {
	public static void main(String[] args) {
		String path = "/images/tom_fingerprints/1.jpg";
		InputStream is = Teste.class.getResourceAsStream(path);
		try {
			byte[] bytes =IOUtils.toByteArray(is);
			System.out.println(bytes.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
