import java.util.Random;
public class StringGen {
	public static int getRand(int max) {
		Random randMachine = new Random();
		return randMachine.nextInt(max);
	}
	public static char getRandomChar() {
		int num = getRand(36);
		char ch;
		if (num<26) {
			ch = (char) ('A'+num);
		} else {
			num -= 26;
			ch = (char) ('0'+num);
		}
		
		return ch;
	}
	public static String generateString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
				str += getRandomChar();
		}
		return str;
	}
}