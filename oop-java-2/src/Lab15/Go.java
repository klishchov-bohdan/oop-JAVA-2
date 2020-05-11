package datingBureau;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Go {
	static Registration registration = new Registration();	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
	
		for(String str : args) {
			if (str.equals("-auto")) {
				Menu.auto(registration);
				return;
			}
		}
		Menu.menu(registration);
		//Menu.auto(registration);
	}
}