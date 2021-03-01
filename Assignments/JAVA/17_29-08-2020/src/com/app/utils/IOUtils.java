package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.app.core.Customer;

public class IOUtils {

	// Serialization
	public static void writeData(HashMap<String, Customer> map, String fileName) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(map);
		}
	}

	// DeSerialization
	@SuppressWarnings("unchecked")
	public static HashMap<String, Customer> readData(String fileName) throws IOException, ClassNotFoundException {
		
		// validate file
		File f1 = new File(fileName);
		if (f1.exists() && f1.isFile() && f1.canRead()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1))) {
				return (HashMap<String, Customer>) in.readObject();
			}
		}
		return new HashMap<>();
	}
}
