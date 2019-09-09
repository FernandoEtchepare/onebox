package main.java.trains.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import main.java.trains.model.Route;

public class LoadingController {

	/**
	 * @param graph String[] array of routes to put in memory
	 * @return List routes of valid towns and the distances between them
	 */
	public List<Route> loadRoutes(String graph[]) {
		Stream<String> stream = Arrays.stream(graph);
		return stream.filter(route -> validateRoute(route)).map(route -> new Route(route.charAt(0), route.charAt(1),
				Integer.valueOf(route.substring(2, route.length())))).collect(Collectors.toList());
	}

	/**
	 * @param route String route to valid
	 * @return boolean checks that the input verifies the mask LLDDDD.. (L: letter,
	 *         D: digit)
	 */
	private boolean validateRoute(String route) {
		return route.length() >= 3 && Character.isLetter(route.charAt(0)) && Character.isLetter(route.charAt(1))
				&& StringUtils.isNumeric(route.substring(2, route.length()));
	}
}
