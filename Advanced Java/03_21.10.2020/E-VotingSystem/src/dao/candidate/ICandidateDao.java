package dao.candidate;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {

	List<Candidate> getAllCandidates() throws SQLException;

	String updateCandidateVotes(int candidateID) throws SQLException;

	List<Candidate> displayTopCandidates() throws SQLException;

	List<Candidate> displayPartyVotes() throws SQLException;
}
