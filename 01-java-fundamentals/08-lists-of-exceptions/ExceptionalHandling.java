import java.util.ArrayList;

public class ExceptionalHandling {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(42);
        myList.add("goodby world");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
            } catch (Exception e) {
                System.out.println("Something is rotten in the state of this for loop!");
                System.out.println(e);
            }
        }
    }
}
