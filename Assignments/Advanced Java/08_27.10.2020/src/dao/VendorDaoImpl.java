package dao;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Role;
import pojos.Vendor;

public class VendorDaoImpl implements IVendorDao {

	@Override
	public Vendor authenticate(String email, String pwd) {
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select v from Vendor v where v.email= :em and v.password= :pass";
		Vendor vendor = null;

		try {
			vendor = session.createQuery(jpql, Vendor.class).setParameter("em", email).setParameter("pass", pwd)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return vendor;
	}

	@Override
	public List<Vendor> getSpecificVendors(LocalDate regDate, double amount) {
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Vendor> vendorList = null;
		String jpql = "select v from Vendor v where v.regDate > :date and v.regAmount < :amt and v.role = :rl";

		try {
			vendorList = session.createQuery(jpql, Vendor.class).setParameter("date", regDate)
					.setParameter("amt", amount).setParameter("rl", Role.VENDOR).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return vendorList;
	}

	@Override
	public String offerDiscount(LocalDate regDate, double amount) {
		String message = "Discounts NOT Applied.";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select v from Vendor v where v.role= :rl and v.regDate < :date";

		try {
			session.createQuery(jpql, Vendor.class).setParameter("rl", Role.VENDOR).setParameter("date", regDate)
					.getResultList().forEach(i -> i.setRegAmount(i.getRegAmount() - amount));
			message = "Discounts Applied Successfully.";
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

}
