package in.app3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "welcomeServlet", urlPatterns = {"/welcome3"})
public class WelcomeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //get the parameter from the url
        String name = req.getParameter("user");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("""
                        <html>
                            <head>
                                <title>Page-3</title>
                                <style>
                                    body{
                                        font-family: Arial, Helvetica, sans-serif;
                                    }
                                </style>
                            </head>
                            <body>
                """);

        if(name != null){
            out.printf("""
                                <h3>Welcome back, %s !</h3>
                                <p>Your name was passed successfully through the URL.</p>
                    """, name);
        }else{
            out.println("""
                                <h3>No user found!</h3>
                                <p>Please go back and enter your name.</p>
                    """);
        }

        out.println("""
                            </body>
                        </html>
                """);
        out.flush();  
    }
}
