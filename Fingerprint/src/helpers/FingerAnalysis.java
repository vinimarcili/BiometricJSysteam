package helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

import dao.DAOUser;
import model.User;

public class FingerAnalysis {
	private final int MINIMO_SCORE = 40;
	public User getFingerOwner(String fingerPath) throws IOException {
//		try {
		File probeFile = new File(fingerPath);
		
		ArrayList<User> listUsers = new DAOUser().getAllUsers();
		System.out.println("Will analys for " + listUsers.size() + " usuarios");
		
		System.out.println("Path of image " + fingerPath);
		for (User user : listUsers) {
			System.out.println(user.getName());
			for(File candidateFile : user.getFingerprints()) {

				
				byte[] probeImage;
				System.out.println("Testing the file " + candidateFile.getAbsolutePath());
				probeImage = Files.readAllBytes(Paths.get(probeFile.getAbsolutePath()));

				byte[] candidateImage = Files.readAllBytes(Paths.get(candidateFile.getAbsolutePath()));
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
		


//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	}	
}
