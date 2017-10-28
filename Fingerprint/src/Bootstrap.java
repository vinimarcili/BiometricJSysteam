import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

import dao.DAOUser;
import model.User;
import views.BiometricView;
import views.LoginBiometric;

public class Bootstrap {
	public static void main(String[] args) {
		
		new LoginBiometric().view();
		//Carrega
		
		
//		try {
//			File probeFile = new File("src/VeriFinger_Sample_DB/012_3_3.jpeg");
//			File candidateFile = new File("src/VeriFinger_Sample_DB/022_6_8.jpeg");
//			
//			byte[] probeImage;
//			probeImage = Files.readAllBytes(Paths.get(probeFile.getAbsolutePath()));
//
//			byte[] candidateImage = Files.readAllBytes(Paths.get(candidateFile.getAbsolutePath()));
//			FingerprintTemplate probe = new FingerprintTemplate(probeImage);
//			FingerprintTemplate candidate = new FingerprintTemplate(candidateImage);
//
//			FingerprintMatcher matcher = new FingerprintMatcher(probe);
//			double score = matcher.match(candidate);
//			
//			System.out.println("My score is: " +  score);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
