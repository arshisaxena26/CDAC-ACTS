package dao.candidate;

import static utils.HibernateUtils.getSf;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	@Override
	public List<Candidate> getAllCandidates() {
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select c from Candidate c";
		List<Candidate> candidates = new ArrayList<>();

		try {
			candidates = session.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return candidates;
	}

	@Override
	public String updateCandidateVotes(int candidateID) {
		String message = "Candidates Table Updation Failed.";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Candidate candidate = null;

		try {
			candidate = session.get(Candidate.class, candidateID);
			if (candidate != null) {
				candidate.setVotes(candidate.getVotes() + 1);
				message = "Candidates Table Updated.";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public List<Candidate> displayTopCandidates() {
		List<Candidate> topCandidates = new ArrayList<>();
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select c from Candidate c order by c.votes desc";

		try {
			topCandidates = session.createQuery(jpql, Candidate.class).setMaxResults(2).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return topCandidates;
	}

	@Override
	public List<Candidate> displayPartyVotes() {
		List<Candidate> partyVotes = new ArrayList<Candidate>();
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select c from Candidate c order by c.votes desc";
		try {
			partyVotes = session.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return partyVotes;
	}

}
