import java.util.HashMap;
import java.util.Iterator;

//сделать отдельным потоком
public class MonitoringSystem {

    private static String prepareMessage(Analyser info)
    {
        String name = "ФИО секретаря";

        StringBuilder builder = new StringBuilder();
        builder.append("Здравствуйте, дорогая ").append(name).append("!\n\n");
        builder.append("За последние сутки на вверенных Вам сайтах произошли следующие изменения:\n");
        builder.append("Исчезли следующие страницы:\n");

        Iterator it = info.getMissingPages().iterator();

        while(it.hasNext())
        {
            String url = (String)it.next();
            builder.append(url);
            builder.append("\n");
        }

        builder.append("Появились следующие новые страницы:\n");

        it = info.getNewPages().iterator();

        while(it.hasNext())
        {
            String url = (String)it.next();
            builder.append(url);
            builder.append("\n");
        }

        builder.append("Изменились следующие страницы:\n");

        it = info.getChangedPages().iterator();

        while(it.hasNext()) {
            String url = (String) it.next();
            builder.append(url).append("\n");
        }

        builder.append("\nС уважением, \n\nАвтоматизированная Система Мониторинга");

        return builder.toString();
    }

    public static void main(String[] args)
    {
        String maillogin = "default@yandex.ru"; //поменять
        String mailpassword = "admin";   //поменять
        String recipient = "to@yandex.ru"; //поменять


        InfoHandler infomanager = new FakeInfoManager();
        HashMap<String, String> yesterday;
        HashMap<String, String> today;
        today = infomanager.getTodayPages();
        yesterday = infomanager.getYesterdayPages();

        Analyser analyser = new Analyser(today, yesterday);

        Sender sender = new Sender(maillogin, mailpassword, recipient, "smtp.yandex.ru");
        String message = prepareMessage(analyser);
        sender.send(message);
    }

}
