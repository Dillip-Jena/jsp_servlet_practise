package in.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Hello</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f9fafb; text-align: center; margin-top: 100px; }");
        out.println(".msg { display: inline-block; background: #4f46e5; color: white; padding: 20px 30px; border-radius: 8px; }");
        out.println("</style></head><body>");
        out.println("<div class='msg'>Hello, <strong>" + username + "</strong>! Welcome to the Servlet world 🚀</div>");
        out.println("</body></html>");
    }
}
