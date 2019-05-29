import java.util.*;

public class Analyser {

    private ArrayList<String> missingPages;
    private ArrayList<String> changedPages;
    private ArrayList<String> newPages;

    public List getMissingPages() {
        return missingPages;
    }

    public List getChangedPages() {
        return changedPages;
    }

    public List getNewPages() {
        return newPages;
    }

    public Analyser(HashMap<String, String> today, HashMap<String, String> yesterday)
    {
        missingPages = new ArrayList<String>();
        newPages = new ArrayList<String>();
        changedPages = new ArrayList<String>();

        analyse(today, yesterday);
    }

    public void analyse(HashMap<String, String> today, HashMap<String, String> yesterday){
        Iterator<String> it = today.keySet().iterator();

        String currentUrl;
        Set<String> yesterdayCopy = yesterday.keySet();
        String yesterdayPage;
        //проходимся по всем сегодняшним страницам. Если не нашли вчера - в новые.
        //если нашли, но страница поменялась - в изменённые и удаляем из копии вчерашних.
        //если нашли, и страница не изменилась - удаляем из копии вчерашних.
        //в копии вчерашних остались только те, которых нет сегодня - добавляем в пропавшие.
        while(it.hasNext())
        {
            currentUrl = it.next();

            yesterdayPage = yesterday.get(currentUrl);
            if(yesterdayPage == null)
            {
                newPages.add(currentUrl);
                continue;
            }
            if(!yesterdayPage.equals(today.get(currentUrl)))
            {
                changedPages.add(currentUrl);
            }
            yesterdayCopy.remove(currentUrl);
        }
        missingPages.addAll(yesterdayCopy);
    }
}
