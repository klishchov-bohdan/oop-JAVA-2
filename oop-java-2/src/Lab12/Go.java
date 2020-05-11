package datingBureau;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Go {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Registration registration = new Registration();		
		for(String str : args) {
			if (str.equals("-auto")) {
				Menu.auto(registration);
				return;
			}
		}
		Menu.auto(registration);
	}
}