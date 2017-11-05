

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DriverDTO;

/**
 * Servlet implementation class DriverServlet
 */
@WebServlet("/DriverServlet")
public class DriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		List<DriverDTO> d= new ArrayList<DriverDTO>();
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 
			System.out.println("connected");
			
			PreparedStatement ps=con.prepareStatement("select * from driver");
		
		 			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				DriverDTO dr= new DriverDTO();
				dr.setDid(rs.getString("did"));
				dr.setName(rs.getString("name"));
				dr.setAddress(rs.getString("address"));
				dr.setMobile(rs.getString("mobile"));
				dr.setId_proof(rs.getString("id_proof"));
				dr.setLic_no(rs.getString("lic_no"));
				dr.setExp_lic_date(rs.getString("exp_lic_date"));
				d.add(dr);
				
				
			}
			request.setAttribute("list", d);
			
			System.out.println(d.size());
			
			RequestDispatcher rd= request.getRequestDispatcher("driverlist.jsp");
			rd.forward(request, response);
		 		
			          
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String did=request.getParameter("did");  
		String name=request.getParameter("name");  
		String address=request.getParameter("address");  
		String mobile=request.getParameter("mobile");
		String id_proof=request.getParameter("id_proof");
		String lic_no=request.getParameter("lic_no");
		String exp_lic_date=request.getParameter("exp_lic_date");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
			System.out.println("connected");
			PreparedStatement ps=con.prepareStatement(  
			"insert into driver (name,address,mobile,id_proof,lic_no,exp_lic_date) values(?,?,?,?,?,?)");  
			
			  
			ps.setString(1,name);  
			ps.setString(2,address);  
			ps.setString(3,mobile);
			ps.setString(4,id_proof);
			ps.setString(5,lic_no);
			ps.setString(6,exp_lic_date);
			ps.executeUpdate();  
						  
			RequestDispatcher rd= request.getRequestDispatcher("driverSuccess.jsp");
			rd.forward(request, response);
			          
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();  
			
					
			
	}
		
	

}
