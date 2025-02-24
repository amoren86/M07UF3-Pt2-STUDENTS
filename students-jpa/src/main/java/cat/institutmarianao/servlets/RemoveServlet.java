package cat.institutmarianao.servlets;

import java.io.IOException;

import cat.institutmarianao.model.Student;
import cat.institutmarianao.services.StudentService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet(urlPatterns = "/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private StudentService studentService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dni = request.getParameter("dni");
		Student student = new Student();
		student.setDni(dni);
		studentService.remove(student);
		response.sendRedirect("students");
	}

}
