
import java.sql.*;

class JdbcUtils{
    static {



    }
    public static Connection getConnection(){
        Connection con = null;
        try{
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mlgb","root","123456");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Statement statement,Connection con) {
        try{
            if (statement!= null)
                statement.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            if (con!=null)
                con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}