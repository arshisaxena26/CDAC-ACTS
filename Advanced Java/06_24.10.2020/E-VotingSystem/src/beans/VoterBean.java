package beans;

import java.sql.SQLException;

import dao.voter.VoterDaoImpl;
import pojos.Voter;

public class VoterBean {
//properties
	private Voter voter;
	private VoterDaoImpl voterDao;
	private String email, password;
	private String message;

	public VoterBean() throws Exception {
		voterDao = new VoterDaoImpl();
	}

	// Setters
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Getters
	public String getMessage() {
		return message;
	}

	public Voter getVoter() {
		return voter;
	}

	// Business Logic
	public String getAuthenticatedVoter() throws SQLException {
		voter = voterDao.authenticateVoter(email, password);
		if (voter == null) {
			message = "Invalid Credentials. Try Again!";
			return "login";
		}

		if (voter.getRole().equals("admin"))
			return "admin";

		if (voter.getStatus() == 0)
			return "candidate_list";

		return "status"; // Dynamic Navigational Outcome
	}

	public String getVoterStatus() throws SQLException {
		if (voter.getStatus() == 0) {
			System.out.println(voterDao.updateVoterStatus(voter.getVoterID()));
			return "Your Vote has been Registered. Thank You!";
		}
		return "You Have Already Voted.";
	}

}
