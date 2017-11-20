package class;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
*/
public class Jdbc {

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    LocalDate ls = LocalDate.now();
    //String query = null;

    public Jdbc(String query) {
        //this.query = query; 
    }

    public Jdbc() {
        //throw new UnsupportedOperationException("Not currently supported.");
    }

    public void connect(Connection con) {
        connection = con;
    }

    private ArrayList rsToList() throws SQLException {
        ArrayList aList = new ArrayList();

        int cols = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            String[] s = new String[cols];
            for (int i = 1; i <= cols; i++) {
                s[i - 1] = rs.getString(i);
            }
            aList.add(s);
        } // while    
        return aList;
    } //rsToList

    private String makeTable(ArrayList list) {
        StringBuilder b = new StringBuilder();
        String[] row;
        b.append("<table border=\"3\">");
        for (Object s : list) {
            b.append("<tr>");
            row = (String[]) s;
            for (String row1 : row) {
                b.append("<td>");
                b.append(row1);
                b.append("</td>");
            }
            b.append("</tr>\n");
        } // for
        b.append("</table>");
        return b.toString();
    }//makeHtmlTable
   private void select(String query) {
        //Statement statement = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //statement.close();
        } catch (SQLException e) {
            System.out.println("way way" + e);
            //results = e.toString();
        }
    }

    public String retrieve(String query) throws SQLException {
        String results = "";
        select(query);
        return makeTable(rsToList());//results;
    }

    public boolean exists(String user) {
        boolean bool = false;
        try {
            select("select username from users where username='" + user + "'");
            if (rs.next()) {
                System.out.println("TRUE");
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }

    public void insertNewClaim(String[] str) {

        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement("INSERT INTO claims (id, mem_id, date, rationale, status, amount) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(2, str[0]);
            ps.setDate(3, java.sql.Date.valueOf(ls));
            ps.setString(4, str[1]);
            ps.setString(5, "SUBMITED");
            ps.setFloat(6, Float.valueOf(str[3]));
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
