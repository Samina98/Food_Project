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
  public static boolean login(String e,String p) {
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

public static int add(Item p) {
    int status = 0;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("insert into cart(id,name,price) values (?,?,?)");
	  ps.setInt(1,p.getId());
      ps.setString(2, p.getName());
      ps.setInt(3, p.getPrice());
      

      status = ps.executeUpdate();

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }

    return status;
  } 
 
 public static int delete(int id) {
    int status = 0;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("delete from cart where id=?");
      ps.setInt(1, id);
      status = ps.executeUpdate();

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }

    return status;
  }
 
public static int total() {
    int t = 0;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select price from cart");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
		  t=t+ rs.getInt(1);
	  }

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }

    return t;
  }
 
public static Item getItemById(int id) {
    Item p = new Item();

    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from items where id=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setPrice(rs.getInt(3));
        
      }
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      GlobalError.errorStrings.add(ex.toString());
    }

    return p;
  }
  // -----------------------------------------------------------------

  public static List<Item> getAllItem() {
    List<Item> list = new ArrayList<Item>();
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from items");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Item p = new Item();

        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setPrice(rs.getInt(3));
       
        list.add(p);
      }
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }

    return list;
  }
  public static List<Item> getAllCartItem() {
    List<Item> list = new ArrayList<Item>();
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from cart");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Item p = new Item();

        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setPrice(rs.getInt(3));
       
        list.add(p);
      }
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }

    return list;
  }
  
   public static int confirmdelete() {
    int status=0;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("delete from cart ");
      status = ps.executeUpdate();
      
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }
	return status;
    
  }
}
