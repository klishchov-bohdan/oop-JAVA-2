package datingBureau;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
			System.out.println("6 - WRITE TO FILE");
			System.out.println("7 - READ FROM FILE");
			System.out.println("8 - SORT BY NAME");
			System.out.println("9 - EXIT PROGRAM\n");
			

			while(true) {
				System.out.print("Your choice: ");
				in = new Scanner(System.in);   	
				choose = in.nextInt();
				if(choose < 1 || choose > 8) {
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
				try(FileWriter writer = new FileWriter("clients.txt", false))
		        {
					for(int i = 0; i < registration.getSize(); i++) {
						writer.write(registration.clientToStringByIndex(i));
					}
		            writer.flush();
		        }
		        catch(IOException ex){
		             
		            System.out.println(ex.getMessage());
		        } 
				break;
			case 7:
				 try(FileReader reader = new FileReader("clients.txt"))
			        {
			            int c;
			            while((c=reader.read())!=-1){
			                System.out.print((char)c);
			            } 
			        }
			        catch(IOException ex){
			             
			            System.out.println(ex.getMessage());
			        }   
				break;
			case 8:
				registration.sortByName();
				break;
			case 9:
				return;
			}
		} while (true); 
	}
	
	public static void auto(Registration registration) throws InterruptedException {
		Random random = new Random ();
		String[] gender = {"male", "female"};
		String[] name = {"John", "Victor", "James", "Lana", "Nika", "Albert"};
		String[] hobby = {"fishing", "football", "chess", "cooking", "fighting", "games"};
		String[] requirements = {"honeshttp://www.objectaid.com/update/1.1tly", "kindness", "sense of humor"};
		String[] phoneNums = {"+38(067)-106-46-38", "+38(066)-697-32-99", "+38(093)-782-39-50", "+38(097)-782-39-50", 
							  "+38(099)-782-39-50", "+38(063)-782-39-50"};
		String phoneNumber;
		
		for(int i = 0; i < 10; i++) {
			phoneNumber =  menuHelper.getRandomString(phoneNums);
			registration.register(
					menuHelper.getRandomString(gender), 
					new Date(), 
					menuHelper.getRandomName(name), 
					random.nextInt(40) + 16, 
					menuHelper.getRandomString(hobby),
					menuHelper.getRandomString(requirements),
					phoneNumber,
					menuHelper.getProvider(phoneNumber));
		}
		registration.sortByName();
		// writing to clients.txt
		try(FileWriter writer = new FileWriter("clients.txt", false))
        {
			for(int i = 0; i < registration.getSize(); i++) {
				writer.write(registration.clientToStringByIndex(i));
			}
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
		//reading from clients.txt
		try(FileReader reader = new FileReader("clients.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            } 
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
	}
}