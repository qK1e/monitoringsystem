import java.util.HashMap;

public interface InfoProvider {
    HashMap<String, String> getTodayPages();
    HashMap<String, String> getYesterdayPages();
}
