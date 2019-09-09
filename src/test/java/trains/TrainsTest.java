package test.java.trains;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.java.trains.controller.DistanceController;
import main.java.trains.controller.LoadingController;
import main.java.trains.model.Route;

public class TrainsTest {

	@Test
	public void testMain() {
		LoadingController loadingController = new LoadingController();
		String graph[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };

		List<Route> routes = loadingController.loadRoutes(graph);
		assertTrue(routes != null && routes.size() == graph.length);

		DistanceController calculator = new DistanceController();

		// The distance of the route A-B-C.
		assertTrue("Route A-B-C should be 9", calculator.calculate(routes, new char[] { 'A', 'B', 'C' }).equals("9"));
		System.out.format("Output #1: %s", calculator.calculate(routes, new char[] { 'A', 'B', 'C' }));
		System.out.println();
		// The distance of the route A-D.
		assertTrue("Route A-D should be 5", calculator.calculate(routes, new char[] { 'A', 'D' }).equals("5"));
		System.out.format("Output #2: %s", calculator.calculate(routes, new char[] { 'A', 'D' }));
		System.out.println();
		// The distance of the route A-D-C.
		assertTrue("Route A-D-C should be 9", calculator.calculate(routes, new char[] { 'A', 'D', 'C' }).equals("13"));
		System.out.format("Output #3: %s", calculator.calculate(routes, new char[] { 'A', 'D', 'C' }));
		System.out.println();
		// The distance of the route A-E-B-C-D.
		assertTrue("Route A-E-B-C-D should be 22", calculator.calculate(routes, new char[] { 'A', 'E', 'B', 'C', 'D' }).equals("22"));
		System.out.format("Output #4: %s", calculator.calculate(routes, new char[] { 'A', 'E', 'B', 'C', 'D' }));
		System.out.println();
		// The distance of the route A-E-D.
		assertTrue("Route A-E-B-C-D shouldn't exist", calculator.calculate(routes, new char[] { 'A', 'E', 'D' }).equals("NO SUCH ROUTE"));
		System.out.format("Output #5: %s", calculator.calculate(routes, new char[] { 'A', 'E', 'D' }));
	}

}
