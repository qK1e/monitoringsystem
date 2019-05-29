import java.util.HashMap;

public class FakeInfoManager implements InfoHandler {
    public HashMap<String, String> getTodayPages() {
        HashMap<String, String> today = new HashMap<String, String>();
        today.put("www.loogle.com/login", "<html>Content</html>");
        today.put("www.loogle.com/page1", "<html>Page 1 Content</html>");
        today.put("www.pediwikia.com/page1", "<html>Page 1 Content</html>");
        today.put("www.pediwikia.com/page2", "<html>Page 2 Content</html>");
        today.put("www.pediwikia.com/page3", "<html>Page 3 Content</html>");


        return today;
    }

    public HashMap<String, String> getYesterdayPages() {
        HashMap<String, String> yesterday = new HashMap<String, String>();

        yesterday.put("www.loogle.com/login", "<html>Content</html>");
        yesterday.put("www.pediwikia.com/page1", "<html>Page 1 Content old</html>");
        yesterday.put("www.pediwikia.com/page2", "<html>Page 2 Content</html>");
        yesterday.put("www.pediwikia.com/page3", "<html>Page 3 Content old</html>");
        yesterday.put("www.pediwikia.com/page0", "<html>Page 0 Content</html>");
        return yesterday;
    }
}
