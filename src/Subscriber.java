import java.util.ArrayList;
import java.util.List;

public class Subscriber implements Observer {
    private String name;
    private List<String> interestedCategories;
    private boolean notificationsEnabled;
    
    public Subscriber(String name) {
        this.name = name;
        this.interestedCategories = new ArrayList<>();
        this.notificationsEnabled = true;
    }
    
    @Override
    public void update(String category, String news) {
        // If no preferences set, receive all news
        if (interestedCategories.isEmpty()) {
            if (notificationsEnabled) {
                System.out.println(name + " received: [" + category + "] " + news);
            }
        } else {
            // Only receive news from interested categories
            if (interestedCategories.contains(category) && notificationsEnabled) {
                System.out.println(name + " received: [" + category + "] " + news);
            }
        }
    }
    
    // Modify preferences - add category interest
    public void addCategoryInterest(String category) {
        if (!interestedCategories.contains(category)) {
            interestedCategories.add(category);
            System.out.println(name + " now subscribed to category: " + category);
        }
    }
    
    // Modify preferences - remove category interest
    public void removeCategoryInterest(String category) {
        if (interestedCategories.remove(category)) {
            System.out.println(name + " unsubscribed from category: " + category);
        }
    }
    
    // Modify preferences - toggle notifications
    public void setNotifications(boolean enabled) {
        this.notificationsEnabled = enabled;
        System.out.println(name + " notifications: " + (enabled ? "ON" : "OFF"));
    }
    
    public String getName() {
        return name;
    }
}