package trains.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import trains.model.Route;

public class LoadingController {

	public List<Route> loadRoutes(String graph[]) {
		Stream<String> stream = Arrays.stream(graph);
		return stream.filter(route -> validateRoute(route)).map(route -> new Route(route.charAt(0), route.charAt(1),
				Integer.valueOf(route.substring(2, route.length())))).collect(Collectors.toList());
	}

	private boolean validateRoute(String route) {
		return route.length() >= 3 && Character.isLetter(route.charAt(0)) && Character.isLetter(route.charAt(1))
				&& StringUtils.isNumeric(route.substring(2, route.length()));
	}
}
