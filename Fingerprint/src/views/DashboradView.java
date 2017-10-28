package views;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Roles;
import model.User;

public class DashboradView {
	private User user;
	public DashboradView(User user) {
		this.user = user;
	}
	
	public void view(){
		JFrame frame = new JFrame("Login");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel lbTitle = new JLabel("Bem vindo " + this.user.getName());
		lbTitle.setSize(150,150);
		lbTitle.setLocation(250,10);
		frame.add(lbTitle);
		
		//Componentes para admin
		if(user.getRole() == Roles.ADMIN) {
			JLabel lbAdmin = new JLabel("Parabens, você é admin, GRANDE BOSTA!");
			lbAdmin.setSize(400,150);
			lbAdmin.setLocation(180,lbTitle.getY() +  lbTitle.getHeight() + 20);
			frame.add(lbAdmin);
		}else if(user.getRole() == Roles.USER) {
			JLabel lbUser = new JLabel("Parabens, você não é admin, SEU BOSTA!");
			lbUser.setSize(400,150);
			lbUser.setLocation(180,lbTitle.getY() +  lbTitle.getHeight() + 20);
			frame.add(lbUser);
		}
		
		frame.setVisible(true);
	}
}
