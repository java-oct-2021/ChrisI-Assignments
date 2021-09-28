import java.util.ArrayList;

public class BasicJava {
    public static void print1to255() {
        System.out.println("\nPrint 1 to 255:");
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }
    public static int sum1to255() {
        System.out.println("\nSum 1 to 255");
        int sum = 0;
        for (int i = 1; i <= 255; i++) {
            sum += i;
        }
        return sum;
    }
    public static void printArray() {
        System.out.println("\nPrint array:");
        int[] arr = {5,2,6,8,3,2,1,35,8};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int findMax(int[] array) {
        System.out.println("\nPrint max:");
        int max = array[0];
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            arrlist.add(array[i]);
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(arrlist);
        System.out.println(max);
        return max;
    }
    public static void odds1to255() {
        System.out.println("\nPrint 1 to 255 odds array:");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            if(i%2 != 0) {
                arr.add(i);
            }
        }
        System.out.println(arr);
    }
    // public static void name() {
        
    // }
}
