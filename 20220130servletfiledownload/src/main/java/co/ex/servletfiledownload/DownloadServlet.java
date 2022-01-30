package co.ex.servletfiledownload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileDir = "/tmp/";
        String fileName = "text.txt";
        File downloadFile = new File(fileDir, fileName);
        try (FileInputStream fis = new FileInputStream(downloadFile)) {

            // if you want to use a relative path to context root
            String relativePath = getServletContext().getRealPath("");
            System.out.printf("relativePath=%s%n", relativePath);

            // get MIME type of the file
            String mimeType = getServletContext().getMimeType(downloadFile.getAbsolutePath());
            if (mimeType == null) {
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
            System.out.printf("MIME type: %s%n", mimeType);

            // modifies response
            response.setContentType(mimeType);
            response.setContentLength((int)downloadFile.length());

            // forces download
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);

            // obtains response's output stream
            OutputStream outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = fis.read(buffer)) != -1){
                outStream.write(buffer, 0, bytesRead);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
