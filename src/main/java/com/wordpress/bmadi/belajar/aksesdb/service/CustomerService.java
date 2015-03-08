package com.wordpress.bmadi.belajar.aksesdb.service;

import com.wordpress.bmadi.belajar.aksesdb.dao.CustomerDao;
import com.wordpress.bmadi.belajar.aksesdb.model.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class CustomerService {

    private CustomerDao customerDao;
    private Connection connection;

    public void setDataSource(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
            customerDao = new CustomerDao();
            customerDao.setConnection(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Customer save(Customer c) {
        try {
            connection.setAutoCommit(false);
            customerDao.save(c);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return c;
    }

    public Customer delete(Customer c) {
        try {
            connection.setAutoCommit(false);
            customerDao.delete(c);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    public Customer getCustomerById(Integer id) {
        try {
            return customerDao.getById(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Customer getCustomerByEmail(String email) {
        try {
            return customerDao.getByEmails(email);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Customer> getCustomers() {
        try {
            return customerDao.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<Customer>();
    }
}
