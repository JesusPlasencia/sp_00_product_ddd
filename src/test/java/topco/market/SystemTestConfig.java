package topco.market;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class SystemTestConfig {

    @Bean
    public DataSource dataSource(){
        return
                (new EmbeddedDatabaseBuilder())
                        .addScript("classpath:marketdb/schema.sql")
                        .addScript("classpath:marketdb/data.sql")
                        .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}
