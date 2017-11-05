import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DriverDTO;
import dto.RouteDTO;
import dto.VehicleDTO;

@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RouteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String queryParam = request.getParameter("create");
		String responseJsp = "routelist.jsp";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/project", "root", "root");

			System.out.println(queryParam+">>>>>>>>>>>");
			if (queryParam != null && queryParam.equals("true")) {

				responseJsp = "route.jsp";

				PreparedStatement ps = con
						.prepareStatement("select * from vehicle");
				ResultSet rs = ps.executeQuery();
				List<VehicleDTO> v = new ArrayList<VehicleDTO>();
				while (rs.next()) {
					VehicleDTO vd = new VehicleDTO();
					vd.setVid(rs.getString("vid"));
					vd.setVehicle_no(rs.getString("vehicle_no"));
					vd.setModel(rs.getString("model"));
					vd.setType(rs.getString("type"));
					vd.setCompany(rs.getString("company"));
					vd.setInsurance_details(rs.getString("insurance_details"));

					v.add(vd);

				}
				request.setAttribute("vehicleList", v);
				System.out.println(v.size()+"++++++++++++++");
			    rs = ps.executeQuery("select * from driver");
			    List<DriverDTO> d = new ArrayList<DriverDTO>();
			    while(rs.next()){
					DriverDTO dr= new DriverDTO();
					dr.setDid(rs.getString("did"));
					dr.setName(rs.getString("name"));					
					d.add(dr);
										
				}
			    System.out.println("hai");
			    request.setAttribute("driverList", d);
				System.out.println(d.size()+"++++++++++++++");
			 
			
				
			} else {

				PreparedStatement ps = con
						.prepareStatement("select * from route");
				List<RouteDTO> r = new ArrayList<RouteDTO>();

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					RouteDTO rd = new RouteDTO();
					rd.setRid(rs.getString("rid"));
					rd.setVehicle_id(rs.getString("vehicle_id"));
					rd.setDriver_id(rs.getString("driver_id"));
					rd.setD_o_j(rs.getString("d_o_j"));
					rd.setE_j(rs.getString("e_j"));
					rd.setA_j_d(rs.getString("a_j_d"));
					rd.setRoute_details(rs.getString("route_details"));
					rd.setSource(rs.getString("source"));
					rd.setDestination(rs.getString("destination"));

					r.add(rd);

				}
				request.setAttribute("list", r);

				System.out.println(r.size());

			}
			RequestDispatcher rd = request
					.getRequestDispatcher(responseJsp);
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String vd = request.getParameter("vd");
		String dd = request.getParameter("dd");
		String d_o_j = request.getParameter("d_o_j");
		String e_j = request.getParameter("e_j");
		String a_j_d = request.getParameter("a_j_d");
		String rod = request.getParameter("rod");
		String s = request.getParameter("s");
		String de = request.getParameter("de");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/project", "root", "root");
			System.out.println("connected");
			PreparedStatement ps = con
					.prepareStatement("insert into route (vehicle_id,driver_id, d_o_j, e_j, a_j_d, route_details, source, destination) values(?,?,?,?,?,?,?,?)");

			ps.setString(1, vd);
			ps.setString(2, dd);
			ps.setString(3, d_o_j);
			ps.setString(4, e_j);
			ps.setString(5, a_j_d);
			ps.setString(6, rod);
			ps.setString(7, s);
			ps.setString(8, de);

			ps.executeUpdate();

			RequestDispatcher rd = request
					.getRequestDispatcher("routeSuccess.jsp");
			rd.forward(request, response);

		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();

	}

}
