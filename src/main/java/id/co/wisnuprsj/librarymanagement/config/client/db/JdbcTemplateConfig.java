package id.co.wisnuprsj.librarymanagement.config.client.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    @Autowired
    @Qualifier("bn-playground")
    private DataSource playgroundDataSource;

    @Bean("jdbc-playground")
    public JdbcTemplate playgroundJdbcTemplate() {
        return new JdbcTemplate(playgroundDataSource);
    }

}
