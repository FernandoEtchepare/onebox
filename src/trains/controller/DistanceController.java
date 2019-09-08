package trains.controller;

import java.util.List;

import trains.model.Route;

public class DistanceController {

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

	private Integer validateRoute(final List<Route> routes, final char origin, final char destination) {
		Route route = routes.stream().filter(r -> r.getOrigin() == origin && r.getDestination() == destination)
				.findAny().orElse(null);
		if (route == null) {
			return null;
		}
		return route.getDistance();
	}
}
