import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class registration1
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub1
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("un");
		String p = request.getParameter("pwd");
		String f = request.getParameter("firstname");
		String l = request.getParameter("lastname");
		int a = Integer.parseInt(request.getParameter("age"));
		String m1 = request.getParameter("mail");
		String m2 = request.getParameter("mail1");
		String g = request.getParameter("gender");
		
		String aa_no = request.getParameter("aadharno");
		String cont_no = request.getParameter("mobile");
		String add= request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","root");
	    PreparedStatement pstm=con.prepareStatement("insert into customer_reg values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
	    pstm.setString(1,un);
	    pstm.setString(2,p);
	    pstm.setString(3,f);
	    pstm.setString(4,l);
	    pstm.setInt(5,a);
	    pstm.setString(6,m1);
	    pstm.setString(7,m2);
	    pstm.setString(8,g);
	    pstm.setString(9,aa_no);
	    pstm.setString(10,cont_no);
	    pstm.setString(11,add);
	    pstm.setString(12,city);
	    pstm.setString(13,state);
	    
	    pstm.executeUpdate();
	    out.println("registration completed successfully .....");
	    rd = request.getRequestDispatcher("login.html");
	    rd.forward(request, response);
		}
	    catch(Exception e)
			{
	    	e.printStackTrace();
				System.out.println(e);
			}
	

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}