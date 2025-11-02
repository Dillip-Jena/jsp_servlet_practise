package in.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class GenericDemoServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        //Access ServletContext (application-wide)
        String appName = getServletContext().getInitParameter("appName");
        String version = getServletConfig().getInitParameter("version");

        PrintWriter out = res.getWriter();
        out.printf("""
                <html>
                <head>
                    <title>GenericServlet Page</title>
                    <style>
                        body{
                            font-family: Arial, Helvetica, sans-serif;
                        }
                    </style>
                </head>
                <body>
                    <h2>Generic Servlet Example</h2>
                    <hr>
                    <p><b>Web Application Version: </b>%s</p>
                    <p><b>App Name: </b>%s</p>
                </body>
            </html>
                """,version,appName);
        out.flush();
    }

}
