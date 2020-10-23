package dao.voter;

import java.sql.SQLException;

import pojos.Voter;

public interface IVoterDao {
	Voter authenticateVoter(String email, String pwd) throws SQLException;

	String updateVoterStatus(int voterID) throws SQLException;
}
