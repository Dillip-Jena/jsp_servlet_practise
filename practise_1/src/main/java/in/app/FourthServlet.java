package in.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "fourthServlet", urlPatterns = {"/fourth"})
public class FourthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");

        //retrieve the attributes set by the thirdservlet
        String name = (String) req.getAttribute("user_name");
        String company = (String) req.getAttribute("user_company");
        double salary = (double) req.getAttribute("user_salary");
        LocalDate joinDate = (LocalDate) req.getAttribute("user_doj");

        //Format the date for display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        String formattedDate = joinDate.format(formatter);

        PrintWriter out = res.getWriter();

        out.printf("""
                        <html>
                            <head>
                                <title>page-4</title>
                            </head>
                            <body>
                                <h2>Student Information Received</h2>
                                <hr>
                                <p><b>Name: </b>%s</p>
                                <p><b>Company: </b>%s</p>
                                <p><b>Salary: </b>%.2f</p>
                                <p><b>Date of Joining: </b>%s</p>
                            </body>
                        </html>
                """,name, company, salary, formattedDate);

        out.flush();
    }
}
