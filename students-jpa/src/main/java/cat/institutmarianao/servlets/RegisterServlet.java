package cat.institutmarianao.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cat.institutmarianao.model.Student;
import cat.institutmarianao.services.ModuleService;
import cat.institutmarianao.services.StudentService;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ModuleService moduleService;

	@EJB
	private StudentService studentService;

	@Resource
	private Validator validator;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cycle = request.getParameter("cycle");
		request.setAttribute("cycle", cycle);
		request.setAttribute("modules", moduleService.findAllByCycleCode(cycle));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			Student student = new Student();

			populate(student, request);

			Map<String, String> errors = new HashMap<>();
			for (ConstraintViolation<Student> c : validator.validate(student)) {
				errors.put(c.getPropertyPath().toString(), c.getMessage());
			}
			if (studentService.findByPk(request.getParameter("dni")) != null) {
				errors.put("dni", "User already exists");
			}
			if (!errors.isEmpty()) {
				request.setAttribute("errors", errors);
				request.setAttribute("student", student);
				doGet(request, response);
			} else {
				studentService.add(student);
				response.sendRedirect("students");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServletException(e);
		}
	}

	private void populate(Student student, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {

		student.setDni(request.getParameter("dni"));
		student.setName(request.getParameter("name"));
		student.setSurname(request.getParameter("surname"));
		student.setEmail(request.getParameter("email"));

		String cycle = request.getParameter("cycle");

		if (request.getParameterValues("modules") != null) {
			for (String moduleCode : request.getParameterValues("modules")) {
				student.getModules().add(moduleService.findByPk(moduleCode, cycle));
			}
		}
	}
}
