package dao;

import java.io.File;
import java.util.ArrayList;

import model.Roles;
import model.User;

public class DAOUser {
	/**
	 * @desc Pega todos os usu�rios
	 * @return Lista de Usu�rios
	 */
	public ArrayList<User> getAllUsers() {
		//Cria usuarios fake
		ArrayList<File> listFinger = new ArrayList<File>();
		
		ArrayList<User> list = new ArrayList<User>();
		User tom = new User("Tom",Roles.ADMIN,"src/images/tom.png");
		//Pega as digitais do tom
		for(int i = 1; i <= 8; i++) {
			listFinger.add(new File("src/images/tom_fingerprints/"+i+".jpg"));
		}
		tom.setFingerprints(listFinger);
		list.add(tom);
		
		User jerry = new User("Jerry", Roles.USER,"src/images/jerry.jpg");
		//Pega as digitais do tom
		listFinger = new ArrayList<File>();
		for(int i = 1; i <= 8; i++) {
			listFinger.add(new File("src/images/jerry_fingerprints/"+i+".jpg"));
		}
		jerry.setFingerprints(listFinger);
		list.add(jerry);
		
		User mod = new User("Moderator", Roles.MOD,"src/images/jerry.jpg");
		//Pega as digitais do tom
		listFinger = new ArrayList<File>();
		for(int i = 1; i <= 8; i++) {
			listFinger.add(new File("src/images/mod_fingerprints/"+i+".jpg"));
		}
		mod.setFingerprints(listFinger);
		list.add(mod);
		
		return list;
	}
}
