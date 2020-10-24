package dao.candidate;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {
	private Connection conn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public CandidateDaoImpl() throws ClassNotFoundException, SQLException {
		conn = fetchDBConnection();
		pst1 = conn.prepareStatement("select name,party from candidates");
		pst2 = conn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3 = conn.prepareStatement("select name,votes from candidates order by votes desc limit 2");
		pst4 = conn.prepareStatement("select party,sum(votes) from candidates group by party order by sum(votes) desc");
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
			return "Candidates Table Updated.";
		return "Candidates Table Updation Failed.";
	}

	@Override
	public List<Candidate> displayTopCandidates() throws SQLException {
		List<Candidate> topCandidates = new ArrayList<>();

		try (ResultSet rst = pst3.executeQuery()) {
			while (rst.next())
				topCandidates.add(new Candidate(rst.getString(1), rst.getInt(2)));

		}
		return topCandidates;
	}

	@Override
	public LinkedHashMap<String, Integer> displayPartyVotes() throws SQLException {

		LinkedHashMap<String, Integer> partyVotes = new LinkedHashMap<>();

		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				partyVotes.putIfAbsent(rst.getString(1), rst.getInt(2));
		}
		return partyVotes;
	}

	public void cleanup() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (conn != null)
			conn.close();
	}
}
