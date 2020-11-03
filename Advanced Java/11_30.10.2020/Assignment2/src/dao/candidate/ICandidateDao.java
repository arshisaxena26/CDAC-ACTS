package dao.candidate;

import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {

	List<Candidate> getAllCandidates();

	String updateCandidateVotes(int candidateID);

	List<Candidate> displayTopCandidates();

	List<Candidate> displayPartyVotes();
}
