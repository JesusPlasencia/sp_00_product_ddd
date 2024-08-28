package topco.market.product.repository;

import org.springframework.data.repository.CrudRepository;
import topco.market.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
