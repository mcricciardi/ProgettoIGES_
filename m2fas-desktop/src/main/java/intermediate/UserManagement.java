package intermediate;

import accessdb.ConstantsDB;
import entity.Product;
import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserManagement {
    private Statement st;
    private ResultSet rs;
    public UserManagement(){
        createConnection();
    }
    private void createConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql:///sm";
            Connection con = DriverManager.getConnection(url, ConstantsDB.USER, ConstantsDB.PSW);
            st = con.createStatement();

        } catch(Exception e){

            e.printStackTrace();
        }
    }
    public boolean usernameAccess(String username){
        try {
            rs = st.executeQuery("SELECT username FROM user WHERE username = '"+username+"' ");

            return rs.next();
        }catch (Exception e){
            return false;
        }

    }
    public boolean emailAccess(String email){
        try {
            rs = st.executeQuery("SELECT email FROM user WHERE email = '"+email+"' ");
       //     System.out.println("query: "+rs.next());
            return rs.next();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean passwordAccess(String pws) {
        try {
            rs = st.executeQuery("SELECT password FROM user WHERE password = '"+pws+"' ");
         //   System.out.println("query: "+rs.next());
            return rs.next();
        }catch (Exception e){
            return false;
        }

    }
    public boolean insertUser(User user){
        try {
           int rs = st.executeUpdate("INSERT INTO user(username, email, password, ruolo) " +
                    "VALUES('"+user.getUsername()+"', '"+user.getEmail()+"', '"+user.getPassword()+"', '"+user.getRole()+"')");
            return rs!=0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
