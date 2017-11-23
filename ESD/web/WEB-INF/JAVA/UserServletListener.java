package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContext;


@WebListener()
public class UserServletListener implements ServletContextListener {

    private Connection conn = null;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String db = sc.getInitParameter("dbname");
        
        try {
            //establish connection between servlet and database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db.trim(), "root", "");
        }
        catch(ClassNotFoundException | SQLException e){
            sc.setAttribute("error", e);
        }
        sc.setAttribute("connection", conn);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try { conn.close(); } catch(SQLException e) {}
    }
}
