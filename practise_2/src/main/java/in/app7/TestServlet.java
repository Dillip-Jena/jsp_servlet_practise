package in.app7;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testservlet7")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");

        Integer totalUser = (Integer) getServletContext().getAttribute("totalUser");

        PrintWriter out = res.getWriter();
        out.printf("""
                    <html>
                        <head>
                            <title>Page - 1</title>
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
                            <h3>Test Application Listener</h3>
                            <hr>
                            <p>Total Users (from context): %d</p>
                        </body>
                    </html>
                """, totalUser);
        out.flush();
    }
}
