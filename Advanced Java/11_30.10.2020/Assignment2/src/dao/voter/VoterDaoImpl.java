package dao.voter;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Voter;

public class VoterDaoImpl implements IVoterDao {

	@Override
	public Voter authenticateVoter(String email, String pwd) {
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select v from Voter v where v.email= :em and v.password= :pass";
		Voter voter = null;
		try {
			voter = session.createQuery(jpql, Voter.class).setParameter("em", email).setParameter("pass", pwd)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return voter;
	}

	@Override
	public String updateVoterStatus(int voterID) {
		String message = "Voters Table Updation Failed.";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Voter voter = null;

		try {
			voter = session.get(Voter.class, voterID);
			if (voter != null) {
				voter.setStatus(true);
				message = "Voters Table Updated.";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}
}
