package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Connection con;
	Statement st;
	ResultSet rs;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		try{
		//MySQL Connection
			
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/CarSales";
			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
//		Class.forName("com.mysql.jdbc.Driver").newInstance();
//		String connectionUrl = "jdbc:mysql://localhost:3306/CarSales";
//		String connectionUser = "root";
//		String connectionPassword = "admin";
//		java.sql.Connection con = (Connection) DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		
		
		System.out.println("test");
		st = (Statement) conn.createStatement();
		rs = st.executeQuery("SELECT * FROM manufacturer");
		pw.println("<html>");
		pw.println("<body><h1>Manufacturer Details</h1>");

		pw.println("<table border=1>");
		pw.println("<tr><th>Manufacturer ID</th><th>Manufacturer Name</th></tr>");
		while(rs.next())
		{
		 String id = rs.getString("manufacturerID");
		 String name = rs.getString("manufacturer");
		 pw.println("<tr><td>"+id+"</td><td>"+name+"</td></tr>");
		 }
		pw.println("</body></html>");
		}

		catch(SQLException e)
		{
		pw.println(e);
		}
		catch(Exception e) {
		pw.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
