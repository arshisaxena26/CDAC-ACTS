package dao.voter;

import pojos.Voter;

public interface IVoterDao {
	Voter authenticateVoter(String email, String pwd);

	String updateVoterStatus(int voterID);
}
