package topco.market;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = { SystemTestConfig.class })
class MarketApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DataSource dataSource;

	JdbcTemplate jdbcTemplate;

	@BeforeEach
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		// Using Logback for logging. Enable DEBUG logging so we can see the transactions
		Logger jdbcLogger = (Logger) LoggerFactory.getLogger("org.springframework.jdbc.datasource.DataSourceTransactionManager");
		jdbcLogger.setLevel(Level.DEBUG);
	}

	@Test
	public void testDataIngestion() {
		String sql = "SELECT COUNT(*) FROM T_BRAND";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		assertEquals(60, count);
	}

}
