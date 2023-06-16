package com.kf;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DealershipDAO {
    private BasicDataSource basicDataSource;

    public DealershipDAO(BasicDataSource basicDataSource){
        this.basicDataSource = basicDataSource;
    }

    public List<Dealership> getAll() {
        List<Dealership> dealerships = new ArrayList<>();

        String query = "SELECT * FROM dealerships;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");

                Dealership dealership = new Dealership(id, name, address, phone);

                dealerships.add(dealership);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dealerships;
    }

}