package com.example.gymmanagement.data.model;

import com.example.gymmanagement.data.entity.Customers;
import com.example.gymmanagement.data.entity.Payment;
import com.example.gymmanagement.data.entity.Users;
import com.example.gymmanagement.dependencies.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CustomerModel {
    private static final Connection connection = DbConnection.getConnection();

    public void insert(Customers customer) throws SQLException {
        String insertQuery = "INSERT INTO customers(first_name, middle_name, last_name, contacts, gander, shift, address," +
                " weight, height, waist, note, who_added, image)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
        insertOrUpdateStatement(customer, insertQuery, true);
    }

    public void update(Customers customer) throws SQLException {
        String updateQuery = "UPDATE customers SET first_name=?,middle_name=?,last_name=?,contacts=?,gander=?,shift=?, "
                + "address=?,weight=?,height=?,waist=?,note=?,image=? WHERE customer_id=" + customer.getCustomerId();
        insertOrUpdateStatement(customer, updateQuery, false);
    }

    public ObservableList<Customers> fetchAllCustomers(Users activeUser) throws SQLException {
        ObservableList<Customers> customers = FXCollections.observableArrayList();
        String fetchCustomers = fetchByRoleAndGander(activeUser.getGender(), activeUser.getRole());
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(fetchCustomers);


        while (rs.next()) {
            String customerPhone = rs.getString("phone");
            ObservableList<Payment> payments =
                    PaymentService.fetchAllPayments(customerPhone);
            getCustomers(customers, rs, payments);
        }

        rs.close();
        statement.close();
        return customers;
    }

    //-----------------------------Helpers------------------–
    private void insertOrUpdateStatement(Customers customer, String query, boolean insert) throws SQLException {
        connection.setAutoCommit(false);
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getMiddleName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getContacts());
            ps.setString(5, customer.getGander());
            ps.setString(6, customer.getShift());
            ps.setString(7, customer.getAddress());
            ps.setDouble(8, customer.getWeight());
            ps.setDouble(9, customer.getHeight());
            ps.setDouble(10, customer.getWaist());
            ps.setString(11, customer.getNote());
            if (insert) {
                ps.setString(12, customer.getWhoAdded());
                ps.setBytes(13, customer.getImage());
            } else {
                ps.setBytes(12, customer.getImage());
            }
            ps.executeUpdate();
            ps.close();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }
    public int nextID() throws SQLException {
        String query = "SELECT * FROM SQLITE_SEQUENCE WHERE name='customers'";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        if (rs.next()) {
            return rs.getInt("seq");
        }

        return 0;
    }

    private String fetchByRoleAndGander(String gander, String role) {
        String fetchQuery = "SELECT * FROM customers WHERE gander='" + gander + "' ORDER BY customer_id ";
        if (role.equals("admin")) {
            fetchQuery = "SELECT * FROM customers ORDER BY customer_id ";
        }
        return fetchQuery;
    }

}
