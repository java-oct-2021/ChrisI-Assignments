public class PhoneTester {
    public static void main(String[] args) {
        Galaxy s9 = new Galaxy("S9", 80, "vodaphone", "ring ring ring!");
        IPhone ipx = new IPhone("x", 81, "verizon", "zing!");
        s9.displayInfo();
        System.out.println(s9.ring());
        System.out.println(s9.unlock());
        ipx.displayInfo();
        System.out.println(ipx.ring());
        System.out.println(ipx.unlock());
    }
}
