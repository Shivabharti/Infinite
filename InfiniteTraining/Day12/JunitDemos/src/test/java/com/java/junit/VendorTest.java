package com.java.junit;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class VendorTest {

	@Test
	public void testToString() {
		Date date = new Date();
		Vendor ven = new Vendor(1, "Something", "Sikkim", "something@gmail.com", "9090987654", "Checked", date, 4.5,
				"Good");
		String result = "Vendor [vendorId=1, vendorName=Something, vendorCity=Sikkim, vendorEmail=something@gmail.com, vendorMobile=9090987654, vendorStatus=Checked, vendorStartedDate="
				+ date + ", vendorRating=4.5, vendorReview=Good]";
		assertEquals(result, ven.toString());
	}

	@Test
	public void testGetterAndSetter() {
		Vendor ven = new Vendor();
		ven.setVendorId(1);
		ven.setVendorName("Something");
		ven.setVendorCity("Sikkim");
		ven.setVendorEmail("something@gmail.com");
		ven.setVendorMobile("9090987654");
		ven.setVendorStatus("Checked");
		ven.setVendorStartedDate(new Date());
		ven.setVendorRating(4.5);
		ven.setVendorReview("Good");

		assertEquals(1, ven.getVendorId());
		assertEquals("Something", ven.getVendorName());
		assertEquals("Sikkim", ven.getVendorCity());
		assertEquals("something@gmail.com", ven.getVendorEmail());
		assertEquals("9090987654", ven.getVendorMobile());
		assertEquals("Checked", ven.getVendorStatus());
		assertEquals(new Date(), ven.getVendorStartedDate());
		assertEquals(4.5, ven.getVendorRating(), 0);
		assertEquals("Good", ven.getVendorReview());

	}

	@Test
	public void testConstructor() {
		Vendor vendor = new Vendor();
		assertNotNull(vendor);

		Vendor ven = new Vendor(1, "Something", "Sikkim", "something@gmail.com", "9090987654", "Checked", new Date(),
				4.5, "Good");
		assertEquals(1, ven.getVendorId());
		assertEquals("Something", ven.getVendorName());
		assertEquals("Sikkim", ven.getVendorCity());
		assertEquals("something@gmail.com", ven.getVendorEmail());
		assertEquals("9090987654", ven.getVendorMobile());
		assertEquals("Checked", ven.getVendorStatus());
		assertEquals(new Date(), ven.getVendorStartedDate());
		assertEquals(4.5, ven.getVendorRating(), 0);
		assertEquals("Good", ven.getVendorReview());

	}

	@Test
	public void testEqualsHashcode() {
		Date date = new Date();
		Vendor ven = new Vendor(1, "Something", "Sikkim", "something@gmail.com", "9090987654", "Checked", date, 4.5,
				"Good");
		Vendor ven2 = new Vendor(1, "Something", "Sikkim", "something@gmail.com", "9090987654", "Checked", date, 4.5,
				"Good");
		Assert.assertTrue(ven.equals(ven2) && ven2.equals(ven));
		Assert.assertTrue(ven.hashCode() == ven2.hashCode());

		
	}

}
