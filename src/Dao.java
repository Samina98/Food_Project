import java.util.*;
import java.sql.*;

public class Dao {
  
  public static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String jdbcUrl =   Credentials.jdbcUrl;
      String username =  Credentials.username;
      String password =  Credentials.password;

      con = DriverManager.getConnection(jdbcUrl, username, password);

    } catch (Exception e) {
      // GlobalError.errStr = e.toString();
      GlobalError.errorStrings.add(e.toString());
      System.out.println(e);     
    }
    return con;
  }

  // ----------------------------------------------------------

  public static int save(Participant p) {
    int status = -1;

    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("insert into register(email,name,password,phone) values (?,?,?,?)");
      ps.setString(1, p.getEmail());
      ps.setString(2, p.getName());
      ps.setString(3, p.getPassword());
      ps.setString(4, p.getPhone());
     

      status = ps.executeUpdate();
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      GlobalError.errorStrings.add(ex.toString());
    }

    return status;
  }
  public static boolean LoginDao1(String e,String p) {
    boolean status = false;

    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("select * from register where email=? and password=?");
      ps.setString(1, e);
      ps.setString(2, p);
     ResultSet rs=ps.executeQuery();
      status = rs.next();
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      GlobalError.errorStrings.add(ex.toString());
    }

    return status;
  }
}
 