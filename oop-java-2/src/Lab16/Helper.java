package application;

import java.util.Random;
import java.util.regex.Pattern;

public class Helper {
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

	public static String searchPairs(Registration reg) {
		Client client = new Client();
		int counter = 1;
		String strRes = "";
		for(int j = 0; j < reg.getSize() - 1; j++) {
			client = reg.getClientByIndex(j);
			for(int i = j + 1; i < reg.getSize(); i++) {
				if(client.getAge() - reg.getClientByIndex(i).getAge() >= -5 && reg.getClientByIndex(i).getAge() - client.getAge() >= -5) {
					if(client.getAge() - reg.getClientByIndex(i).getAge() <= 5 && reg.getClientByIndex(i).getAge() - client.getAge() <= 5) {
						if((client.getGender() == "male" && reg.getClientByIndex(i).getGender() == "female") ||
							(client.getGender() == "female" && reg.getClientByIndex(i).getGender() == "male")) {
							strRes = strRes + "--------------------------------\n" + "Pair number " + counter + ": \n\n";
							strRes = strRes + reg.clientToStringByIndex(j);
							strRes = strRes + reg.clientToStringByIndex(i);
							strRes = strRes + "--------------------------------\n";
							counter++;
						}
					}
				}
			}
		}
		return strRes;
	}

	public static String getRandomString(String[] str) {
		Random random = new Random ();
		int pos = random.nextInt(str.length);
		return str[pos];
	}
}

