package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.candidate.CandidateDaoImpl;
import pojos.Candidate;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("CandidateDao");

			// Displaying Top Candidates
			pw.print("<h1>Top Candidate(s)</h1><br><table><th><h3>Name</h3></th><th><h3>Votes</h3></th>");
			List<Candidate> topCandidates = candidateDao.displayTopCandidates();
			for (Candidate c : topCandidates)
				pw.print("<tr><td><h3>" + c.getName() + "</h3></td><td><h3>" + c.getVotes() + "</h3></td>");
			pw.print("</table>");

			// Displaying Party Votes
			pw.print("<h1>Political Party Votes</h1><br><table><th><h3>Party</h3></th><th><h3>Votes</h3></th>");
			List<Candidate> partyVotes = candidateDao.displayPartyVotes();
			for (Candidate c : partyVotes)
				pw.print("<tr><td><h3>" + c.getParty() + "</h3></td><td><h3>" + c.getVotes() + "</h3></td>");
			pw.print("</table><br>");

			pw.print("<h2><a href='login.html'>VISIT AGAIN!</a></h2>");

			session.invalidate();

		} catch (Exception e) {
			throw new ServletException("error in doGet of" + getClass().getName(), e);
		}

	}
}
