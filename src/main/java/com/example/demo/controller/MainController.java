package com.example.demo.controller;

import com.example.demo.repository.FetchData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MainController {

    private final FetchData fetchData;

    public MainController(FetchData fetchData) {
        this.fetchData = fetchData;
    }

    @GetMapping("/brands")
    public List<String> getBrands() {
        try {
            return fetchData.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return Stream
                    .of("SQL exception was thrown")
                    .collect(Collectors.toList());
        }
    }
}

