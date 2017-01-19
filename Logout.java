import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Logout extends HttpServlet
{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {

  res.setContentType("text/html");
    PrintWriter out = res.getWriter();
HttpSession s=req.getSession();
//HttpSession s=req.getSession(false);
if(s!=null)
{
s.invalidate();
out.println("<html><body>");

out.println("You have Logout  successfully");
out.println("<br>");
out.println("<a  href='login.html' >Login</a>");
out.println("</body></html>");
}
else
{
out.println("bavari pooch login kar le");
}
}


}





