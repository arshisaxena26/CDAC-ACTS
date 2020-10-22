package dao;

import java.sql.SQLException;

import pojos.Voter;

public interface IVoterDao {
	Voter authenticateVoter(String email,String pwd) throws SQLException;
}
