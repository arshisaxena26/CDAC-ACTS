package com.app.dao;

import java.util.List;

import com.app.pojos.BankAccount;
import com.app.pojos.Vendor;

public interface IVendorDao {
	List<Vendor> getVendorList();

	String deleteVendor(int vendorId);

	String addNewVendor(Vendor vendor);

	List<BankAccount> getVendorBankAccounts(int vendorId);

	String addVendorBankAccount(int vendorId, BankAccount account);

	String updateVendorDetails(Vendor v, int vendorId);
}
