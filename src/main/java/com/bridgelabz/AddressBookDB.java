package com.bridgelabz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookDB {
    private Connection connection = new ConnectionFile().dbConnection();

    //Empty Constructor To throw exception
	public AddressBookDB() throws SQLException, ClassNotFoundException{ }

    public ResultSet retrieveAllContacts() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM address_book;";
        Statement statement = connection.createStatement();
       	ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
		
	}    
}
