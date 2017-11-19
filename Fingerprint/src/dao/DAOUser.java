package dao;

import java.io.File;
import java.util.ArrayList;

import model.Roles;
import model.User;

public class DAOUser {
	/**
	 * @desc Pega todos os usuários
	 * @return Lista de Usuários
	 */
	public ArrayList<User> getAllUsers() {
		//Cria usuarios fake
		ArrayList<File> listFinger = new ArrayList<File>();
		
		ArrayList<User> list = new ArrayList<User>();
		User tom = new User("Tom",Roles.ADMIN);
		//Pega as digitais do tom
		for(int i = 1; i <= 8; i++) {
			tom.getPaths().add("images/tom_fingerprints/"+i+".jpg");
			listFinger.add(new File("src/images/tom_fingerprints/"+i+".jpg"));
		}
		tom.setFingerprints(listFinger);
		list.add(tom);
		
		User jerry = new User("Jerry", Roles.USER);
		//Pega as digitais do tom
		listFinger = new ArrayList<File>();
		for(int i = 1; i <= 8; i++) {
			jerry.getPaths().add("images/jerry_fingerprints/"+i+".jpg");
			listFinger.add(new File("src/images/jerry_fingerprints/"+i+".jpg"));
		}
		jerry.setFingerprints(listFinger);
		list.add(jerry);
		
		User mod = new User("Moderator", Roles.MOD);
		//Pega as digitais do tom
		listFinger = new ArrayList<File>();
		for(int i = 1; i <= 8; i++) {
			mod.getPaths().add("images/mod_fingerprints/"+i+".jpg");
			listFinger.add(new File("src/images/mod_fingerprints/"+i+".jpg"));
		}
		mod.setFingerprints(listFinger);
		list.add(mod);
		
		return list;
	}
}
