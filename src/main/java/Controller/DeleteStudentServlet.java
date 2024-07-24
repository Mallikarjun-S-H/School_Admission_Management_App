package Controller;

import java.io.IOException;
import Dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	StudentDao dao = new StudentDao();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
            long id = Long.parseLong(req.getParameter("id"));
            dao.deleteStudent(id);
            resp.sendRedirect("index.jsp"); // Redirect to view students page after deletion
        } catch (NumberFormatException e) {
            // Handle invalid ID format
            resp.sendRedirect("error.jsp"); // Redirect to an error page or display an error message
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            resp.sendRedirect("error.jsp"); // Redirect to an error page or display an error message
        }
	}	
}
