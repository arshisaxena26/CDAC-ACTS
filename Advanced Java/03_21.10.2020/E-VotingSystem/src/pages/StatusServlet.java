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

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	// Method to display Message to Voters who have already Voted -- since
	// Redirection default method is GET
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		Voter voter = (Voter) session.getAttribute("validateVoter");
		if (voter.getStatus() == 1) {
			try (PrintWriter pw = resp.getWriter()) {
				pw.print("<h2>Hello " + voter.getName()
						+ "</h2><br><h3>You Have Already Voted</h3><br><br><h2><a href='login.html'>VISIT AGAIN!</a></h2>");
			}
			session.invalidate();
		}
	}

	@Override
	// Method to display message to Voters who casted their vote -- POST to hide
	// selected Candidate
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			HttpSession session = request.getSession();
			Voter voter = (Voter) session.getAttribute("validateVoter");

			if (voter.getStatus() == 0) {
				VoterDaoImpl voterDao = (VoterDaoImpl) session.getAttribute("VoterDao");
				CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("CandidateDao");

				pw.print("<h2>Hello " + voter.getName()
						+ "</h2><br><h3>Your Vote has been Registered!</h3><br><br><h2><a href='login.html'>VISIT AGAIN!</a></h2>");

				// Getting Selected Candidate Name
				String[] candidateIDs = request.getParameterValues("candidate_name");

				// Changing Candidate Votes Status
				for (String id : candidateIDs)
					// calling CandidateDao's method to update vote count
					System.out.println(candidateDao.updateCandidateVotes(Integer.parseInt(id)));

				// calling VoterDao's method to update Voter's vote status
				System.out.println(voterDao.updateVoterStatus(voter.getVoterID()));
			}
			session.invalidate();

		} catch (Exception e) {
			throw new ServletException("error in doPost" + getClass().getName(), e);
		}
	}

}
