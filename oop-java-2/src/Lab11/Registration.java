package datingBureau;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Registration implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Client> client = new ArrayList<Client>();
	
	//------------------------------------------------------
	
	public void register(String gender, Date dateOfRegistration, String name, int age, String hobby, String requirements) {
		Client client = new Client();
		client.setID(getRandomValue());
		client.setGender(gender);
		client.setDateOfRegistration(dateOfRegistration);
		client.setName(name);
		client.setAge(age);
		client.setHobby(hobby);
		client.setRequirements(requirements);
		this.client.add(client);
	}
	
	
	public void print() {
		for(int i = 0; i < this.client.size(); i++) {
			System.out.println("ID: " + this.client.get(i).getID());
			System.out.println("Gender: " + this.client.get(i).getGender());
			System.out.println("Date of registration: " + this.client.get(i).getDateOfRegistration());
			System.out.println("Name: " + this.client.get(i).getName());
			System.out.println("Age: " + this.client.get(i).getAge());
			System.out.println("Hobby: " + this.client.get(i).getHobby());
			System.out.println("Requirements: " + this.client.get(i).getRequirements() + "\n");
		}
	}
	
	public void setClient(Client client) {
		this.client.add(client);
	}
	
	public void clearClients() {
		this.client.clear();
	}
	
	public Client getClientByIndex(int index){
		return this.client.get(index);
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
}