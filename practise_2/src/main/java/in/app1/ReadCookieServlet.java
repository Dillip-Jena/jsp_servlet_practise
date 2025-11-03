package in.app1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "readCookieServlet", urlPatterns = {"/readcookie"})
public class ReadCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("""
                    <html>
                        <head>
                            <title>After set cookie</title>
                            <style>
                                body{
                                    font-family: Arial, Helvetica, sans-serif;
                                }
                            </style>
                        </head>
                        <body>
                            <h3>Reading Cookies</h3>
                """);

        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                out.printf("<p><b>%s</b> = %s</p>", cookie.getName(), cookie.getValue());
            }
            out.println("""
                        <form action="deletecookie" method="post">
                            <button type="submit">Delete Cookies</button>
                        </form>
                    """);
        }else{
            out.println("<p>No cookie found!</p>");
        }

        out.println("""
                        </body>
                    </html>
                """);
        out.flush();
    }
}
