/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.cb.kontaktformular.servlet;

import at.cb.kontaktformular.model.Kontaktanfrage;
import at.cb.kontaktformular.service.KontaktformularService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Darstellung einer einzelnen Kontaktanfrage
 * @author mfenz
 */
public class KontaktanfrageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KontaktanfrageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KontaktanfrageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get Parameter "id" auslesen und Kontaktanfrage anhand der ID einlesen
        Optional<Kontaktanfrage> optionalKontaktanfrage = 
                KontaktformularService.getKontaktanfrageById(Integer.parseInt(request.getParameter("id")));
        
        // Wurde die Kontaktanfrage anhand der ID gefunden?
        if(optionalKontaktanfrage.isEmpty()){
            // Kontaktanfrage wurde nicht gefunden, Fehlermeldung als Attribut setzen
            request.setAttribute("error", "Kontaktanfrage wurde nicht gefunden");
        } else {
            // Kontaktanfrage wurde gefunden, diese als Attribut setzen
            request.setAttribute("anfrage", optionalKontaktanfrage.get());
        }
        
        // Zur Ausgabe an JSP weiterleiten
        getServletContext().getRequestDispatcher("/kontaktanfrage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
