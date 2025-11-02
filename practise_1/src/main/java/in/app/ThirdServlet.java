package in.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "thirdServlet", urlPatterns = {"/third"})
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("""
                    <html>
                        <head>
                            <title>Page3</title>
                            <style>
                                body{
                                    font-family: Arial, Helvetica, sans-serif;
                                    background-color: #f3f6fa;
                                    margin: 0;
                                    padding: 0;
                                    display: flex;
                                    justify-content: center;
                                    align-items: center;
                                    height: 100vh;
                                }

                                .form-container{
                                    background-color: #fff;
                                    border-radius: 8px;
                                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                                    padding: 30px 40px;
                                    width: 350px;
                                }

                                .form-container h2 {
                                    text-align: center;
                                    color: #333;
                                    margin-bottom: 25px;
                                }

                                label{
                                    display: block;
                                    font-weight: bold;
                                    margin-bottom: 6px;
                                    color: #444;
                                }

                                input[type="text"], input[type="number"], input[type="date"]{
                                    width: 100%;
                                    padding: 8px 10px;
                                    margin-bottom: 15px;
                                    border: 1px solid #ccc;
                                    border-radius: 4px;
                                    font-size: 14px;
                                    box-sizing: border-box;
                                }

                                input[type="text"]:focus, input[type="number"]:focus, input[type="date"]:focus{
                                    border-color: #007BFF;
                                    outline: none;
                                }

                                button{
                                    width: 100%;
                                    background-color: #007BFF;
                                    color: white;
                                    border: none;
                                    padding: 10px 0;
                                    border-radius: 4px;
                                    font-size: 16px;
                                    cursor: pointer;
                                    transition: background-color 0.3s;
                                }

                                button:hover{
                                    background-color: #0056b3;
                                }

                                .form-footer{
                                    text-align: center;
                                    margin-top: 10px;
                                    font-size: 13px;
                                    color: #666;
                                }
                            </style>
                        </head>
                        <body>
                            <div class="form-container">
                                <h2>Employee Form</h2>
                                <form action="third" method="post">
                                    <label for="name">Name: </label>
                                    <input id="name" name="name" type="text">

                                    <label for="org">Organization: </label>
                                    <input type="text" name="org" id="org">

                                    <label for="salary">Salary: </label>
                                    <input type="number" name="salary" id="salary">

                                    <label for="doj">Date of Joining: </label>
                                    <input type="date" name="doj" id="doj">

                                    <button type="submit">Submit</button>
                                </form>

                                <footer>
                                    <div class="form-factor">@2025 Tech Implements</div>
                                </footer>
                            </div>
                        </body>
                    </html>
                """);

        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        //get the parameters from the form
        String name = req.getParameter("name");
        String organisation = req.getParameter("org");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        LocalDate doj = LocalDate.parse(req.getParameter("doj"));

        //set the attribute to send it to other servlet
        req.setAttribute("user_name", name);
        req.setAttribute("user_company", organisation);
        req.setAttribute("user_salary", salary);
        req.setAttribute("user_doj", doj);

        //create an instance of request dispatcher
        RequestDispatcher rd = req.getRequestDispatcher("fourth");
        rd.forward(req, res);
    }
}
