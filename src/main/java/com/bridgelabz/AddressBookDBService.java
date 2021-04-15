package com.bridgelabz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
	
	List<Person> personList = new ArrayList<>();;
	
	public List<Person> retrieveAllContacts() throws ClassNotFoundException, SQLException{
		Person person = new Person();
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
}
