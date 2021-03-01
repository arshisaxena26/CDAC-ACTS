package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import core.VolunteerInformation;

public class IOUtils {

	// Serialization
	public static void storeVolunteerInfo(ArrayList<VolunteerInformation> vList, String filename)
			throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(vList);
		}
		System.out.println("Information Exported to File.\nGOODBYE!");
	}

	// DeSerialization
	@SuppressWarnings("unchecked")
	public static ArrayList<VolunteerInformation> readData(String filename)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		File file = new File(filename);
		if (file.exists() && file.isFile() && file.canRead()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				return (ArrayList<VolunteerInformation>) in.readObject();
			}
		}
		return new ArrayList<>();
	}
}
