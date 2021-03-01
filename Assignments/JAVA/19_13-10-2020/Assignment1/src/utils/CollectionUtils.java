package utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import core.HireNewEmployee;

public class CollectionUtils {
	
	public static void sortEmployeesByDOB(HashMap<String, HireNewEmployee> empMap, String deptID) {
		
		List<Map.Entry<String, HireNewEmployee>> employeeList = new LinkedList<Map.Entry<String, HireNewEmployee>>(empMap.entrySet());

		Collections.sort(employeeList, new Comparator<Map.Entry<String, HireNewEmployee>>() {

			@Override
			public int compare(Entry<String, HireNewEmployee> e1,
					Entry<String, HireNewEmployee> e2) {

				return e1.getValue().getDob().compareTo(e2.getValue().getDob());
			}
		});

		for (Entry<String, HireNewEmployee> e1 : employeeList) {
			if (e1.getValue().getDeptId().equals(deptID))
				System.out.println(e1);
		}
	}
}
