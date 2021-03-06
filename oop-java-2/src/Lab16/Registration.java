package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

public class Registration implements Serializable{
	private static final long serialVersionUID = 1L;
	ArrayList<Client> client = new ArrayList<Client>();

	//------------------------------------------------------

	public void register(String gender, Date dateOfRegistration, String name, int age, String hobby, String requirements, String phoneNumber, String phoneProvider) {
		Client client = new Client();
		client.setID(getRandomValue());
		client.setGender(gender);
		client.setDateOfRegistration(dateOfRegistration);
		client.setName(name);
		client.setAge(age);
		client.setHobby(hobby);
		client.setRequirements(requirements);
		client.setPhoneNum(phoneNumber);
		client.setPhoneProvider(phoneProvider);
		this.client.add(client);
	}


	public void print() {
		for(int i = 0; i < this.client.size(); i++) {
			printByIndex(i);
		}
	}

	public void printByIndex(int index) {
		System.out.println("ID: " + this.client.get(index).getID());
		System.out.println("Gender: " + this.client.get(index).getGender());
		System.out.println("Date of registration: " + this.client.get(index).getDateOfRegistration());
		System.out.println("Name: " + this.client.get(index).getName());
		System.out.println("Age: " + this.client.get(index).getAge());
		System.out.println("Hobby: " + this.client.get(index).getHobby());
		System.out.println("Requirements: " + this.client.get(index).getRequirements());
		System.out.println("Phone number: " + this.client.get(index).getPhoneNum() + " (" + this.client.get(index).getPhoneProvider() + ")" + "\n");
	}

	public String clientToStringByIndex(int index) {
		String result;
		result = "ID: " + this.client.get(index).getID() + "\n" +
				 "Gender: " + this.client.get(index).getGender() + "\n" +
				 "Date of registration: " + this.client.get(index).getDateOfRegistration() + "\n" +
				 "Name: " + this.client.get(index).getName() + "\n" +
				 "Age: " + this.client.get(index).getAge() + "\n" +
				 "Hobby: " + this.client.get(index).getHobby() + "\n" +
				 "Requirements: " + this.client.get(index).getRequirements() + "\n" +
				 "Phone number: " + this.client.get(index).getPhoneNum() +
				 " (" + this.client.get(index).getPhoneProvider() + ")" + "\n\n";
		return result;
	}

	public void sortByName() {
	    Collections.sort(this.client, new SortByName());
	  }

	public void setClients(ArrayList<Client> client) {
		this.client = client;
	}

	public void clearClients() {
		this.client.clear();
	}

	public Client getClientByIndex(int index){
		return this.client.get(index);
	}

	public ArrayList<Client> getClients() {
		return this.client;
	}

	public int getSize() {
		return this.client.size();
	}

	private int getRandomValue() {
		int min = 0;
		int max = 99999999;
		int diff = max - min;
		Random random = new Random();
		int value = random.nextInt(diff + 1);
		return value += min;
	}

	class SortByName implements Comparator<Client> {
	    public int compare(Client a, Client b) {
	        return a.getName().compareTo(b.getName());
	    }
	}

	public void sortByDateOfRegistration() {
	    Collections.sort(this.client, new SortByDateOfReg());
	  }

	class SortByDateOfReg implements Comparator<Client> {
	    public int compare(Client a, Client b) {
	        return a.getDateOfRegistration().compareTo(b.getDateOfRegistration());
	    }
	}
}
