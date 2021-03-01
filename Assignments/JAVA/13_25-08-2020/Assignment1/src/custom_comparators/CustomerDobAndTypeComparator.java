package custom_comparators;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomerDobAndTypeComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer cust1, Customer cust2) {
		int value = cust1.getDate().compareTo(cust2.getDate()); // using LocalDate's compareTo method
		if (value == 0)
			return cust1.getCustType().compareTo(cust2.getCustType()); // using Enum's compareTo method
		return value;
	}

}
