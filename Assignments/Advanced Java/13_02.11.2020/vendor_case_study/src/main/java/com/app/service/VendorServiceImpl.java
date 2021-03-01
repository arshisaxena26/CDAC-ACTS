package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.BankAccount;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Service
@Transactional
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private IVendorDao vendorDao;

	@Override
	public List<Vendor> getVendorList() {
		return vendorDao.getVendorList();
	}

	@Override
	public String deleteVendor(int vendorId) {
		return vendorDao.deleteVendor(vendorId);
	}

	@Override
	public String addNewVendor(Vendor vendor) {
		vendor.setRole(Role.VENDOR);
		vendor.addVendorLocation(vendor.getLocation());

		return vendorDao.addNewVendor(vendor);
	}

	@Override
	public String addVendorBankAccount(int vendorId, BankAccount account) {
		return vendorDao.addVendorBankAccount(vendorId, account);
	}

	@Override
	public List<BankAccount> getVendorBankAccounts(int vendorId) {
		return vendorDao.getVendorBankAccounts(vendorId);
	}

	@Override
	public String updateVendorDetails(Vendor v, int vendorId) {
		return vendorDao.updateVendorDetails(v, vendorId);
	}

}
