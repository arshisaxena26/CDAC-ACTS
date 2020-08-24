package tester;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import com.app.core.Car;
import com.app.core.ManufacturerName;

import static com.app.utils.CarValidations.*;

public class TestCar {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			ArrayList<Car.Manufacture> car = new ArrayList<>();

			int counter = 0;
			boolean exit = false;
			boolean carsEntered = false;

			while (!exit) {
				System.out.println("----OPTIONS-----");
				System.out.println("1. Enter Car Details");
				System.out.println("2. Display ALL Car Details");
				System.out.println("3. Cars Manufactured from a Specific Location");
				System.out.println("4. Apply Discounts");
				System.out.println("5. Exit");

				switch (sc.nextInt()) {
				case 1:
					carsEntered = true;

					System.out.println(
							"Enter Car's Registration Number,Manufacture Date(dd-MM-yyyy),Manufacture's Name(Maruti,Honda,Hyundai),Color,Price and Location");
					String regNo = sc.next();
					Date date = sdf.parse(sc.next());
					ManufacturerName company = ManufacturerName.valueOf(sc.next().toUpperCase());

					if (validateCarEntriesDuplication(regNo, date, company, car)) {
						car.add(counter++,
								new Car(regNo, date, sc.next(), sc.nextDouble()).new Manufacture(company, sc.next()));
						System.out.println("Car Entry Added!");

					}
					break;

				case 2:
					if (carsEntered == true) {
						for (Car.Manufacture c : car)
							if (c != null)
								System.out.println("-----Car Details------\n" + c);
					} else
						System.out.println("Enter Car Details First");
					break;
				case 3:
					if (carsEntered == true) {
						System.out.println("Enter Location Name");
						String location = sc.next();

						for (Car.Manufacture c : car) {
							if (c != null)
								if (c.getLocation().equals(location))
									System.out.println("Registration Number:" + c.getRegistrationNo() + "\n Price:"
											+ c.getPrice() + "\n");
						}

					} else
						System.out.println("Enter Car Details First");
					break;

				case 4:
					if (carsEntered == true) {
						System.out.println("Enter Manufacturer Name and Discount(%)");
						String name = sc.next();
						double discount = sc.nextDouble();

						for (Car.Manufacture c : car) {
							if (c != null)
								if (c.getCompanyName().equals(name))
									c.setPrice(c.getPrice() - (discount / 100 * c.getPrice()));

							System.out.println("----Car Details after Discount----\n" + c);
						}

					} else
						System.out.println("Enter Car Details First");
					break;
				case 5:
					System.out.println("GOODBYE!");
					exit = true;
					break;

				default:
					System.out.println("Wrong Input. Try Again!");
					break;
				}
			}
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
