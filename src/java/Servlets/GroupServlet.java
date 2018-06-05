/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Service.GroupInterface;
import Service.GroupService;
import Service.ServiceBean;
import Service.StudInterface;
import entity.Gruppyi;
import entity.Studentyi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class GroupServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        PrintWriter printWriter = null;
        try{
           
           
           GroupInterface gr=new GroupService();
           
           List<Gruppyi> lst=gr.getTable();
           
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Список студентов</title>");            
            out.println("</head>");
            out.println("<body>");
            printWriter= response.getWriter();
            out.println("<table border=3>");
             out.println("<tr><th>Шифр</th>");
             out.println("<th>Название</th>");
             out.println("<th>Дата формирования</th>");
             out.println("<th>Код плана</th></tr>");
             out.println("<tr><td>");
           for(Gruppyi g : lst){
               out.println("<tr><td>");
              printWriter.println(g.getShifr());
              out.println("</td>");
              out.println("<td>");
              printWriter.println(g.getNazvanie());
              out.println("</td>");
              out.println("<td>");
              printWriter.println(g.getDataFormir());
              out.println("</td>");
              out.println("<td>");
              printWriter.println(g.getKodPlana());
              out.println("</td></tr>");
              
           }
           out.println("</table>");
           
           out.println("<form method=\"get\" action=\"Servlet2\">\n" +
"       <table>\n" +
"        <tr>\n" +
"           <td>Введите номер зачетки:</td>\n" +
"           <td><input type=\"text\" name=\"id\"/></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"           \n" +
"           <td><input type=\"submit\" value=\"Delete\"></td>\n" +
"        </tr>\n" +
"       </table>");
           
           out.println("</body>");
            out.println("</html>");
           
        }
            finally{
                    out.close();
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
        processRequest(request, response);
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
