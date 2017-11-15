package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
	private String name;
	private Roles role;
	private String profile;
	private ArrayList<File> fingerprints = new ArrayList<File>();

	public User() {

	}

	public User(String name, Roles role, String profile) {
		this.name = name;
		this.role = role;
		this.profile = profile;
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

}
