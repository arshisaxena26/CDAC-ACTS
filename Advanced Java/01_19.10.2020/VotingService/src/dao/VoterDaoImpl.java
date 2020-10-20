package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Voter;
import static utils.DBUtils.fetchDBConnection;

public class VoterDaoImpl implements IVoterDao {
	private Connection conn;
	private PreparedStatement pst1;

	public VoterDaoImpl() throws ClassNotFoundException, SQLException {
		conn = fetchDBConnection();
		pst1 = conn.prepareStatement("select * from voters where email=? and password=?");
	}

	@Override
	public Voter authenticateVoter(String email, String pwd) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, pwd);

		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voter(rst.getInt(1), rst.getString(2), email, pwd, rst.getInt(5), rst.getString(6));
		}
		return null;
	}

	public void cleanup() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (conn != null)
			conn.close();
	}
}
