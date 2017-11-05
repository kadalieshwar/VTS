

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
import dto.VehicleDTO;

@WebServlet("/Vehicle")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleServlet() {
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
		List<VehicleDTO> v= new ArrayList<VehicleDTO>();
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 
			System.out.println("connected");
			
			PreparedStatement ps=con.prepareStatement("select * from vehicle");
		
		 			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				VehicleDTO vd= new VehicleDTO();
				vd.setVid(rs.getString("vid"));
				vd.setVehicle_no(rs.getString("vehicle_no"));
				vd.setModel(rs.getString("model"));
				vd.setType(rs.getString("type"));
				vd.setCompany(rs.getString("company"));
				vd.setInsurance_details(rs.getString("insurance_details"));
				
				v.add(vd);
				
				
			}
			request.setAttribute("list", v);
			
			System.out.println(v.size());
			
			RequestDispatcher rd= request.getRequestDispatcher("vehiclelist.jsp");
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
		          
		 
		String vehicle_no=request.getParameter("vehicle_no");  
		String model=request.getParameter("model");  
		String type=request.getParameter("type");
		String company=request.getParameter("company");
		String insurance_details=request.getParameter("insurance_details");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 
			System.out.println("connected");
			PreparedStatement ps=con.prepareStatement(  
			"insert into vehicle (vehicle_no,model, type, company, insurance_details) values(?,?,?,?,?)");  
			  
		 
			ps.setString(1,vehicle_no);  
			ps.setString(2,model);  
			ps.setString(3,type);
			ps.setString(4,company);
			ps.setString(5,insurance_details);
			
			ps.executeUpdate();  
		 
			RequestDispatcher rd= request.getRequestDispatcher("vehicleSuccess.jsp");
			rd.forward(request, response);
			          
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();  
			
	}

}
