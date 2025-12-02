public class NewsSubscriptionDemo {
    public static void main(String[] args) {
        //news agency
        NewsAgency cnn = new NewsAgency("CNN News");
        
        // subscribers
        Subscriber sean = new Subscriber("Sean");
        Subscriber mikael = new Subscriber("Mikael");
        Subscriber tricia = new Subscriber("Tricia");
        
        //subscribe to news service
        System.out.println("Subscribing Users");
        cnn.subscribe(sean);
        cnn.subscribe(mikael);
        cnn.subscribe(tricia);
        
        //all subscribers receive all news 
        cnn.publishNews("Technology", "New AI breakthrough announced");
        cnn.publishNews("Sports", "Championship game tonight");
        
        //personalized subscriptions
        System.out.println("\nModifying Preferences (Personalization)");
        sean.addCategoryInterest("Technology");
        sean.addCategoryInterest("Business");
        
        mikael.addCategoryInterest("Sports");
        mikael.addCategoryInterest("Entertainment");
    
    
        System.out.println("\nPublishing Categorized News");
        cnn.publishNews("Technology", "Stock market reaches all-time high");
        cnn.publishNews("Sports", "Local team wins championship");
        cnn.publishNews("Business", "Major merger announced");
        cnn.publishNews("Entertainment", "New movie breaks box office records");
        
        //preference modification
        System.out.println("\nDynamic Preference Updates");
        mikael.removeCategoryInterest("Sports");
        mikael.addCategoryInterest("Technology");
        
        cnn.publishNews("Sports", "Olympics begin next week");
        cnn.publishNews("Technology", "Quantum computing milestone achieved");
        
        System.out.println("\nNotification Preferences");
        tricia.setNotifications(false);
        
        cnn.publishNews("Business", "Economic forecast released");
        
        tricia.setNotifications(true);
        cnn.publishNews("Technology", "Space mission successful");
        
        //unsubscribe
        System.out.println("\nDynamic Unsubscribe");
        cnn.unsubscribe(mikael);
        
        cnn.publishNews("Entertainment", "Awards ceremony tonight");
        
        //new subscriber with immediate preferences
        System.out.println("\nNew Subscriber with Preferences");
        Subscriber bomi = new Subscriber("Bomi");
        bomi.addCategoryInterest("Business");
        bomi.addCategoryInterest("Technology");
        cnn.subscribe(bomi);
        
        cnn.publishNews("Business", "New trade agreement signed");
        cnn.publishNews("Weather", "Storm warning issued");
        
    }
}