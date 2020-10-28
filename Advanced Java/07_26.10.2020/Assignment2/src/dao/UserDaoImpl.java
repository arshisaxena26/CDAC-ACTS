package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.User;
import static utils.HibernateUtils.getSf;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		Session session = getSf().openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(user);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;

		} finally {
			if (session != null)
				session.close();
		}
		return "UserID: " + user.getUserId();
	}

}
