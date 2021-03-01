package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Vendor;

public interface IVendorDao {
	Vendor authenticate(String email, String pwd);

	List<Vendor> getSpecificVendors(LocalDate regDate, double amount);

	String offerDiscount(LocalDate regDate, double amount);
}
