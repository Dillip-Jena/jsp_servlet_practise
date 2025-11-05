package in.app8;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/fileuploadservlet8")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,
    maxFileSize = 1024 * 1024 * 10,
    maxRequestSize = 1024 * 1024 * 15
)
public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("""
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
                                <h2>Upload a file Example!</h2>
                                <hr>
                                <form action="fileuploadservlet8" method="post" enctype="multipart/form-data">
                                    <label for="file">Select file: </label>
                                    <input type="file" name="file" id="file">
                                    <button type="submit">Upload File</button>
                                </form>
                            </body>
                        </html>
                """);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        //Get file part
        Part filePart = req.getPart("file");

        //Create a upload directory if not exists
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }

        String fileName = filePart.getSubmittedFileName();

        //save file on server
        filePart.write(uploadPath + File.separator + fileName);

        PrintWriter out = res.getWriter();
        out.printf("""
                        <html>
                            <head>
                                <title>Page - 1</title>
                                <style>
                                    body{
                                        font-family: Arial, Helvetica, sans-serif;
                                    }
                                </style>
                            </head>
                            <body>
                                <h3>File uploaded successfully!</h3>
                                <p>File saved as: %s</p>
                                <p>Location: %s</p>
                            </body>
                        </html>
                """, fileName, uploadPath);
        out.flush();
    }
}
