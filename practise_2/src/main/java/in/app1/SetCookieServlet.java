package in.app1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "setCookieServlet", urlPatterns = {"/setcookies"})
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("""
                        <html>
                            <head>
                                <title>SetCookie</title>
                                <style>
                                    body{
                                        font-family: Arial, Helvetica, sans-serif;
                                    }
                                </style>
                            </head>
                            <body>
                                <h3>Multiple Cookie example</h3>
                                <hr>
                                <form action="setcookies" method="post">
                                    <label for="username">Enter name: </label>
                                    <input id="username" name="username" type="text">
                                    <br><br>
                                    <label for="color">Enter color: </label>
                                    <input id="color" name="color" type="text">
                                    <br><br>
                                    <button type="submit">Submit</button>
                                </form>
                            </body>
                        </html>
                """);

        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //get the parameters 
        String name = req.getParameter("username");
        String color = req.getParameter("color");

        res.setContentType("text/html");

        //create cookie
        Cookie userCookie = new Cookie("name", name);
        Cookie colorCookie = new Cookie("color", color);

        //set the lifetime (eg 10 minutes)
        userCookie.setMaxAge(60*10);
        colorCookie.setMaxAge(60*10);

        //set the cookie to the response
        res.addCookie(userCookie);
        res.addCookie(colorCookie);

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
                                <h3>Cookies saved successfully !</h3>
                                <hr>
                                <a href="readcookie">View Cookie</a>
                            </body>
                        </html>
                """);
        out.flush();
    }
}
