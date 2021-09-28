public class AlfredTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();
        System.out.println(alfredBot.greeting());
        System.out.println(alfredBot.greeting("Commissioner Gordon","evening"));
        System.out.println(alfredBot.dateAnnouncement());
        System.out.println(alfredBot.respondBeforeAlexis("Alexis! Play some lofi beats"));
        System.out.println(alfredBot.respondBeforeAlexis("Hey Alfred, can you see who's at the door?"));
        System.out.println(alfredBot.respondBeforeAlexis("I need something to keep me awake, so I can fight crime at night!"));
    } 
}
