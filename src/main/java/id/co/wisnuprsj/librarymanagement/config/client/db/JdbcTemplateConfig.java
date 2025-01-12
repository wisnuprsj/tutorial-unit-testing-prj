package id.co.wisnuprsj.librarymanagement.config.client.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    private final DataSource playgroundDataSource;

    public JdbcTemplateConfig(@Qualifier("bnPlayground") DataSource dataSource) {
        this.playgroundDataSource = dataSource;
    }

    @Bean("jdbcPlayground")
    public JdbcTemplate playgroundJdbcTemplate() {
        return new JdbcTemplate(playgroundDataSource);
    }

}
