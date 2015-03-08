package com.wordpress.bmadi.belajar.aksesdb.dao;

import com.wordpress.bmadi.belajar.aksesdb.model.Customer;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private Connection connection;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getByEmailStatement;
    private PreparedStatement getAllStatement;

    private final String insertQuery = "INSERT INTO t_customer(firstName, secondName, emails, phone) VALUES (?, ?, ?, ?)";
    private final String updateQuery = "UPDATE t_customer SET firstName=?, secondName=?, emails=?, phone=? WHERE id=?";
    private final String deleteQuery = "DELETE FROM t_customer WHERE id = ?";
    private final String getByIdQuery = "SELECT * FROM t_customer WHERE id=?";
    private final String getByEmailQuery = "SELECT * FROM t_customer WHERE emails=?";
    private final String getAllQuery = "SELECT * FROM t_customer";

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        insertStatement = this.connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        updateStatement = this.connection.prepareStatement(updateQuery);
        deleteStatement = this.connection.prepareStatement(deleteQuery);
        getByIdStatement = this.connection.prepareStatement(getByIdQuery);
        getByEmailStatement = this.connection.prepareStatement(getByEmailQuery);
        getAllStatement = this.connection.prepareStatement(getAllQuery);
    }
    
     public Customer save(Customer c) throws SQLException {
        if (c.getId() == null) {
            insertStatement.setString(1, c.getFirstName());
            insertStatement.setString(2, c.getSecondName());
            insertStatement.setString(3, c.getEmails());
            insertStatement.setString(4, c.getPhone());

            int id = insertStatement.executeUpdate();
            c.setId(id);
        } else {
            updateStatement.setString(1, c.getFirstName());
            updateStatement.setString(2, c.getSecondName());
            updateStatement.setString(3, c.getEmails());
            updateStatement.setString(4, c.getPhone());
            updateStatement.setInt(5, c.getId());
            updateStatement.executeUpdate();
        }
        return c;
    }

    public Customer delete(Customer c) throws SQLException {
        deleteStatement.setInt(1, c.getId());
        deleteStatement.executeUpdate();
        return c;
    }

    public Customer getById(int id) throws SQLException {
        getByIdStatement.setInt(1, id);
        ResultSet rs = getByIdStatement.executeQuery();
        // Proses mapping dari relational ke object
        if (rs.next()) {
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("firstName"));
            c.setSecondName(rs.getString("secondName"));
            c.setEmails(rs.getString("emails"));
            c.setPhone(rs.getString("phone"));
            return c;
        }
        return null;
    }

    public Customer getByEmails(String email) throws SQLException {
        getByEmailStatement.setString(1, email);
        ResultSet rs = getByEmailStatement.executeQuery();
        // Proses mapping dari relational ke object
        if (rs.next()) {
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("firstName"));
            c.setSecondName(rs.getString("secondName"));
            c.setEmails(rs.getString("emails"));
            c.setPhone(rs.getString("phone"));
            return c;
        }
        return null;
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<Customer>();
        ResultSet rs = getAllStatement.executeQuery();
        while (rs.next()) {
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("firstName"));
            c.setSecondName(rs.getString("secondName"));
            c.setEmails(rs.getString("emails"));
            c.setPhone(rs.getString("phone"));
            customers.add(c);
        }
        return customers;
    }

}
