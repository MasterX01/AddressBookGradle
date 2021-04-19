package com.bridgelabz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<Person> retrieveForDateRange(String startDate, String endDate) throws ClassNotFoundException, SQLException {
		ResultSet resultSet = new AddressBookDB().retrieveForDateRange(startDate, endDate);
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

	public int countByCityOrState(String city, String state) throws ClassNotFoundException, SQLException {
		ResultSet resultSet = new AddressBookDB().countByCityOrState(city, state);
		if(resultSet.next()){
			return resultSet.getInt(1);
		}
		return resultSet.getInt(1);
	}

	public List<Person> addContact(String fname, String lname, String address, String city, String state, int zip, long phone,
			String email, String type) throws ClassNotFoundException, SQLException {
		int success = new AddressBookDB().addContact(fname, lname, address, city, state, zip, phone, email, type);
		if(success != 1){
			System.exit(0);
		}
		return this.retrieveAllContacts();
	}

    public void addListOfContacts(List<Person> asList) throws InterruptedException {
		Map<Integer, Boolean>  threadStatus = new HashMap<Integer, Boolean>();
		asList.forEach(Person ->{
			Runnable task = () -> {
				threadStatus.put(Person.hashCode(), true);
				try {
					int countSuccess = new AddressBookDB().addContact(Person.firstName, 
																		Person.lastName, 
																		Person.address, 
																		Person.city, 
																		Person.state, 
																		Person.zipInt, 
																		Person.pNoInt,
																		Person.email,
																		Person.type);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				threadStatus.put(Person.hashCode(), false); 
			};
			Thread thread = new Thread(task, Person.firstName);
			thread.start();
		});
		while(threadStatus.containsValue(true)){
			Thread.sleep(100);
		}
		Thread.sleep(4000);
    }
}
