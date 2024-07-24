package Controller;

import java.io.IOException;

import Dao.StudentDao;
import Dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editstudent")
public class EditStudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	StudentDao dao  =new StudentDao();
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  try {
          long id = Long.parseLong(req.getParameter("id"));
          Student student = dao.getStudentById(id);
          req.setAttribute("student", student);
          req.getRequestDispatcher("edit.jsp").forward(req, resp);
      } catch (NumberFormatException e) {
          resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID.");
      } catch (Exception e) {
          resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving student.");
      }
  }
	

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	 try {
         long id = Long.parseLong(req.getParameter("id"));
         Student updatedStudent = new Student();
         updatedStudent.setId(id);
         updatedStudent.setName(req.getParameter("name"));
         updatedStudent.setDob(req.getParameter("dob"));
         updatedStudent.setStd(req.getParameter("std"));

         dao.updateStudent((int) id, updatedStudent);

         resp.sendRedirect("index.jsp");
     } catch (NumberFormatException e) {
         resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID.");
     } catch (Exception e) {
         resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating student.");
     }
 }	
}
