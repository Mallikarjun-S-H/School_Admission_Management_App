package Controller;

import java.io.IOException;

import Dao.StudentDao;
import Dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class StudentEntryServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentDao dao = new StudentDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String dateofBirth = req.getParameter("dob");
		String Standard = req.getParameter("std");
		
		Student student = new Student(name, dateofBirth, Standard);
		
		try {
            dao.saveStudent(student);
            // Set success message in session
            HttpSession session = req.getSession();
            session.setAttribute("msg", "Successfully Registered!");

            // Redirect to servlet viewstudents
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors appropriately (e.g., show error message to user)
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Registration failed");
        }
	}
}
