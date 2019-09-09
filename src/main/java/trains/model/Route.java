package main.java.trains.model;

public class Route {
	private char origin;
	private char destination;
	private Integer distance;

	public Route(final char origin, final char destination, final Integer distance) {
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}

	public char getOrigin() {
		return origin;
	}

	public void setOrigin(final char origin) {
		this.origin = origin;
	}

	public char getDestination() {
		return destination;
	}

	public void setDestination(final char destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(final int distance) {
		this.distance = distance;
	}

}
