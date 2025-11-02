package in.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "httpServlet", urlPatterns = {"/httpDemo"})
public class HttpDemoServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{
        System.out.println("[init()] HttpServlet initialized.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        System.out.println("[doGet()] GET request received.");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("""
                <html>
                    <head>
                        <title>Page-1</title>
                        <style>
                            body {
                                font-family: Arial, Helvetica, sans-serif;
                            }
                            form{
                                background-color: #ffffff;
                                padding: 25px 35px;
                                border-radius: 8px;
                                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                                width: 320px;
                            }
                            h3{
                                text-align: center;
                                color: #333;
                                margin-bottom: 10px;
                            }
                            hr{
                                margin-bottom: 20px;
                                border: none;
                                height: 1px;
                                background-color: #ddd;
                            }
                            label{
                                display: block;
                                margin-top: 10px;
                                font-weight: bold;
                                color: #555;
                            }
                            input{
                                width: 100%;
                                padding: 8px 10px;
                                margin-top: 5px;
                                border: 1px solid #ccc;
                                border-radius: 4px;
                                box-sizing: border-box;
                            }
                            button{
                                margin-top: 15px;
                                width: 100%;
                                padding: 10px;
                                background-color: #007bff;
                                color: white;
                                border: none;
                                border-radius: 4px;
                                cursor: pointer;
                                font-size: 15px;
                            }
                            button:hover{
                                background-color: #0056b3;
                            }
                        </style>
                    </head>
                    <body>
                        <form method="post" action="httpDemo">
                            <h3>Get Request Example</h3>
                            <hr>

                            <label for="name">Enter your name: </label>
                            <input id="name" name="name" type="text">
                            
                            <label for="company">Enter organisation: </label>
                            <input id="company" name="company" type="text">
                            
                            <label for="salary">Enter salary: </label>
                            <input id="salary" name="salary" type="number">
                            
                            <button type="submit">Submit</button>
                        </form>
                    </body>
                </html>
                """);

        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        System.out.println("[doPost()] POST request received.");
        res.setContentType("text/html");

        //get the parameter
        String name = req.getParameter("name");
        String company= req.getParameter("company");
        double salary = Double.parseDouble(req.getParameter("salary"));

        PrintWriter out = res.getWriter();

        out.printf("""
                <html>
                    <head>
                        <title>Page-2</title>
                        <style>
                            .container{
                                background-color: #ffffff;
                                padding: 30px 40px;
                                border-radius: 8px;
                                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                                width: 340px;
                                text-align: center;
                            }
                            h2{
                                color: #333;
                                margin-bottom: 15px;
                            }
                            p{
                                margin: 8px 0;
                                font-size: 15px;
                                color: #555;
                            }
                            span{
                                font-weight: bold;
                                color: #222;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <h3>Form Submitted Successfully!</h3>
                            <hr>
                            <p><b>Name: </b><span>%s</span></p>
                            <p><b>Organisation: </b><span>%s</span></p>
                            <p><b>Salary: </b><span>%s</span></p>
                        </div>
                    </body>
                </html>
                """,name,company,salary);

        out.flush();
    }

    @Override
    public void destroy(){
        System.out.println("[destroy()] Destroying the servlet.");
    }
}
