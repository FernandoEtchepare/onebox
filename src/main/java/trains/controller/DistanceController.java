package main.java.trains.controller;

import java.util.List;

import main.java.trains.model.Route;

public class DistanceController {

	/**
	 * @param routes routes list of all the combinations of routes and distances
	 *               between the towns
	 * @param char[] route list of towns to calculate the distance from
	 * @return String String of a numeric value representing the sum of the distance
	 *         or "NO SUCH ROUTE" if the route doesn't exist
	 */
	public String calculate(final List<Route> routes, final char[] route) {
		Integer totalDistance = 0;
		Integer pos = 0;
		while (pos < route.length - 1) {
			Integer distance = validateRoute(routes, route[pos], route[pos + 1]);
			if (distance != null) {
				totalDistance += distance;
			} else {
				return "NO SUCH ROUTE";
			}
			pos++;
		}
		return totalDistance.toString();
	}

	/**
	 * @param routes routes list of all the combinations of routes and distances
	 *               between the towns
	 * @param origin char representing origin town
	 * @param origin char representing destination town
	 * @return Integer distance between origin and destination
	 */
	private Integer validateRoute(final List<Route> routes, final char origin, final char destination) {
		Route route = routes.stream().filter(r -> r.getOrigin() == origin && r.getDestination() == destination)
				.findAny().orElse(null);
		if (route == null) {
			return null;
		}
		return route.getDistance();
	}
}
