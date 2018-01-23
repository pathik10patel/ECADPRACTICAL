

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
/**
 * Servlet implementation class FeddbackServlet
 */
@WebServlet("/FeddbackServlet")
public class FeddbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeddbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String roll=request.getParameter("rollno");
	//	Integer r=Integer.parseInt(roll);
		String sname=request.getParameter("sname");
		String dept=request.getParameter("dept");
		String cat=request.getParameter("cat");
		String message=request.getParameter("message");
		System.out.println(roll+" "+sname+" "+dept+" "+cat+" "+message );
		String sql="insert into feedback(rollno,stuname,dept,category,message) values('"+roll+"','"+sname+"','"+dept+"','"+cat+"','"+message+"')";
		String page="";
	int i;
	try {
		i = Dao.insert(sql);
		if(i!=0)
		{
			page="index.jsp?msg=insert";
		}
		else
		{
			page="index.jsp?msg=error";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		response.sendRedirect(page);
		
	}

}
