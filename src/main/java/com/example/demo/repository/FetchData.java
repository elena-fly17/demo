package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FetchData {

    // Про final: Если объект DataSource неизменяем, это служит "блокировкой"
    // на изменение соединения с БД. Такие объекты часто предназначены
    // для представления конфигурацион. параметров соединения, их неизменяемость
    // гарантирует, что эти параметры не будут случайно изменены в ходе работы приложения
    private final DataSource dataSource;


    public FetchData(@Qualifier("hikariH2DataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> execute() throws SQLException {
        List<String> brands = new ArrayList<>();
        String sqlQuery = "SELECT brand FROM TESTDB.PUBLIC.CARS";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String brand = rs.getString("brand");
                brands.add(brand);
            }
        }
        return brands;
    }
}
