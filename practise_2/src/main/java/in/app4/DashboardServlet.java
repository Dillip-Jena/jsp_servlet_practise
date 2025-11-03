package in.app4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboardservlet4")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");

        //get the existing session, don't care new one
        HttpSession session = req.getSession(false);

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

        if(session != null){
            String user = (String) session.getAttribute("user");
            if(user != null){
                out.printf("""
                            <h3>Welcome to Dashboard!, %s !</h3>
                            <p>Session ID: %s</p>
                            <a href="logoutservlet4">Logout</a>
                        """, user, session.getId());
            }else{
                out.println("""
                            <h3>No user found in session!</h3>
                            <a href="loginservlet4">Login Again</a>
                        """);
            }
        }else{
            out.println("""
                            <h3>Session expires or not found.</h3>
                            <a href="loginservlet4">Login Again</a>
                    """);
        }

        out.println("""
                            </body>
                        </html>
                """);
        out.flush();
    }
}
