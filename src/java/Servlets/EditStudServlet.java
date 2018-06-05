/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import entity.Gruppyi;
import entity.Studentyi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = { "/editStud" })
public class EditStudServlet extends HttpServlet {
    @EJB
           Service.StudInterface db;
    @EJB
           Service.GroupInterface gr;

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
        String nomerZachetki = (String) request.getParameter("id");
        Studentyi stud=db.getStud(Long.valueOf(nomerZachetki));
        List<Gruppyi> lst=null;
        lst=gr.getTable();
        
        
        request.setAttribute("grList", lst);
        request.setAttribute("Stud", stud);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editStudView.jsp");
        dispatcher.forward(request, response);
        
        
       
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
        String NomerZachetki = (String) request.getParameter("NomerZachetki");
        String Imya = (String) request.getParameter("Imya");
        String Familiya = (String) request.getParameter("Familiya");
        String Otchestvo = (String) request.getParameter("Otchestvo");
        String Gorod = (String) request.getParameter("Gorod");
        String ShifrGruppyi = (String) request.getParameter("ShifrGruppyi");
        String Adres = (String) request.getParameter("Adres");
        String Tel = (String) request.getParameter("Tel");
        String Status = (String) request.getParameter("Status");
        
        
        db.update(Long.valueOf(NomerZachetki), Integer.valueOf(ShifrGruppyi), Familiya, Imya, Otchestvo, Gorod, Adres, Tel, Status);
        response.sendRedirect(request.getContextPath() + "/studList");
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
