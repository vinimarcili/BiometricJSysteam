package dao;

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
		ArrayList<User> list = new ArrayList<User>();
		User tom = new User("Tom",Roles.ADMIN,"src/images/tom.png");
		list.add(tom);
		
		User jerry = new User("Jerry", Roles.USER,"src/images/jerry.jpg");
		list.add(jerry);
		return list;
	}
}
