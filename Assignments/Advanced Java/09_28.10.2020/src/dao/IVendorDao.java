package dao;

import pojos.Vendor;

public interface IVendorDao {
	String registerVendor(Vendor v);

	String unsubscribeVendor(int vendorId);

	Vendor getVendorDetails(String email, String password);
}
