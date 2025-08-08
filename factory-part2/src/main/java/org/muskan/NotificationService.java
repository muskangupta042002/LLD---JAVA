package org.muskan;

public class NotificationService {
    public void sendNotification(String message){
        EmailNotification email = new EmailNotification();
        email.send();
    }
}
