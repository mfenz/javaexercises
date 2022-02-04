package at.cb.kfzteile.servlet;

import at.cb.kfzteile.model.Dokument;
import at.cb.kfzteile.model.Warengruppe;
import at.cb.kfzteile.service.DokumenteService;
import at.cb.kfzteile.service.WarengruppenService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WarengruppeServlet", value = "/admin/warengruppe")
public class WarengruppeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int warengruppeId = Integer.parseInt(request.getParameter("id"));

        Warengruppe warengruppe = WarengruppenService.getWarengruppeById(warengruppeId).orElseThrow(
                () -> new RuntimeException("Warengruppe nicht gefunden"));

        request.setAttribute("warengruppe", warengruppe);

        getServletContext().getRequestDispatcher("/admin_warengruppe.jsp")
                .forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int warengruppeId = Integer.parseInt(request.getParameter("id"));
        String pfad = request.getParameter("pfad");
        String dateiname = request.getParameter("dateiname");

        Dokument dokument = new Dokument(0, warengruppeId, pfad, dateiname);
        int docId = DokumenteService.createDokumente(dokument);

        response.sendRedirect(String.format("./warengruppe?id=%d", warengruppeId));
        return;
    }
}
