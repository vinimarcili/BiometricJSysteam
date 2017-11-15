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
import model.Roles;
import model.User;

import views.DashboradView;
import views.LoginBiometric;



public class Bootstrap {
	public static void main(String[] args) {
//		User user = new User("teste",Roles.ADMIN,"...");
		
//		DashboradView dash = new DashboradView(user);
//		dash.view();
		new LoginBiometric().view();
		
		
	}
}
