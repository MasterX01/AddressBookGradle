package com.bridgelabz;

import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressBoookDBTest {

	@Test
	public void givenDB_ShouldReturnAllEntriesInDB() throws ClassNotFoundException, SQLException {
		AddressBookDBService addressBookDBService = new AddressBookDBService();
		List<Person> personList = addressBookDBService.retrieveAllContacts();
		Assert.assertEquals(2, personList.size());
	}

	@Test
	public void givenNameAndAddress_afterUpdate_ShouldMatchGivenAddress() throws ClassNotFoundException, SQLException{
		AddressBookDBService addressBookDBService = new AddressBookDBService();
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
		AddressBookDBService addressBookDBService = new AddressBookDBService();
		String startDate = "2019-01-01";
		String endDate = "2021-05-01";
		List<Person> listPerson = addressBookDBService.retrieveForDateRange(startDate, endDate);
		Assert.assertEquals(1, listPerson.size());
	}
}
