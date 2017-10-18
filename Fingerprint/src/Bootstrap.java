import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class Bootstrap {
	public static void main(String[] args) {
		

		try {
			File probeFile = new File("src/VeriFinger_Sample_DB/012_3_3.jpeg");
			File candidateFile = new File("src/VeriFinger_Sample_DB/022_6_8.jpeg");
			
			byte[] probeImage;
			probeImage = Files.readAllBytes(Paths.get(probeFile.getAbsolutePath()));

			byte[] candidateImage = Files.readAllBytes(Paths.get(candidateFile.getAbsolutePath()));
			FingerprintTemplate probe = new FingerprintTemplate(probeImage);
			FingerprintTemplate candidate = new FingerprintTemplate(candidateImage);

			FingerprintMatcher matcher = new FingerprintMatcher(probe);
			double score = matcher.match(candidate);
			
			System.out.println("My score is: " +  score);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
