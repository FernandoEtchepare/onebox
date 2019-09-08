package trains;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import trains.controller.DistanceController;
import trains.controller.LoadingController;
import trains.model.Route;

public class StructureTest {

	@Test
	public void testMain() {
		LoadingController loadingController = new LoadingController();
		String graph[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };

		List<Route> routes = loadingController.loadRoutes(graph);
		assertTrue(routes != null && routes.size() == graph.length);

		DistanceController calculator = new DistanceController();

		// The distance of the route A-B-C.
		System.out.format("Output #1: %s", calculator.calculate(routes, new char[] { 'A', 'B', 'C' }));
		System.out.println();
		// The distance of the route A-D.
		System.out.format("Output #2: %s", calculator.calculate(routes, new char[] { 'A', 'D' }));
		System.out.println();
		// The distance of the route A-D-C.
		System.out.format("Output #3: %s", calculator.calculate(routes, new char[] { 'A', 'D', 'C' }));
		System.out.println();
		// The distance of the route A-E-B-C-D.
		System.out.format("Output #4: %s", calculator.calculate(routes, new char[] { 'A', 'E', 'B', 'C', 'D' }));
		System.out.println();
		// The distance of the route A-E-D.
		System.out.format("Output #5: %s", calculator.calculate(routes, new char[] { 'A', 'E', 'D' }));
	}

}
