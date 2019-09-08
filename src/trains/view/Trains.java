/**
 * 
 */
package trains.view;

import java.util.List;
import java.util.Scanner;

import trains.controller.DistanceController;
import trains.controller.LoadingController;
import trains.model.Route;

/**
 * @author Fernando Etchepare
 *
 */
public class Trains {

	private static Scanner scanner;

	public static void main(String[] args) {
		LoadingController loader = new LoadingController();
		DistanceController calculator = new DistanceController();
		String graph[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
		List<Route> routes = loader.loadRoutes(graph);
		scanner = new Scanner(System.in);
		char town;
		String towns = "";
		Integer q = 1;
		System.out.println("Please, type the town #" + q + " and press ENTER (finish town input with *):");
		town = Character.toUpperCase(scanner.next().charAt(0));
		while (town != '*') {
			while (town != '*' && !validateTown(routes, town)) {
				System.out.println("Please, type the town #" + q + " and press ENTER (finish town input with *):");
				town = Character.toUpperCase(scanner.next().charAt(0));
			}
			if (town == '*') {
				break;
			}
			towns += town;
			q++;
			System.out.println("Please, type the town #" + q + " and press ENTER (finish town input with *):");
			town = Character.toUpperCase(scanner.next().charAt(0));
		}
		if (towns.isEmpty()) {
			return;
		}
		String distance = calculator.calculate(routes, towns.toCharArray());
		System.out.format("The distance is %s.", distance);
	}

	private static boolean validateTown(List<Route> routes, char arg) {
		boolean isLetter = Character.isLetter(arg);
		boolean isTown = false;
		if (!isLetter) {
			System.out.println("The input must be a letter representing a town!");
		} else {
			isTown = routes.stream().anyMatch(route -> route.getOrigin() == arg || route.getDestination() == arg);
			if (!isTown) {
				System.out.println("The input is not a valid town!");
			}
		}
		return isLetter && isTown;
	}

}
