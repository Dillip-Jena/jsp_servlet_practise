package in.app1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        Cookie[] cookies = req.getCookies();
        String userName = null;

        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals("user_name")){
                    userName = c.getValue();
                    break;
                }
            }
        }

        PrintWriter out = res.getWriter();
        out.println("""
                        <html>
                            <head>
                                <title>Page-1</title>
                                <style>
                                    body{
                                        font-family: Arial, Helvetica, sans-serif;
                                    }
                                </style>
                            </head>
                            <body>
                """);

        if(userName != null){
            out.printf("""
                                <h3>Welcome back, %s !</h3>
                                <p>Cookie value read successfully from browser.</p>
                    """, userName);
        }
        else{
            out.println("""
                                <h3>Hello, Guest !</h3>
                                <p>No cookie found. Please <a href="/login2">Login again</a>.</p>
                    """);
        }

        out.println("""
                            </body>
                        </html>
                """);
    }
}
