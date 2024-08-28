package topco.market;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import topco.market.product.entities.Product;
import topco.market.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@SpringBootApplication
public class MarketApplication {

	private static Logger logger = Logger.getLogger(MarketApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductRepository repository) {
		return args -> {
			Product product = new Product();
			product.setName("Samsung TV 27inch 1920x1080");
			product.setPrice(new BigDecimal("750.00"));
			repository.save(product);

			Product saved = repository.findById(product.getId()).orElseThrow(NoSuchElementException::new);
			logger.info("Product: " + saved.getName());
		};
	}

}
