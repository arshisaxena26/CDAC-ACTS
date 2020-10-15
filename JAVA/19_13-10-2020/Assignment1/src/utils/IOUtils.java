package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import core.HireNewEmployee;

public class IOUtils {
	
	public static void storeEmployeeDetails(Map<String, HireNewEmployee> empMap,String filename) throws IOException{
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename))){
			for(HireNewEmployee e : empMap.values())
				pw.println(e);
			System.out.println("Information exported to file.\nGOODBYE!");
		}
	}
}
