import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        int id=Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        int role=Integer.valueOf(request.getParameter("role"));
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        UserDAO userDAO=new UserDAO();
        userDAO.addUser(user);
        System.out.println("注册成功!!!");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}

