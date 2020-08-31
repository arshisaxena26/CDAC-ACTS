package com.app.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.app.core.Customer;

public class IOUtils {

	// Storing Required Details to File
	public static void storeNameAndPhone(Map<String, Customer> map, String fileName) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			for (Customer c : map.values()) {
				if (c.computeAgeInYears() > 55 && c.getCustType().name().equals("GOLD"))
					pw.println("\nName" + c.getName() + "\nPhone Numbers" + c.getCustShippingAddr().getPhoneNumbers());
			}
		}
	}

	// Storing Required Details to File
	public static void storeSortedRegAmt(List<Map.Entry<String, Customer>> list, String fileName) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			for (Entry<String, Customer> c : list) {
				pw.println(c);
			}
		}
	}
}
