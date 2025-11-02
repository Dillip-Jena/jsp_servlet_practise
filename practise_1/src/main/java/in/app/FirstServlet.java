package in.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "firstServlet", urlPatterns = {"/first"})
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");

        String action = req.getParameter("action");

        PrintWriter out = res.getWriter();

        out.println("""
                    <html>
                        <head>
                            <style>
                                p{
                                    color: red;
                                }
                            </style>
                        </head>
                        <body>
                            <h2>First Servlet</h2>
                            <p>This is first servlet content</p>
                """);
        
        //Create an instance of requestDispatcher
        RequestDispatcher rd = req.getRequestDispatcher("second");

        if("forward".equalsIgnoreCase(action)){
            System.out.println("[forward(req) to second servelt]");
            rd.forward(req, res);
            return;
        }else if("include".equalsIgnoreCase(action)){
            System.out.println("[include(res) form the second servlet]");
            rd.include(req, res);
        }else{
            out.println("<p>Use ?action=forward or ?action=include in URL.</p>");
        }

        out.println("""
                        </body>
                    </html>
        """);
        out.flush();
    }
}
