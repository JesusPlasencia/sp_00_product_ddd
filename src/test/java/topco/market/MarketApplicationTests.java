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
import topco.market.product.infrastructure.ProductRepository;

import javax.sql.DataSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = { SystemTestConfig.class })
class MarketApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DataSource dataSource;

//	@Autowired
//	ProductRepository productRepository;

	JdbcTemplate jdbcTemplate;

	@BeforeEach
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		// Using Logback for logging. Enable DEBUG logging so we can see the transactions
		Logger jdbcLogger = (Logger) LoggerFactory.getLogger("org.springframework.jdbc.datasource.DataSourceTransactionManager");
		jdbcLogger.setLevel(Level.DEBUG);
	}

	@Test
	public void testBrandDataIngestion() {
		String sql = "SELECT COUNT(*) FROM T_BRAND";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		assertEquals(60, count);
	}

	@Test
	public void testNotEqualProductDataIngestion() {
		String sql = "SELECT COUNT(*) FROM T_PRODUCT";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		assertNotEquals(4, count);
	}

	@Test
	public void testEqualProductDataIngestion() {
		String sql = "SELECT COUNT(*) FROM T_PRODUCT";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		assertEquals(5, count);
	}

	@Test
	public void testHexadecimalGeneratedId() {
		for (int i = 1; i <= 1000; i++) {
			String sql = "select next value for S_PRODUCT_NUMBER from DUAL_PRODUCT_NUMBER";
			Long out = jdbcTemplate.queryForObject(sql, Long.class);
			String hexVal = String.format("%06X", out);  // Convert to hex and pad to 6 characters
			System.out.println("PRODUCT ID " + i + " : " + hexVal);
		}
	}

}
