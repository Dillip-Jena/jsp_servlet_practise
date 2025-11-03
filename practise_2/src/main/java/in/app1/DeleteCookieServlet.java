package in.app1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "deleteCookieServlet", urlPatterns = {"/deletecookie"})
public class DeleteCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");

        //get the cookie
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }
        }

        PrintWriter out = res.getWriter();
        out.println("""
                        <html>
                            <head>
                                <title>Delete cookie</title>
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
                                <h3>All Cookies deleted successfully!</h3>
                                <hr>
                                <a href="setcookies">Go Back</a>
                            </body>
                        </html>
                """);
        out.flush();
    }
}
