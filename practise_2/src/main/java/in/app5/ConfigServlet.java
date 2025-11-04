package in.app5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        //Get ServletContext
        ServletContext context = getServletContext();
        String dbURL = context.getInitParameter("dbURL");

        //Get ServletConfig
        ServletConfig config = getServletConfig();
        String adminEmail = config.getInitParameter("adminEmail");

        PrintWriter out = res.getWriter();
        out.printf("""
                        <html>
                            <head>
                                <title>Page-1</title>
                                <style>
                                    body{
                                        font-family: Arial, Helvetica, sans-serif;
                                    }
                                    hr{
                                        margin-bottom: 20px;
                                    }
                                </style>
                            </head>
                            <body>
                                <h3>ServletContext vs ServletConfig Example !</h3>
                                <hr>
                                <h4>ServletContext (share data for all servlet)</h4>
                                <h4>Database URL: %s</h4>
                                <br>
                                <h4>ServletConfig (specific to this servlet)</h4>
                                <h4>Admin email: %s</h4>
                            </body>
                        </html>
                """, dbURL, adminEmail);
        out.flush();
    }
}
