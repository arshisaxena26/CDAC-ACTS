package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.candidate.CandidateDaoImpl;
import pojos.Candidate;

@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			// Requesting sessionID from Web Container
			HttpSession session = request.getSession();

			CandidateDaoImpl candidate = (CandidateDaoImpl) session.getAttribute("CandidateDao");

			List<Candidate> candidateList = new ArrayList<>();

			// calling CandidateDao's method
			candidateList = candidate.getAllCandidates();

			// Dynamic HTML generation
			pw.print("<form action=status method=post>");
			pw.print("<table><tr><td></td><td>Candidate Name</td><td>Party</td></tr>");

			for (Candidate c : candidateList)
				pw.print("<tr><td><input type='radio' name='candidate_name' value='" + c.getCandidateID()
						+ "'></td><td>" + c.getName() + "</td><td>" + c.getParty() + "</td></tr>");
			pw.print("</table>");
			pw.print("<input type='submit' value='Vote'></form>");

		} catch (SQLException e) {
			throw new ServletException("error in doGet of" + getClass().getName(), e);
		}
	}

}
