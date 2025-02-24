package cat.institutmarianao.servlets;

import java.io.IOException;

import cat.institutmarianao.services.CycleService;
import cat.institutmarianao.services.StudentService;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentsServlet
 */
@WebServlet(urlPatterns = "/students")
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CycleService cyclesService;

	@EJB
	private StudentService studentService;

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cycles", cyclesService.findAll());
		request.setAttribute("students", studentService.findAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/students.jsp");
		dispatcher.forward(request, response);
	}
}
