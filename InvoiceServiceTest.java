package com.Bridgelabz.CabInvoiceGenerator;

import org.junit.*;

import org.junit.jupiter.api.Test;

class InvoiceServiceTest {
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(25, fare, 0.0);
	}
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		Rides[] rides = { new Rides(2.0, 5),new Rides(0.1, 1)};
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		assertEquals(expectedInvoiceSummary, summary);
	}
}