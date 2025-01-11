package id.co.wisnuprsj.librarymanagement.config.client.db;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean("bn-playground")
    @ConfigurationProperties("datasource.playground")
    @Primary
    public DataSource loadPlaygroundDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
