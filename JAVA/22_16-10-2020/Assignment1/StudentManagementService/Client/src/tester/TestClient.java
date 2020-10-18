// Import Student.jar for core Classes

package tester;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) {
		System.out.println("Enter hostname and port");

		try (Scanner sc = new Scanner(System.in);
				Socket ss = new Socket(sc.next(), sc.nextInt());
				DataOutputStream out = new DataOutputStream(ss.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(ss.getInputStream())) {

			sc.nextLine();

			System.out.println("Enter Subject");
			out.writeUTF(sc.next());

			System.out.println(in.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
