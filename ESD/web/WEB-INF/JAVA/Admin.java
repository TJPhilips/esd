package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

public class Admin extends HttpServlet {

    /*
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
        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");

        Jdbc dbBean = new Jdbc();
        dbBean.connect((Connection) request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", dbBean);

        
        String msg;
        if (request.getParameter("members") != null) {
            try {              
                msg = dbBean.retrieve("select * from members");
                request.setAttribute("msg", msg);

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("title", "List of all current members");
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }
        if (request.getParameter("applications") != null) {
            
             try {
                
                msg = dbBean.retrieve("select id, name from members where status='APPLIED'");
                request.setAttribute("msg", msg);

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("title", "List of all current applications");
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }
    }
    /*
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
    /*
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
    /*
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
