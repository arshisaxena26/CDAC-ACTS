package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Vendor;

public class VendorDaoImpl implements IVendorDao {

	@Override
	public String registerVendor(Vendor v) {
		String message = "\nVendor Registration Failed.";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(v);
			tx.commit();
			message = "\nVendor Registration Successful.";
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public String unsubscribeVendor(int vendorId) {

		String message = "\nInvalid Vendor ID. Vendor Unsubscription Failed.";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Vendor vendor = null;

		try {
			vendor = session.get(Vendor.class, vendorId);
			if (vendor != null) {
				session.delete(vendor);
				message = "\nVendor Unsubscribed Successfully.";
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public Vendor getVendorDetails(String email, String password) {

		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Vendor vendor = null;
		String jpql = "select v from Vendor v join fetch v.accounts where v.email = :em and v.password = :pass";

		try {
			vendor = session.createQuery(jpql, Vendor.class).setParameter("em", email).setParameter("pass", password)
					.getSingleResult();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return vendor;
	}

}
