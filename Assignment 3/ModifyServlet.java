package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
			int id;
			id=Integer.parseInt(request.getParameter("id"));
			name=request.getParameter("nam");
			city=request.getParameter("city");
			type=request.getParameter("ptype");
			PreparedStatement ps=con.prepareStatement("update busdb set name=? ,city=?, passtype=? where id=?");
			ps.setString(1,name);
			ps.setString(2,city);
			ps.setString(3,type);
			ps.setInt(4, id);
			ps.execute();
			out.print("<h1>Thank You..!!  "+name+"(ID:- "+id+")"+"<h1 style='color:Green;'><br>Your Details have been Modified</h1>");	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
			

	}


