package datingBureau;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class Menu {
	
	
	
	//@SuppressWarnings("resource")
	@SuppressWarnings({ "resource"})
	public static void menu(Registration registration) throws FileNotFoundException, IOException, ClassNotFoundException {
		MyLinkedList <Client> myList = new MyLinkedList <Client> ();
		String gender;
		String name;
		int age;
		String hobby;
		String requirements;
		String phoneNum;
		String provider;
		int choose;
		Scanner in;  
		do {			
			System.out.println("1 - REGISTER NEW CLIENT");
			System.out.println("2 - OUTPUT CLIENTS INFO");
			System.out.println("3 - GENERIC CLASS");
			System.out.println("4 - SERIALIZE OBJECT");
			System.out.println("5 - DESERIALIZE OBJECT");
			System.out.println("6 - EXIT PROGRAM\n");

			while(true) {
				System.out.print("Your choice: ");
				in = new Scanner(System.in);   	
				choose = in.nextInt();
				if(choose < 1 || choose > 6) {
					System.out.println("Invalid number of operation.");
					continue;
				}
				break;
			}
			System.out.print("\n");

			switch (choose)
			{
			case 1:
				System.out.print("Enter the gender(male or female): ");
				in = new Scanner(System.in);
				gender = in.nextLine();
				
				System.out.print("Enter the name: ");
				in = new Scanner(System.in);
				name = in.nextLine();
				while(!menuHelper.check_name(name)) {
					System.out.print("WARNING: Invalid name. Try again: ");
					name = in.nextLine();
				}
				
				System.out.print("Enter the age: ");
				in = new Scanner(System.in);
				age = in.nextInt();
				
				System.out.print("Enter the hobby(football, fishing): ");
				in = new Scanner(System.in);
				hobby = in.nextLine();
				
				System.out.print("Enter the requirements(honest, polite, ...): ");
				in = new Scanner(System.in);
				requirements = in.nextLine();
				
				System.out.print("Enter the phone number(+38(XXX)-XXX-XX-XX): ");
				in = new Scanner(System.in);
				phoneNum = in.nextLine();
				while(!menuHelper.check_phone_number(phoneNum)) {
					System.out.print("WARNING: Invalid phone number. Try again: ");
					phoneNum = in.nextLine();
				}
				provider = menuHelper.getProvider(phoneNum);
				
				System.out.print("\n");
				
				System.out.println("Complete!!!\n");
				
				registration.register(gender, new Date(), name, age, hobby, requirements, phoneNum, provider);
				
				break;
			case 2:
				registration.print();
				break;
			case 3:
				System.out.println("Adding to container...");
				for(int i = 0; i < registration.getSize(); i++) {
					myList.add(registration.getClientByIndex(i));
				}
				if(myList.getSize() != 0) {
					System.out.println("Complete!!!");
				} else { System.out.println("Error"); }
				
				registration.clearClients();
				
				System.out.println("Reading from container...");
				for(int i = 0; i < myList.getSize(); i++) {
					registration.setClient(myList.get(i));
				}
				System.out.println("Complete!!!\n");
				myList.clear();
				
				break;
			case 4:
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.out")))
		        {
		            oos.writeObject(registration);
		            System.out.println("File has been written");
		        }
		        catch(Exception ex){
		             
		            System.out.println(ex.getMessage() + "\n");
		        } 
				break;
			case 5:
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.out")))
		        {
		            Registration oisRegistration = (Registration)ois.readObject();
		            
		            oisRegistration.print();
		        }
		        catch(Exception ex){
		             
		            System.out.println(ex.getMessage() + "\n");
		        }
				break;
			case 6:
				return;
			}
		} while (true); 
	}
	
	public static void auto(Registration registration) {
		Random random = new Random ();
		String[] gender = {"male", "female"};
		String[] name = {"John", "Victor", "James", "Lila", "Kate", "Lisa"};
		String[] hobby = {"fishing", "football", "chess"};
		String[] requirements = {"honestly", "kindness", "sense of humor"};
		String[] phoneNums = {"+38(067)-106-46-38", "+38(066)-697-32-99", "+38(093)-782-39-50"};
		String phoneNumber;
		
		for(int i = 0; i < 5; i++) {
			phoneNumber =  menuHelper.getRandomString(phoneNums);
			registration.register(
					menuHelper.getRandomString(gender), 
					new Date(), 
					menuHelper.getRandomName(name), 
					random.nextInt(29) + 16, 
					menuHelper.getRandomString(hobby),
					menuHelper.getRandomString(requirements),
					phoneNumber,
					menuHelper.getProvider(phoneNumber));
		}
		menuHelper.searchPairs(registration);
	}
}