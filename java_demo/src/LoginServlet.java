import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet(name="LoginServlet",urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet {
    Map<String,String> user = null;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("gender");
        String job = request.getParameter("job");
        user.put(username,password+"  "+sex+"  "+job);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("登录成功！欢迎您!<br/>");
        out.println("用户名"+username+"<br/>"+
                    "密码"+password+"<br/>"+
                    "性别"+sex+"<br/>"+
                    "职业"+password+"<br/>"
        );
        out.println("已注册信息<br/>");
        out.println("用户名&nbsp;&nbsp;密码&nbsp;&nbsp;性别&nbsp;&nbsp;职业<br/>");
        Set<String> userkey = user.keySet();
        for(String key : userkey){
            out.println(key+"&nbsp;&nbsp;"+user.get(key));
        }
        out.println("</body></html>");
        out.println("1");
    }

}
