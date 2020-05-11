package datingBureau;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ID;
	private String gender;
	private Date dateOfRegistration;
	private String name;
	private int age;
	private String hobby;
	private String requirements;
	private String phoneNumber;
	private String phoneProvider;
	
	//-----------------------------------------------------------------------
	
	public int getID() {
		return ID;
	}
	public String getGender() {
		return gender;
	}
	public Date getDateOfRegistration() {
		return dateOfRegistration;
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
	public String getPhoneNum() {
		return phoneNumber;
	}
	public String getPhoneProvider() {
		return phoneProvider;
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
	public void setPhoneNum(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setPhoneProvider(String phoneProvider) {
		this.phoneProvider = phoneProvider;
	}
}