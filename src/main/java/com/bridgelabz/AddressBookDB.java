package com.bridgelabz;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public int updateAddress(String firstName, String lastName, String newAddress) throws SQLException {
        String query = "update address_book set address=? where fname=? and lname=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newAddress);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, lastName);
        return preparedStatement.executeUpdate();
    }

    public ResultSet retrieveSingleContact(String firstName, String lastName) throws SQLException {
        String query = "SELECT * FROM address_book where fname=? and lname=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        return preparedStatement.executeQuery();
    }

    public ResultSet retrieveForDateRange(String startDate, String endDate) throws SQLException {
        String query = "select * from address_book where date_added between cast(? as date) and cast(? as date);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, startDate);
        preparedStatement.setString(2, endDate);
        return preparedStatement.executeQuery();
    }

    public ResultSet countByCityOrState(String city, String state) throws SQLException {
        String query = "select count(*) from address_book where city=? or state=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, city);
        preparedStatement.setString(2, state);
        return preparedStatement.executeQuery();
    }

}
