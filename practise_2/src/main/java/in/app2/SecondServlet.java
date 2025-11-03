package in.app2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "secondServlet", urlPatterns = {"/secondservlet2"})
public class SecondServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //get the parameter
        String userName = req.getParameter("hiddenname");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.printf(""" 
                        <html>
                            <head>
                                <title>Page-3</title>
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
                                <h3>Data received in Second Servlet !</h3>
                                <hr>
                                <p>Hello again, <b>%s</b> !</p>
                                <p>Data was passed successfully using a hidden form field.</p>
                            </body>
                        </html>
                """, userName);
        out.flush();
    }
}
