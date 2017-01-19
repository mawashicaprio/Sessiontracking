import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class HiddenFormFieldServlet extends HttpServlet
{
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
res.setContentType("text/html");
  
  PrintWriter out = res.getWriter();
out.println("<html><body>");
String name=req.getParameter("name");
  String pass=req.getParameter("pass");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s = c.createStatement();
String  s1="select * from emp101  where   name='"+name+"'  and pass='"+pass+"'";
//out.println(s1);
ResultSet rs=s.executeQuery(s1);
if(rs.next())
{

HttpSession se=req.getSession();
String  id=se.getId();

se.setAttribute("name",name);
se.setAttribute("pass",pass);
out.println("User is Valid"+" "+se.isNew());
out.println("<br>");
out.println(id);
out.println("<br>");
out.println("<form   action='demo' method='post'  >");

out.println("<input   type="+"hidden"+"   "   +"name="+"jsessionid"+"   "+"value="+id+"  >");
out.println("<input   type='input' name='uname'>");

out.println("<input   type='submit'  >");
out.println("</form>");
}
else
out.println("User is InValid");
}catch(Exception e){out.println(e);}     

out.println("</body></html>");
	
}

}
//String url=res.encodeURL("demo1");
//out.println("<a  href="+url+">demo</a>");
//out.println("<a  href='demo' >demo</a>");




