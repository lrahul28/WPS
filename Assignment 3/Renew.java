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
 * Servlet implementation class Renew
 */
@WebServlet("/renew")
public class Renew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Renew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String url,dbuser,password;
		url="jdbc:mysql://localhost:3306/db1";
		dbuser="root";
		password="rahul.admin";
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbuser, password);
			int id;
			id=Integer.parseInt(request.getParameter("id"));
			PreparedStatement ps=con.prepareStatement("select * from busdb where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.print("<h1 style='color:Green'>Application Processed For Renewal MR/MRS. "+rs.getString(2)+"<br> Your ID:- "+id+"</h1>");	
					
			}
			else {
				out.print("<h1 style='color:Red'>Application Not Found</h1>");
			}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}

}
