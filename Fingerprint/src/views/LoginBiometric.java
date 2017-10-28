package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import helpers.FingerAnalysis;
import model.User;

public class LoginBiometric {
	public void view() {
		JFrame frame = new JFrame("Login");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel lbTitle = new JLabel("Bem Vindo");
		lbTitle.setLocation(150, 120);
		lbTitle.setSize(150,20);
		frame.add(lbTitle);
		
		JLabel lbSubTitle = new JLabel("Insira uma digital no bot�o abaixo");
		lbSubTitle.setLocation(lbTitle.getX() - 60, lbTitle.getY() +  lbTitle.getHeight() + 20);
		lbSubTitle.setSize(200,20);
		frame.add(lbSubTitle);
		
		JButton btnOpen = new JButton("Escolher uma digital");
		btnOpen.setSize(150,20);
		btnOpen.setLocation(lbSubTitle.getX() + 22, lbSubTitle.getY() +  lbSubTitle.getHeight() + 20);
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String fingerPath = "";
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					fingerPath = selectedFile.getAbsolutePath();
					System.out.println(selectedFile.getAbsolutePath());
				}
				FingerAnalysis analise = new FingerAnalysis();
				try {
					if(fingerPath != "") {
						User user = analise.getFingerOwner(fingerPath);
						//Caso tenha um usu�rio, eu redireciono ele para a tela seguinte
						if(user != null) {
							JOptionPane.showMessageDialog(null, "O dono da digital � o " + user.getName());
						}else {
							JOptionPane.showMessageDialog(null, "N�o foi encontrado um usu�rio com essa digital");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Informe ao menos uma imagem");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.add(btnOpen);
		
		
				
		frame.setVisible(true);
		
	}
}
