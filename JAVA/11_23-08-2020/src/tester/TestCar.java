package tester;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import com.app.core.Car;
import com.app.core.ManufacturerName;

import static com.app.utils.CarValidations.*;

public class TestCar {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			// Creating an ArrayList of objects of Car
			ArrayList<Car> car = new ArrayList<>();

			int counter = 0;
			boolean exit = false;
			boolean carsEntered = false;

			while (!exit) {
				System.out.println("\n----OPTIONS-----");
				System.out.println("1. Enter Car Details");
				System.out.println("2. Display ALL Car Details");
				System.out.println("3. Cars Manufactured from a Specific Location");
				System.out.println("4. Apply Discounts");
				System.out.println("5. Exit");

				switch (sc.nextInt()) {
				case 1:
					carsEntered = true;

					System.out.println("Enter Car's Registration Number,Manufacture Date(dd-MM-yyyy),Color and Price");
					Car newCar = new Car(sc.next(), sdf.parse(sc.next()), sc.next(), sc.nextDouble());

					System.out.println("Enter Manufacture's Name(Maruti,Honda,Hyundai) and Location");
					newCar.linkVendor(validateManufacturerName(sc.next()), sc.next()); // Calling Car's linkVendor
																						// method

					if (validateCarEntriesDuplication(car, newCar)) { // method present in CarValidations class
						car.add(counter++, newCar); // Adding Car's object to ArrayList if entries unique
						System.out.println("Car Entry Added!");
					}

					break;

				case 2:
					if (carsEntered == true) {
						for (Car c : car)
							if (c != null)
								System.out.println("-----Car Details------" + c);
					} else
						System.out.println("Enter Car Details First");
					break;

				case 3:
					if (carsEntered == true) {
						System.out.println("Enter Location Name");
						String location = sc.next();

						for (Car c : car) {
							if (c != null)
								if (validateLocation(location, car)) // method present in CarVAlidation Class
									System.out.println("Registration Number:" + c.getRegistrationNo() + "\n Price:"
											+ c.getPrice());
						}
					} else
						System.out.println("Enter Car Details First");
					break;

				case 4:
					if (carsEntered == true) {
						System.out.println("Enter Manufacturer Name and Discount(%)");
						ManufacturerName name = validateManufacturerName(sc.next()); // method present in CarVAlidation
																						// Class
						double discount = sc.nextDouble();

						for (Car c : car) {
							if (c != null)
								if (c.getCompanyName().equals(name))
									c.setPrice(c.getPrice() - (discount / 100 * c.getPrice())); // Adding discounts

							System.out.println("----Car Details after Discount----" + c);
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
