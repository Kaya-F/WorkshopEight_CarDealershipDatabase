package com.kf;

import org.apache.commons.dbcp2.BasicDataSource;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();

        String username = args[0];
        String password = args[1];

        basicDataSource.setUrl("jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_4fe1d93c00fe86e?reconnect=true");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        DealershipDAO dealershipDAO = new DealershipDAO(basicDataSource);

        List<Dealership> dealerships = dealershipDAO.getAll();
        System.out.println(dealerships);
    }
}