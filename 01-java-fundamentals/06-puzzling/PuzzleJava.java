import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {
    public static int getRand(int max) {
        Random randMachine = new Random();
        return randMachine.nextInt(max);
    }
    public static int getRand(int min, int max) {
        Random randMachine = new Random();
        return min + randMachine.nextInt(max - min);
    }

    public static ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arrlist.add(getRand(20)+1);
        }
        
        return arrlist;
    }
    public static char getRandomLetter() {
        char[] alphabet = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        return alphabet[getRand(26)];
    }
    public static String generatePassword() {
        String pw = "";
        for (int i = 0; i < 8; i++) {
            pw += getRandomLetter();
        }
        return pw;
    }
    public static ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> pwlist = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            pwlist.add(generatePassword());
        }
        return pwlist;
    }
    
    public static ArrayList<String> shuffle(ArrayList<String> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int randIndex = getRand(i, size);
            String temp = arrayList.get(randIndex);
            arrayList.set(randIndex, arrayList.get(i));
            arrayList.set(i, temp);
        }
        return arrayList;
    }
}
