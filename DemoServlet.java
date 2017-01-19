/*   public   HttpSession   getSession(boolean  b)
if u pass  false  in above  method  then it will  check  existing  or old session   if it is  found  then return  that  session  otherwise  it will   return  null.But it will  newer  create new Session.
getSession()==getSession(true);*/

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class DemoServlet extends HttpServlet
{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {

  res.setContentType("text/html");
    PrintWriter out = res.getWriter();
HttpSession s=req.getSession(false);
if(s!=null)
{
String s1=(String)s.getAttribute("name");
String s2=(String)s.getAttribute("pass");
out.println("<html><body>");
out.println(s1+" = "+s2+"   "+ s.isNew());
out.println("<br>");
out.println("<a  href='log' >Logout</a>");
out.println("</body></html>");
}
else
out.println("bavari pooch login kar le");
}

}





