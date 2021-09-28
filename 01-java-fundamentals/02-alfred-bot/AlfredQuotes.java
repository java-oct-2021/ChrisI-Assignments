import java.util.Date;
public class AlfredQuotes {
    /** 
     * description: Basic greeting
     * 
     * @return Basic greeting
     */
    public static String greeting() {
        return "Hello, lovely to see you. How are you?";
    }

    /**
     * description: Personalized greeting from given info
     * 
     * @param name      Name of guest 
     * @param dayPeriod morning, afternoon or evening
     * @return          Personalized greeting
     */
    public static String greeting(String name, String dayPeriod) {
        return "Good "+dayPeriod+", "+name+". Lovely to see you.";
    }

    /**
     * description: Announce the date
     * @return      Announced date
     */
    public static String dateAnnouncement() {
        var date = new Date();
        return "It is "+date;
    }

    /**
     * description: responds depending on stated name
     * @param conversation  conversation string
     * @return              Robo Alfred's response/interjection
     */
    public static String respondBeforeAlexis(String conversation) {
        conversation = conversation.toLowerCase();
        if (conversation.contains("alexis")) {
            return "It is already done. I'm sure she hasn't anticipated that!";
        }
        if(conversation.contains("alfred")) {
            return "At your service, Master Bruce.";
        }

        return "Right. And with that I shall retire.";
    }
}
