package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.candidate.CandidateDaoImpl;
import dao.voter.VoterDaoImpl;
import pojos.Voter;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl voterDao;
	private CandidateDaoImpl candidateDao;

	@Override
	public void init() throws ServletException {
		try {
			voterDao = new VoterDaoImpl();
			candidateDao = new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in init of" + getClass().getName(), e);
		}
	}

	@Override
	public void destroy() {
		try {
			voterDao.cleanup();
			candidateDao.cleanup();
		} catch (Exception e) {
			throw new RuntimeException("error in destroy of" + getClass().getName(), e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			// Voter Authentication
			Voter voter = voterDao.authenticateVoter(request.getParameter("email"), request.getParameter("pass"));

			// UnRegistered Voter
			if (voter == null) {
				pw.print("<h2>Invalid Credentials<h2><br>");
				pw.print("<a href='login.html'>RETRY!</a>");
			}

			// Registered Voter
			else {

				// Session Tracking
				HttpSession session = request.getSession();
				session.setAttribute("validateVoter", voter);
				session.setAttribute("VoterDao", voterDao);
				session.setAttribute("CandidateDao", candidateDao);

				// Voter Scenario
				if (voter.getRole().equals("voter")) {

					// Redirecting Voters yet to vote to Candidate List
					if (voter.getStatus() == 0)
						response.sendRedirect("candidate_list");
					// Redirecting Voters to Status Page
					else
						response.sendRedirect("status");
				}
			}

		} catch (Exception e) {
			throw new ServletException("error in doPost of" + getClass().getName(), e);
		}
	}

}
