package in.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet implements Servlet{
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException{
        this.config = config;
        System.out.println("[init()] Initilize Servlet with config: "+config.getServletName());
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException{
        System.out.println("[service()] Service is handling a request....");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.printf("""
                <html>
                <head>
                    <title>Servlet Page</title>
                </head>
                <body>
                    <h2>Direct Servlet Implementation Example</h2>
                    <p>This servlet implements <b>jakarta.servlet.Servlet</b> directly.</p>
                    <hr>
                    <p><b>Servlet Name: </b>%s</p>
                    <p><b>Init Parameter: </b>%s</p>
                    <p><b>Servlet Info: </b>%s</p>
                </body>
                </html>
                """,config.getServletName(), config.getInitParameter("developerName"), getServletInfo());
        out.flush();
    }

    @Override
    public void destroy(){
        System.out.println("[destroy()] Servlet is being destroyed");
    }

    @Override
    public ServletConfig getServletConfig(){
        System.out.println("[getServletConfig()] Returning config object");
        return config;
    }

    @Override
    public String getServletInfo(){
        return "[getServletInfo()] Demonstrate core servlet interface methods";
    }
}
