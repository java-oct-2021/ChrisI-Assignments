import java.util.ArrayList;
public class Tester {
    public static void main(String[] args) {
        PuzzleJava puzz = new PuzzleJava();
        ArrayList<String> pws = puzz.getNewPasswordSet(8);
        System.out.println(pws);
        System.out.println(puzz.shuffle(pws));
        System.out.println(puzz.shuffle(pws));
        System.out.println(puzz.shuffle(pws));
    }
}
