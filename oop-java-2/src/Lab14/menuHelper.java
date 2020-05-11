package datingBureau;

import java.util.Random;
import java.util.regex.Pattern;

public class menuHelper {
	public static boolean check_name(String name) {
		return name.matches("[A-Z][a-z]*");
	}
	
	public static boolean check_phone_number(String number) {
		return number.matches("\\+38\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}");
	}
	
	public static boolean check_vodafone(String num) {
		if(Pattern.matches("^\\+38\\(050\\).*", num) || Pattern.matches("^\\+38\\(066\\).*", num) 
		|| Pattern.matches("^\\+38\\(095\\).*", num) || Pattern.matches("^\\+38\\(099\\).*", num)) { 
			return true;
		} else { 
			return false; 
		}
	}
	public static boolean check_lifecell(String num) {
		if(Pattern.matches("^\\+38\\(063\\).*", num) || Pattern.matches("^\\+38\\(093\\).*", num) 
		|| Pattern.matches("^\\+38\\(073\\).*", num)) {
			return true;
		} else {
		return false;
		}
	}
	public static boolean check_kyivstar(String num) {
		if(Pattern.matches("^\\+38\\(039\\).*", num) || Pattern.matches("^\\+38\\(067\\).*", num)
		|| Pattern.matches("^\\+38\\(068\\).*", num) || Pattern.matches("^\\+38\\(096\\).*", num)
		|| Pattern.matches("^\\+38\\(097\\).*", num) || Pattern.matches("^\\+38\\(098\\).*", num)) {
			return true;
		} else {
		return false;
		}
	}
	
	public static String getProvider(String number) {
		String provider = "Unknown";
		if(check_vodafone(number) == true) {
			provider = "Vodafone";
		}
		else if(check_lifecell(number) == true) {
			provider = "LifeCell";
		}
		else if(check_kyivstar(number) == true) {
			provider = "Kyivstar";
		}
		return provider;
	}
	
	public static String getRandomName(String[] str) {
		Random random = new Random ();
		int pos = random.nextInt(str.length);
		if(!menuHelper.check_name(str[pos])) {
			System.out.println("WARNING: Invalid name!!!");
			return null;
		} else {
			return str[pos];
		}
	}
	
	public static String getRandomString(String[] str) {
		Random random = new Random ();
		int pos = random.nextInt(str.length);
		return str[pos];
	}
	
	public static int getIndexOfOldestClient(Registration reg) {
		int index = 0;
		for(int i = 1; i < reg.getSize(); i++) {
			if(reg.getClientByIndex(i).getAge() > reg.getClientByIndex(index).getAge()) {
				index = i;
			}
		}
		return index;
	}
	
	public static int getIndexOfYoungestClient(Registration reg) {
		int index = 0;
		for(int i = 1; i < reg.getSize(); i++) {
			if(reg.getClientByIndex(i).getAge() < reg.getClientByIndex(index).getAge()) {
				index = i;
			}
		}
		return index;
	}
	
	public static void getAverageAge(Registration reg) {
		int averageAge = 0;
		for(int i = 0; i < reg.getSize(); i++) {
			averageAge = averageAge + reg.getClientByIndex(i).getAge();
		}
		averageAge = averageAge / reg.getSize();
		System.out.println("Average age: " + averageAge + "\n");
	}
}
