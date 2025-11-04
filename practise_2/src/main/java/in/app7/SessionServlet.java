package in.app7;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessionservlet7")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");

        //create a new httpsession
        HttpSession session = req.getSession();

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
                                <h3>HttpSession Listener Test!</h3>
                                <hr>
                                <p>Session ID: %s</p>
                                <p>Session is new: %b</p>
                                <p><a href="?invalidate=true">Invalidate the session</a></p>
                            </body>
                        </html>
                """, session.getId(), session.isNew());

        if("true".equals(req.getParameter("invalidate"))){
            session.invalidate();
            out.println("<p>Session invalidated!</p>");
        }
        out.flush();
    }
}
