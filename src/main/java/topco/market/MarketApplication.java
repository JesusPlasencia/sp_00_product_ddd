package topco.market;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import topco.market.product.domain.Brand;
import topco.market.product.domain.Category;
import topco.market.product.domain.Product;
import topco.market.product.infrastructure.BrandRepository;
import topco.market.product.infrastructure.CategoryRepository;
import topco.market.product.infrastructure.ProductRepository;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@SpringBootApplication
public class MarketApplication {

	private static Logger logger = Logger.getLogger(MarketApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runMockData(CategoryRepository laptopRepository, BrandRepository brandRepository, ProductRepository productRepository) {
//		return args -> {
//			Category laptop = new Category();
//			laptop.setLabel("NOTEBOOK");
//			laptopRepository.save(laptop);
//
//			Brand hp = new Brand();
//			hp.setName("HP");
//			brandRepository.save(hp);
//			Brand lenovo = new Brand();
//			lenovo.setName("LENOVO");
//			brandRepository.save(lenovo);
//
//			Product productA = new Product();
//			productA.setName("Notebook HP 250 G9, 15.6\" LCD LED HD SVA, Core i3-1215U 1.20 / 4.40GHz, 8GB DDR4-3200MHz");
//			productA.setPrice(new BigDecimal("2500.00"));
//			productA.setBrand(hp);
//			productA.setCategory(laptop);
//			productRepository.save(productA);
//
//			Product productB = new Product();
//			productB.setName("Notebook HP 250 G10, 15.6\" LCD LED HD, Core i3-1315U hasta 4.50GHz, 8GB DDR4-3200MHz");
//			productB.setPrice(new BigDecimal("2999.00"));
//			productB.setBrand(hp);
//			productB.setCategory(laptop);
//			productRepository.save(productB);
//
//			Product productC = new Product();
//			productC.setName("Notebook Lenovo V15 G3 IAP 15.6\" FHD TN, Core i3-1215U 1.2 / 4.4GHz, 8GB DDR4-3200MHz");
//			productC.setPrice(new BigDecimal("3200.00"));
//			productC.setBrand(lenovo);
//			productC.setCategory(laptop);
//			productRepository.save(productC);
//
//			Product productD = new Product();
//			productD.setName("Notebook Lenovo V15 G3 IAP 15.6\" FHD TN, Core i3-1215U 1.2 / 4.4GHz, 8GB DDR4-3200MHz 256G");
//			productD.setPrice(new BigDecimal("2300.00"));
//			productD.setBrand(lenovo);
//			productD.setCategory(laptop);
//			productRepository.save(productD);
//
//			Product productE = new Product();
//			productE.setName("Notebook Lenovo V15 G3 IAP 15.6\" FHD TN, Core i3-1215U 1.2 / 4.4GHz, 8GB DDR4-3200MHz 512GB");
//			productE.setPrice(new BigDecimal("2300.00"));
//			productE.setBrand(lenovo);
//			productE.setCategory(laptop);
//			productRepository.save(productE);
//		};
//	}

}
