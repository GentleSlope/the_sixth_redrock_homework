import java.sql.*;

public class UserDAO {
    public  User  login(String username,String password) {
        User u=null;
        Connection connection =null;
        PreparedStatement pstmt=null;
        ResultSet resultSet=null;

        //赋值
        try {
            connection=JdbcUtils.getConnection();
            //静态sql语句
            String sql = "select * from mlgb.userinfo where name=? and password=?";
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                u=new User();
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                System.out.println("登录成功！");
            }else{
                System.out.println("用户名或者密码错误！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt, connection);
        }
        return u;

    }
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
            connection = JdbcUtils.getConnection();

            String sql  ="insert into mlgb.userInfo(id,name,password,role)values(?,?,?,?);";

            psmt = (PreparedStatement) connection.prepareStatement(sql);
            psmt.setInt(1, user.getId());
            psmt.setString(2, user.getName());
            psmt.setString(3,user.getPassword());
            psmt.setInt(4, user.getRole());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(psmt, connection);
        }
    }
}


