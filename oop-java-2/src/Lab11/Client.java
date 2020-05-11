package datingBureau;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	public int ID;
	public String gender;
	public Date dateOfRegistration;
	public String name;
	public int age;
	public String hobby;
	public String requirements;
	
	//-----------------------------------------------------------------------
	
	public int getID() {
		return ID;
	}
	public String getGender() {
		return gender;
	}
	public String getDateOfRegistration() {
		return dateOfRegistration.toString();
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getHobby() {
		return hobby;
	}
	public String getRequirements() {
		return requirements;
	}
	
	//-------------------------------------------------------------------
	
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
}