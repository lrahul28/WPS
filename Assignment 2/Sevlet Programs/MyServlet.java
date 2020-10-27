package p1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/sapp")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String url,dbuser,password;
		url="jdbc:mysql://localhost:3306/db1";
		dbuser="root";
		password="rahul.admin";
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbuser, password);
			String name,city,type;
			name=request.getParameter("nam");
			city=request.getParameter("city");
			type=request.getParameter("ptype");
			PreparedStatement ps=con.prepareStatement("insert into busdb(name,city,passtype) values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2,city);
			ps.setString(3,type);
			ps.execute();
			ResultSet rs=ps.executeQuery("SELECT MAX(id) FROM busdb");
			rs.next();
			out.print("<h1>Thank You..!!  "+name+"<h2><br>Your id is"+rs.getInt(1)+"</h2>"+"</h1><h1 style='color:Green;'> <br>Your Details have been Submitted  </h1>");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
			
}
	
