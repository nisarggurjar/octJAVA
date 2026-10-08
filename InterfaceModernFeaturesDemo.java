interface NotificationService {
    // 1. Traditional abstract method (mandatory to implement)
    void send(String recipient, String message);

    // 2. Default method: Provides a ready-to-use implementation
    // Implementing classes can use this as-is OR choose to override it.
    default void sendUrgent(String recipient, String message) {
        System.out.println("[HIGH PRIORITY NOTIFICATION]");
        send(recipient, "URGENT: " + message);
    }

    // 3. Static method: Utility method bound to the interface itself
    // Called as NotificationService.isValidEmail(...)
    static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}

class EmailNotificationService implements NotificationService {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("Dispatching Email to <%s>: %s%n", recipient, message);
    }
    // sendUrgent() is automatically inherited without writing code here
}

class SmsNotificationService implements NotificationService {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("Sending SMS to %s: %s%n", recipient, message);
    }

    // Optionally overriding the default method for custom behavior
    @Override
    public void sendUrgent(String recipient, String message) {
        System.out.printf("Triggering Siren API + SMS to %s: %s%n", recipient, message);
    }
}

public class InterfaceModernFeaturesDemo {
    public static void main(String[] args) {
        // Using Interface Static Method
        String testEmail = "engineer@example.com";
        System.out.println("Is valid email?: " + NotificationService.isValidEmail(testEmail));

        // Using Default Method
        NotificationService emailService = new EmailNotificationService();
        emailService.send("user@test.com", "System maintenance scheduled.");
        emailService.sendUrgent("admin@test.com", "Server disk 95% full!");

        // Using Overridden Default Method
        System.out.println();
        NotificationService smsService = new SmsNotificationService();
        smsService.sendUrgent("+1-555-0199", "Power loss detected.");
    }
}