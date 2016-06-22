package model;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class FreeSeatsTest {

	@Test
	public void testAddPassenger() {
		FreeSeats seats = new FreeSeats();
		int number = seats.addPassenger();
		assertEquals(1, number);
	}
	
	@Test
	public void testAddPassenger1() {
		FreeSeats seats = new FreeSeats();
		seats.setSeatNumber(51);
		int number = seats.addPassenger();
		assertEquals(-1, number);
	}
	
	@Test
	public void testAddPassenger2() {
		FreeSeats seats = new FreeSeats();
		seats.setSeatNumber(51);
		seats.addPassenger();
		int number = seats.getSeatNumber();
		assertEquals(50, number);
	}

	@Ignore
	@Test
	public void testGetFreeSeats() {
		fail("Not yet implemented");
	}

}
