package views;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.DAOUser;
import model.User;

public class BiometricView {
	public void view() {
		try {
			final int FRAME_WIDTH = 800;
			final int FRAME_HEIGHT = 800;
			final int LB_TITLE_WIDTH = 200;
			
			ArrayList<User> listUsers = new DAOUser().getAllUsers();
			User tom = listUsers.get(0);
			User jerry = listUsers.get(1);
			
			JFrame frame = new JFrame("Biometric View");
			frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			frame.setLayout(null);
			
			//Title da frame
			JLabel lbTitle = new JLabel("Seleciona um perfil");
			lbTitle.setSize(LB_TITLE_WIDTH, 40);
			lbTitle.setLocation((FRAME_WIDTH / 6) + LB_TITLE_WIDTH, 10);
			frame.add(lbTitle);
			
			//Criando profile do Usuario TOM
			BufferedImage img = null;
			img = ImageIO.read(new File(tom.getProfile()));
			JLabel lbTom = new JLabel();
			lbTom.setSize(200, 200);
			Image dimg = img.getScaledInstance(lbTom.getWidth(), lbTom.getHeight(),
			        Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			lbTom.setIcon(imageIcon);
			lbTom.setLocation( 100, lbTitle.getY() + 30);
			lbTom.addMouseListener(new MouseAdapter()  
			{  
			    public void mouseClicked(MouseEvent e)  
			    {  
			       selectTom();
			    }  
			}); 
			frame.add(lbTom);
			
			JLabel lbTitleTom = new JLabel("Tom");
			lbTitleTom.setSize(LB_TITLE_WIDTH, 40);
			lbTitleTom.setLocation( lbTom.getX(), lbTom.getY() + lbTom.getHeight());
			frame.add(lbTitleTom);
			
			
			
			//Criando profile do Usuario Jerry
			img = ImageIO.read(new File(jerry.getProfile()));
			JLabel lbJerry = new JLabel();
			lbJerry.setSize(200, 200);
			dimg = img.getScaledInstance(lbJerry.getWidth(), lbJerry.getHeight(),
			        Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(dimg);
			lbJerry.setIcon(imageIcon);
			lbJerry.setLocation( 400, lbTitle.getY() + 30);
			lbJerry.addMouseListener(new MouseAdapter()  
			{  
			    public void mouseClicked(MouseEvent e)  
			    {  
			       selectJerry();
			    }  
			}); 
			frame.add(lbJerry);
	
			JLabel lbTitleJerry = new JLabel("Jerry");
			lbTitleJerry.setSize(LB_TITLE_WIDTH, 40);
			lbTitleJerry.setLocation( lbJerry.getX(), lbJerry.getY() + lbJerry.getHeight());
			frame.add(lbTitleJerry);
			
			
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public void selectTom(){
		JOptionPane.showMessageDialog(null, "Você selecionou o tom");
	}
	
	public void selectJerry(){
		JOptionPane.showMessageDialog(null, "Você selecionou o Jerry");
	}
}
