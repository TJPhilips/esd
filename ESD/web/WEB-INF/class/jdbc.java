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
    }//makeHtmlTable - sync again with adam's commits
   private void select(String query) {
        //Statement statement = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //statement closure
        } catch (SQLException e) {
            System.out.println("way way" + e);
        }
    }

    public String retrieve(String query) throws SQLException {
        String results = "";
        select(query);
        return makeTable(rsToList());
    }

    public boolean exists(String user) {
        boolean bool = false;
        try {
            select("select a username from users where username='" + user + "'");
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
   public void insertNewPayment(String[] str) {

        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement("INSERT INTO payments (id, mem_id, type_of_payment, amount, date) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(2, str[0]);
            ps.setString(3, str[1]);
            ps.setFloat(4, Float.valueOf(str[3]));
            ps.setDate(5, java.sql.Date.valueOf(ls));
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertNewUser(String[] str) {

        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {

            ps = connection.prepareStatement("INSERT INTO members(id, name, address, dob, dor, status, balance) VALUES (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[0]);
            ps.setString(2, str[1]);
            ps.setString(3, str[2]);
            ps.setDate(4, java.sql.Date.valueOf(str[3]));
            ps.setDate(5, java.sql.Date.valueOf(ls));
            ps.setString(6, "APPLIED");
            ps.setFloat(7, (float) 0.0);
            ps.executeUpdate();

            ps.close();

            ps2 = connection.prepareStatement("INSERT INTO users(id, password, status) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps2.setString(1, str[0]);
            ps2.setString(2, str[4]);
            ps2.setString(3, "APPLIED");
            ps2.executeUpdate();
            ps2.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean checkUser(String id, String password) {
        boolean st = false;
        try {

            PreparedStatement ps3 = connection.prepareStatement("select * from users where id=? and password=?");
            ps3.setString(1, id);
            ps3.setString(2, password);
            ResultSet rs = ps3.executeQuery();
            st = rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    public void update(String[] str, String table) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("Update users Set password=? where username=?", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[1].trim());
            ps.setString(2, str[0].trim());
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String user) {

        String query = "DELETE FROM Users "
                + "WHERE username = '" + user.trim() + "'";

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("way way" + e);
        }
    }

    public void closeAll() {
        try {
            rs.close();
            statement.close();
            //close connection?                                        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
