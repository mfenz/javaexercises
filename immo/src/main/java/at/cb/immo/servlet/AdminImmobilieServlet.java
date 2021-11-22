package at.cb.immo.servlet;

import at.cb.immo.model.Immobilie;
import at.cb.immo.service.ImmobilienService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AdminImmobilieServlet", value = "/admin-immo")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AdminImmobilieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Immobilie laden
        Optional<Immobilie> optionalImmobilie =
                ImmobilienService.getImmobilieById(Integer.parseInt(request.getParameter("id")));
        if(!optionalImmobilie.isPresent()){
            response.getWriter().print("Immobilie nicht gefunden!");
            return;
        }
        Immobilie immo = optionalImmobilie.get();
        // Immobilie als Request Attribute setzen
        request.setAttribute("immo", immo);

        getServletContext().getRequestDispatcher("/admin_immo.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        for (Part part : request.getParts()) {
            part.write("/tmp/"+  fileName);
        }
        response.getWriter().print("The file uploaded successfully.");
    }
}
