package dao.candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchDBConnection;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {
	private Connection conn;
	private PreparedStatement pst1, pst2;

	public CandidateDaoImpl() throws ClassNotFoundException, SQLException {
		conn = fetchDBConnection();
		pst1 = conn.prepareStatement("select name,party from candidates");
		pst2 = conn.prepareStatement("update candidates set votes=votes+1 where id=?");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();

		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getString(1), rst.getString(2)));
		}
		return candidates;
	}

	@Override
	public String updateCandidateVotes(int candidateID) throws SQLException {
		pst2.setInt(1, candidateID);
		int update = pst2.executeUpdate();
		if (update == 1)
			return "Table Updated.";
		return "Table Updation Failed.";
	}

	public void cleanup() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (conn != null)
			conn.close();
	}
}
