package beans;

import java.sql.SQLException;
import java.util.List;

import dao.candidate.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {
	// properties
	private CandidateDaoImpl candidateDao;
	private int candidateId;

	public CandidateBean() throws ClassNotFoundException, SQLException {
		candidateDao = new CandidateDaoImpl();
	}

	// Setters
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	// Business Logic
	public List<Candidate> getCandidateList() throws SQLException {
		return candidateDao.getAllCandidates();
	}

	public void setCandidateVotes() throws SQLException {
		if (candidateId != 0)
			System.out.println(candidateDao.updateCandidateVotes(candidateId));
	}

	public List<Candidate> getTopCandidates() throws SQLException {
		return candidateDao.displayTopCandidates();
	}

	public List<Candidate> getPartyVotes() throws SQLException {
		return candidateDao.displayPartyVotes();
	}

	// cleanup
	public void cleanup() throws SQLException {
		candidateDao.cleanup();
	}
}
