package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// Аннотация @Configuration указывает, что класс является конфигурационным -
// он может содержать определения бинов и др. конфиги. В конфиг-классе
// можно использовать аннотацию @Bean для определения методов, возвращающих объекты,
// которые будут управляться Spring-контейнером как бины
@Configuration
public class DataSourceConfig {

    // В Spring Boot есть автонастройка для пула Hikari - не нужно явно создавать
    // бин HikariDataSource. Spring Boot позволяет настроить параметры пула
    // в application.properties, и автоматически создаст HikariDataSource с этими настройками.
    // Если ваши требования к настройке пула более сложны, и нужна более тонкая настройка,
    // то создание явного бина HikariDataSource в конфиг-классе может быть предпочтительнее
    @Bean
    public DataSource hikariH2DataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.h2.Driver");
        config.setJdbcUrl("jdbc:h2:mem:testdb;OLD_INFORMATION_SCHEMA=TRUE;MODE=PostgreSQL");
        config.setUsername("user");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        config.setConnectionTimeout(20000);
        config.setMinimumIdle(5);
        config.setMaxLifetime(900000);

        return new HikariDataSource(config);
    }
}
