package in.app8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filedownloadservlet8")
public class FileDownloadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("""
                        <html>
                            <head>
                                <title>Page - 2</title>
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
                                <h3>File download example!</h3>
                                <hr>
                                <form action="filedownloadservlet8" method="post">
                                    <label for="file">Input file name: </label>
                                    <input type="text" name="file" id="file">
                                    <button type="submit">Download File</button>
                                </form>
                            </body>
                        </html>
                """);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        //get the parameter
        String fileName = req.getParameter("file");
        if(fileName == null || fileName.isEmpty()){
            res.getWriter().println("File name is missing");
            return;
        }

        String filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR + File.separator + fileName;
        File file = new File(filePath);

        if(!file.exists()){
            res.getWriter().println("File not found!");
            return;
        }

        //set the response header
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        //stream file content
        FileInputStream in = new FileInputStream(file);
        OutputStream out = res.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while((bytesRead = in.read(buffer)) != -1){
            out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.close();
    }
}
