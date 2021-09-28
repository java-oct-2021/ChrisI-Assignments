import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String,String> songList = songs();
        System.out.println(songList.get("DIY"));
        Set<String> keys = songList.keySet();
        for(String title: keys) {
            System.out.println(title+" : "+songList.get(title));
        }
    }
    public static HashMap<String,String> songs() {
        HashMap<String,String> songList = new HashMap<String,String>();
        songList.put("tousled", "I'm baby tousled meh hexagon migas art party shabby chic shoreditch 90's pinterest post-ironic gluten-free la croix");
        songList.put("Fugiat", "Fugiat ad before they sold out, asymmetrical edison bulb laboris vegan pariatur flexitarian");
        songList.put("DIY", "Snackwave deep v succulents four loko 3 wolf moon pickled yr magna intelligentsia etsy DIY retro glossier");
        songList.put("kombucha", "Plaid enim dreamcatcher +1 keffiyeh occupy, hot chicken narwhal cold-pressed kombucha poutine meh tattooed");
        return songList;
    }
}
