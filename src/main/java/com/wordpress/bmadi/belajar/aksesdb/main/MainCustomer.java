package com.wordpress.bmadi.belajar.aksesdb.main;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MainCustomer {

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("java");
        dataSource.setDatabaseName("dbdao");
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);

        // untuk mengetestnya silahkan buka schema-sql.sql

    }

}
