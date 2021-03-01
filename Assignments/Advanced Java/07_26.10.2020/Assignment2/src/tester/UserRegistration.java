package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

import static utils.HibernateUtils.getSf;
import static java.time.LocalDate.*;

public class UserRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {

			System.out.println(
					"Enter User Name,Email,Password,Confirm Password,Registration Amount, Role, Registration Date(yyyy-mm-dd)");

			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
					Role.valueOf(sc.next().toUpperCase()), parse(sc.next()));

			System.out.println("User Registration Successful. " + new UserDaoImpl().registerUser(user));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
