package dao;

import pojos.Vendor;

public interface IVendorDao {
	String registerVendor(Vendor v);

	Vendor getVendorDetails(String email);
}
