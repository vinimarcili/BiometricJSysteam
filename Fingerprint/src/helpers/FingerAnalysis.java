package helpers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

import dao.DAOUser;
import model.User;

public class FingerAnalysis {
	private final int MINIMO_SCORE = 40;
	public User getFingerOwner(String fingerPath) throws IOException {

		File probeFile = new File(fingerPath);
		
		ArrayList<User> listUsers = new DAOUser().getAllUsers();
		System.out.println("Will analys for " + listUsers.size() + " usuarios");
		
		System.out.println("Path of image " + fingerPath);
		for (User user : listUsers) {
			System.out.println(user.getName());
			for(String candidateFile : user.getPaths()) {

				
				byte[] probeImage;
				System.out.println("Testing the file " + candidateFile);
				probeImage = Files.readAllBytes(Paths.get(probeFile.getAbsolutePath()));

				byte[] candidateImage = this.convert(candidateFile);
				FingerprintTemplate probe = new FingerprintTemplate(probeImage);
				FingerprintTemplate candidate = new FingerprintTemplate(candidateImage);

				FingerprintMatcher matcher = new FingerprintMatcher(probe);
				double score = matcher.match(candidate);
				
				System.out.println("My score is: " +  score + " for user " + user.getName());
				if(score >= MINIMO_SCORE) {
					return user;
				}

			}						
		}
		return null;
		
	}	
	
	private byte[] convert(String path) throws IOException {
		System.out.println(path);
		InputStream is = FingerAnalysis.class.getResourceAsStream("../"+path);
		return IOUtils.toByteArray(is);
	}
}
