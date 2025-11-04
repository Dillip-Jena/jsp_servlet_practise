package in.app7;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestMonitorListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre){
        System.out.println("Request started " + sre.getServletRequest().getRemoteAddr());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre){
        System.out.println("Request completed.");
    }
}
