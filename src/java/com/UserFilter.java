package com;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    /**
     *
     * @param request
     * @param response
     * @param status
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(HttpServletRequest request, HttpServletResponse response, String status)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        Jdbc jdbc = new Jdbc();
        jdbc.connect((Connection) request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", jdbc);

       

       
        if (status.equals("ADMIN")) {
           request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        } else {
          request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
        }

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
