package main.java.trains.view;

import java.util.List;
import java.util.Scanner;

import main.java.trains.controller.DistanceController;
import main.java.trains.controller.LoadingController;
import main.java.trains.model.Route;

/**
 * @author Fernando Etchepare
 *
 */
public class Trains {

	private static Scanner scanner;

	/**
	 * @return	the distance between a set of input towns
	 */
	public static void main(String[] args) {
		LoadingController loader = new LoadingController();
		DistanceController calculator = new DistanceController();
		String graph[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
		List<Route> routes = loader.loadRoutes(graph);
		scanner = new Scanner(System.in);
		char town;
		String towns = "";
		Integer q = 1;
		System.out.print("Please, type the town #" + q + " and press ENTER (finish town input with *): ");
		town = Character.toUpperCase(scanner.next().charAt(0));
		while (town != '*') {
			while (town != '*' && !validateTown(routes, town)) {
				System.out.print("Please, type the town #" + q + " and press ENTER (finish town input with *): ");
				town = Character.toUpperCase(scanner.next().charAt(0));
			}
			if (town == '*') {
				break;
			}
			towns += town;
			q++;
			System.out.print("Please, type the town #" + q + " and press ENTER (finish town input with *): ");
			town = Character.toUpperCase(scanner.next().charAt(0));
		}
		if (towns.isEmpty()) {
			return;
		}
		String distance = calculator.calculate(routes, towns.toCharArray());
		System.out.format("The distance is %s.", distance);
	}

	/**
	 * @param routes list of all the combinations of routes and distances between
	 *               the towns
	 * @param arg    char name of town typed by the user
	 * @return boolean validates if town typed is a letter and it exists in the
	 *         domain of towns
	 */
	private static boolean validateTown(final List<Route> routes, final char arg) {
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
