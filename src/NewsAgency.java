import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> subscribers;
    private String agencyName;
    
    public NewsAgency(String agencyName) {
        this.subscribers = new ArrayList<>();
        this.agencyName = agencyName;
    }
    
    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
        System.out.println("New subscriber added. Total: " + subscribers.size());
    }
    
    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
        System.out.println("Subscriber removed. Total: " + subscribers.size());
    }
    
    @Override
    public void notifyObservers(String category, String news) {
        System.out.println(agencyName + " Broadcasting News");
        for (Observer observer : subscribers) {
            observer.update(category, news);
        }
    }
    
    // Publish breaking news with category
    public void publishNews(String category, String news) {
        System.out.println("\nBREAKING NEWS [" + category + "]: " + news);
        notifyObservers(category, news);
    }
}