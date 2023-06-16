package com.example.gymmanagement.data.model;

import com.example.gymmanagement.data.entity.Customers;
import com.example.gymmanagement.data.entity.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class CustomerModelTest {
    private final CustomerModel model = new CustomerModel();

    @Test
    void insert() throws SQLException {
        Customers customer = new Customers("Nuux", "Digir", "Cali", "4303923", "Male", "Morning",
                null, 60, 1.6, 33, "Waa nin aad u wanagsan wx badana tari kara odeygu", "Moha", null);

        model.insert(customer);
    }

    @Test
    void update() throws SQLException {
        Customers customer = new Customers(2, null, "Nuux", "luuk", "Ruun", "4303923", "Male", "Morning",
                null, 60, 1.6, 33, "Ninkani wax wanaaga maleh", "Moha", null);

        model.update(customer);
    }


}