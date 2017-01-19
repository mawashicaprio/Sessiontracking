import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class UrlSession extends HttpServlet
{
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
    PrintWriter out = res.getWriter();
HttpSession s=req.getSession();
s.setAttribute("name","ducat");
s.setAttribute("pass","india");
out.println("data set in session"+"  "+s.isNew());
String url=res.encodeURL("demo1");
out.println(url);
out.println("<br>");
out.println("<a  href="+url+">demo</a>");
  }
}