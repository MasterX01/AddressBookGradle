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
		Assert.assertEquals(1, personList.size());
	}
}
