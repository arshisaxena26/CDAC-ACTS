package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoterDaoImpl;
import pojos.Voter;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl voterDao;

	@Override
	public void init() throws ServletException {
		try {
			voterDao = new VoterDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in init of" + getClass().getName(), e);
		}
	}

	@Override
	public void destroy() {
		try {
			voterDao.cleanup();
		} catch (Exception e) {
			throw new RuntimeException("error in destroy of" + getClass().getName(), e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			Voter voter = voterDao.authenticateVoter(request.getParameter("email"), request.getParameter("pass"));
			if (voter == null)
				pw.print("<a href='login.html'>RETRY!</a>");
			else {
				pw.print("<h4>" + voter + "</h4><br>");
				pw.print("<h3>Login Successful!!</h3>");
			}

		} catch (Exception e) {
			throw new ServletException("error in doPost of" + getClass().getName(), e);
		}
	}

}
