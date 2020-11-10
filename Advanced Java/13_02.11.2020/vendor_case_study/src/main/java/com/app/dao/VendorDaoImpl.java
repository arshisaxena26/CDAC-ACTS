package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.BankAccount;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

	@PersistenceContext
	private EntityManager session;

	@Override
	public List<Vendor> getVendorList() {
		String jpql = "select v from Vendor v where v.role = :role";
		return session.createQuery(jpql, Vendor.class).setParameter("role", Role.VENDOR).getResultList();
	}

	@Override
	public String deleteVendor(int vendorId) {
		String message = "Vendor Deletion Failed.";
		Vendor vendor = session.find(Vendor.class, vendorId);
		if (vendor != null) {
			session.remove(vendor);
			message = "Vendor Deleted Successfully.";
		}
		return message;
	}

	@Override
	public String addNewVendor(Vendor vendor) {
		session.persist(vendor);
		return "New Vendor Added to Database Successfully.";
	}

	@Override
	public String addVendorBankAccount(int vendorId, BankAccount account) {
		String message = "Bank Account Addition Failed.";
		Vendor v = session.find(Vendor.class, vendorId);
		if (v != null) {
			v.addBankAccountToList(account);
			session.persist(v);
			message = "Bank Account Added Successfully.";
		}
		return message;
	}

	@Override
	public List<BankAccount> getVendorBankAccounts(int vendorId) {
		String jpql = "select b from BankAccount b where b.accountHolder.id = :id";
		return session.createQuery(jpql, BankAccount.class).setParameter("id", vendorId).getResultList();
	}

	@Override
	public String updateVendorDetails(Vendor v, int vendorId) {
		String message = "Vendors Table Updation Failed.";
		Vendor vendor = session.find(Vendor.class, vendorId);
		if (vendor != null) {
			vendor.setPhoneNumbers(v.getPhoneNumbers());
			vendor.getLocation().setCity(v.getLocation().getCity());
			session.persist(vendor);
			message = "Vendors Table Updated.";
		}
		return message;
	}

}
