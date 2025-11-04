package in.app7;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppLifeCycleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("Application started !");
        ServletContext context = sce.getServletContext();
        context.setAttribute("totalUser", 1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("Application stopped !");
    }
}
