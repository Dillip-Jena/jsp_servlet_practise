package in.app7;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionListener implements HttpSessionListener {
    private static int totalSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent hse){
        totalSessions++;
        System.out.println("Session Created | Total Active Sessions: " + totalSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse){
        totalSessions--;
        System.out.println("Session Destroyed | Total Active Sessions: " + totalSessions);
    }
}
