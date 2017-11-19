package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
	private String name;
	private Roles role;
	private String profile;
	private ArrayList<File> fingerprints = new ArrayList<File>();
	private ArrayList<String> paths = new ArrayList<String>();

	public User() {

	}

	public User(String name, Roles role) {
		this.name = name;
		this.role = role;
		this.profile = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public ArrayList<File> getFingerprints() {
		return fingerprints;
	}

	public void setFingerprints(ArrayList<File> fingerprints) {
		this.fingerprints = fingerprints;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public ArrayList<String> getPaths() {
		return paths;
	}

	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}

}
