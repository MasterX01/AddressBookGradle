package com.bridgelabz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
	
	List<Person> personList = new ArrayList<>();
	Person person = new Person();

	
	public List<Person> retrieveAllContacts() throws ClassNotFoundException, SQLException{
		ResultSet resultSet = new AddressBookDB().retrieveAllContacts();
		while(resultSet.next()){
			person.setFirstName(resultSet.getString(1));
			person.setLastName(resultSet.getString(2));
			person.setAddress(resultSet.getString(3));
			person.setCity(resultSet.getString(4));
			person.setState(resultSet.getString(5));
			person.setZipInt(resultSet.getInt(6));
			person.setpNoInt(resultSet.getLong(7));
			person.setEmail(resultSet.getString(8));
			person.setType(resultSet.getString(9));
			personList.add(person);
		}
		return personList;
	}

	public int updateAddress(String firstName, String lastName, String newAddress) throws ClassNotFoundException, SQLException {
		return new AddressBookDB().updateAddress(firstName, lastName, newAddress);
	}

	public List<Person> retrieveContact(String firstName, String lastName) throws ClassNotFoundException, SQLException {
		ResultSet resultSet = new AddressBookDB().retrieveSingleContact(firstName, lastName);
		while(resultSet.next()){
			person.setFirstName(resultSet.getString(1));
			person.setLastName(resultSet.getString(2));
			person.setAddress(resultSet.getString(3));
			person.setCity(resultSet.getString(4));
			person.setState(resultSet.getString(5));
			person.setZipInt(resultSet.getInt(6));
			person.setpNoInt(resultSet.getLong(7));
			person.setEmail(resultSet.getString(8));
			person.setType(resultSet.getString(9));
			personList.add(person);
		}
		return personList;
	}
}
