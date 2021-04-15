package com.bridgelabz;

import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressBoookDBTest {
	AddressBookDBService addressBookDBService = new AddressBookDBService();

	@Test
	public void givenDB_ShouldReturnAllEntriesInDB() throws ClassNotFoundException, SQLException {
		List<Person> personList = addressBookDBService.retrieveAllContacts();
		Assert.assertEquals(2, personList.size());
	}

	@Test
	public void givenNameAndAddress_afterUpdate_ShouldMatchGivenAddress() throws ClassNotFoundException, SQLException{
		String firstName = "Akash";
		String lastName = "Saxena";
		String newAddress = "327, Riddhi Siddhi Nagar 1st";
		int success = addressBookDBService.updateAddress(firstName, lastName, newAddress);
		Assert.assertEquals(1, success);
		List<Person> personList = addressBookDBService.retrieveContact(firstName, lastName);
		Assert.assertEquals(newAddress, personList.get(0).getAddress());
	}

	@Test
	public void givenDateRange_ShouldReturnNoOfEmployeesAddedInDateRange() throws ClassNotFoundException, SQLException{
		String startDate = "2019-01-01";
		String endDate = "2021-05-01";
		List<Person> listPerson = addressBookDBService.retrieveForDateRange(startDate, endDate);
		Assert.assertEquals(1, listPerson.size());
	}

	@Test
	public void givenCityAndState_ShouldReturnCountOfContactsInCityOrState() throws ClassNotFoundException, SQLException{
		String city = "Kota";
		String state = "Gujrat";
		int count = addressBookDBService.countByCityOrState(city, state);
		Assert.assertEquals(2, count);
	}

	@Test
	public void givenContactDetails_whenAddedToDB_ShouldMatchContactCount() throws ClassNotFoundException, SQLException{
		String fname = "Utkarsh";
		String lname = "Kumar";
		String address = "Seelampur, Delhi";
		String city = "Delhi";
		String state = "Delhi";
		int zip = 987654;
		long phone = Long.parseLong("9876543210");
		String email = "utkarsh@gmail.com";
		String type = "Friends";
		List<Person> personList = addressBookDBService.addContact(fname, lname, address, city, state, zip, phone, email, type);
		Assert.assertEquals(3, personList.size());
	}
}
