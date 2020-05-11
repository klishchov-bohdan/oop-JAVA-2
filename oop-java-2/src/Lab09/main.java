import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class main {
	//saving in eclipse-workspace directory
	private final static String filename = "..\\savedContainer.xml";
	private final static String filename2 = "..\\savedContainer.txt";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String[] mas = {"str1","str2","str3"};
		MyLinkedList<String> list = new MyLinkedList<>(mas);
		
		
		
	    System.out.println("Init: " + list.toString());
	    saveSystem(list);
	    list.clear();
	    System.out.println("After clear: " + list.toString());
	    list = loadSystem();
	    System.out.println("After loadSystem(): " + list.toString());
	    list.add("addStr");
	    System.out.println("After add 'addStr': " + list.toString());
	    System.out.println("List is contain 'addStr': " + list.remove("addStr"));
	    System.out.println("After remove 'addStr': " + list.toString() + "\n");

	    System.out.println("Saving list to container...");
	    saveContainer(list);
	    System.out.println("Complete!!!");
	    System.out.println("Clearing list...");
	    list.clear();
	    System.out.println("Complete!!!");
	    System.out.println("After clear: " + list.toString());
	    list = recoverContainer();
	    System.out.println("After recoverContainer(): " + list.toString());
	    list.add("addStr2");
	    System.out.println("After add 'addStr2': " + list.toString());
	    System.out.println("List is contain 'str2': " + list.remove("str2"));
	    System.out.println("After removing 'str2': " + list.toString() + "\n");
	    
	    System.out.println("Using for-each: ");
		for(Object s : list) {
			System.out.println(s.toString());
		}
	}
	
	
	
	static public void saveContainer(MyLinkedList list) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(filename2);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    objectOutputStream.writeObject(list);
	    objectOutputStream.close();
	}
	static public MyLinkedList recoverContainer() throws IOException, ClassNotFoundException {
		MyLinkedList list = new MyLinkedList<>();
		FileInputStream fileInputStream = new FileInputStream(filename2);
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    list = (MyLinkedList) objectInputStream.readObject();
	    objectInputStream.close();
	    return list;
	}
	
	static void saveSystem(MyLinkedList list) {
		try{
  			XMLEncoder encoder = new XMLEncoder(new FileOutputStream(filename));
  			encoder.writeObject(list);
  			encoder.close();
  		} catch (Exception e){
  			System.out.println(e);
  		}
	}
	static MyLinkedList loadSystem() {
		MyLinkedList<Client> list = new MyLinkedList<>();
		try{
			XMLDecoder decoder = new XMLDecoder(new FileInputStream(filename));
			list = (MyLinkedList) decoder.readObject();
			decoder.close();		
		} catch (Exception e){
			System.out.println(e);
		}
		return list;
	}
}